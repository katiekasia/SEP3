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

    public async Task<bool> Login(string id, string password)
    {
        LoginDto loginDto = new LoginDto()
        {
            cpr = id,
            password = password
        };
    
        try 
        {
            HttpResponseMessage response = 
                await httpClient.PostAsJsonAsync("http://localhost:8080/Doctor/login", loginDto);
        
            string content = await response.Content.ReadAsStringAsync();

            Console.WriteLine(content);
            var loginResponse = JsonSerializer.Deserialize<ResponseDto>(content, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            });

            if (response.IsSuccessStatusCode && loginResponse?.response == "LoggedIn"){
                Console.WriteLine("yes");
                var claims = new List<Claim>
                {
                    new Claim(ClaimTypes.NameIdentifier, id),
                    new Claim(ClaimTypes.AuthenticationMethod, "apiauth")
                };

                var identity = new ClaimsIdentity(claims, "apiauth");
                currentUser = new ClaimsPrincipal(identity);

                NotifyAuthenticationStateChanged(
                    Task.FromResult(new AuthenticationState(currentUser))
                );
                
                navigationManager.NavigateTo("/Appointments");

                return true;
            }
            else 
            {
                Console.WriteLine("No");
                // Clear any existing user
                currentUser = new ClaimsPrincipal(new ClaimsIdentity());
                NotifyAuthenticationStateChanged(
                    Task.FromResult(new AuthenticationState(currentUser))
                );

                return false;
            }
        }
        catch (HttpRequestException ex)
        {
            // Handle network-related errors
            Console.Error.WriteLine($"Login failed: {ex.Message}");
            return false;
        }
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