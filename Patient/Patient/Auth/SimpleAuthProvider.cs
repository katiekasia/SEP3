using System.Net.Http.Json;
using System.Text.Json;
using Patient.DTOs;

namespace Patient.Auth;

using System.Security.Claims;
using Microsoft.AspNetCore.Components.Authorization;

public class SimpleAuthProvider : AuthenticationStateProvider
{
    private ClaimsPrincipal user = new ClaimsPrincipal(new ClaimsIdentity());
    private readonly HttpClient httpClient;
    
    public SimpleAuthProvider(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    public async Task Login(String cpr, String password)
    {
        HttpResponseMessage response =
            await httpClient.PostAsJsonAsync("http://localhost:8081/Demo/login",
                new LoginDto(cpr, password));
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }
        
        UserDto userDto = JsonSerializer.Deserialize<UserDto>(content,new JsonSerializerOptions { PropertyNameCaseInsensitive = true })!;

            List<Claim> claims = new List<Claim>()
            {
                new Claim(ClaimTypes.Name, userDto.name),
                new Claim(ClaimTypes.Surname, userDto.surname),
                new Claim(ClaimTypes.Email, userDto.email),
                new Claim(ClaimTypes.MobilePhone, userDto.phone),
                new Claim(ClaimTypes.NameIdentifier, userDto.cpr)
            };
            ClaimsIdentity identity = new ClaimsIdentity(claims, "apiauth");

        user = new ClaimsPrincipal(identity);
        NotifyAuthenticationStateChanged(
            Task.FromResult(new AuthenticationState(user)));
    }
    
    public override async Task<AuthenticationState> GetAuthenticationStateAsync()
    {
        return new AuthenticationState(user);
    }

    public void Logout()
    {
        user = new ();
        NotifyAuthenticationStateChanged(
            Task.FromResult(new AuthenticationState(user)));
    }
    
}