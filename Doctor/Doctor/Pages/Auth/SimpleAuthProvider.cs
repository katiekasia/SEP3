using System.Net.Http.Json;
using System.Security.Claims;
using System.Text.Json;
using Doctor.DTOs;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;
namespace Doctor.Pages.Auth;

public class SimpleAuthProvider : AuthenticationStateProvider
{
    private readonly HttpClient httpClient;
    private ClaimsPrincipal currentUser;
    private readonly NavigationManager navigationManager;

    public SimpleAuthProvider(HttpClient httpClient, NavigationManager navigationManager)
    {
        this.httpClient = httpClient;
        this.navigationManager = navigationManager;
    }

    public async Task Login(string id, string password)
    {
        HttpResponseMessage response =
            await httpClient.PostAsJsonAsync("http://localhost:8080/Doctor/login",
                new LoginDto(id, password));
        string content = await response.Content.ReadAsStringAsync();
        Console.WriteLine(content);
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }
        DoctorDto doctor = JsonSerializer.Deserialize<DoctorDto>(content,new JsonSerializerOptions { PropertyNameCaseInsensitive = true })!;

        List<Claim> claims = new List<Claim>()
        {
            new Claim(ClaimTypes.Name, doctor.Name),
            new Claim(ClaimTypes.Surname, doctor.Surname),
            new Claim(ClaimTypes.NameIdentifier, doctor.Id),
            new Claim("Specialisation", doctor.Specialisation)
        };
        
        ClaimsIdentity identity = new ClaimsIdentity(claims, "apiauth");
        currentUser = new ClaimsPrincipal(identity);
        NotifyAuthenticationStateChanged(
            Task.FromResult(new AuthenticationState(new ClaimsPrincipal(currentUser))));
        
    }

    public override async Task<AuthenticationState> GetAuthenticationStateAsync()
    {
        return new AuthenticationState(currentUser ?? new());
    }

    public void Logout()
    {
        currentUser = new();
        NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(new ClaimsPrincipal(currentUser))));
    }
}