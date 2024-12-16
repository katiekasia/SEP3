using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text.Json;
using Microsoft.JSInterop;
using Patient.DTOs;
using Microsoft.AspNetCore.WebUtilities;

namespace Patient.Auth;

using System.Security.Claims;
using Microsoft.AspNetCore.Components.Authorization;


public class SimpleAuthProvider : AuthenticationStateProvider
{
    private ClaimsPrincipal user = new ClaimsPrincipal(new ClaimsIdentity());
    private readonly HttpClient httpClient;
    private readonly IJSRuntime jsRuntime;
    
    public SimpleAuthProvider(HttpClient httpClient, IJSRuntime jsRuntime)
    {
        this.httpClient = httpClient;
        this.jsRuntime = jsRuntime;
    }

    public async Task Login(String cpr, String password)
    {
        HttpResponseMessage response =
            await httpClient.PostAsJsonAsync("http://localhost:8081/Booking/login",
                new LoginDto(cpr, password));
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }
        
        var responseBody = JsonSerializer.Deserialize<Dictionary<string, object>>(content);
        string jwtToken = responseBody["token"].ToString();
        UserDto userDto = JsonSerializer.Deserialize<UserDto>(content, new JsonSerializerOptions { PropertyNameCaseInsensitive = true });
        
        await jsRuntime.InvokeVoidAsync("localStorage.setItem", "jwtToken", jwtToken);

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
        
        var token = await jsRuntime.InvokeAsync<string>("localStorage.getItem", "jwtToken");
        if (!string.IsNullOrEmpty(token))
        {
            // Set the JWT token in the Authorization header for future HTTP requests
            httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", token);

            // Extract user info from the token if necessary
            ClaimsPrincipal user = new ClaimsPrincipal(new ClaimsIdentity(ParseClaimsFromJwt(token), "apiauth"));
            return new AuthenticationState(user);
        }
        return new AuthenticationState(user);
    }
    private IEnumerable<Claim> ParseClaimsFromJwt(string jwt)
    {
        var payload = jwt.Split('.')[1];
        var jsonBytes = WebEncoders.Base64UrlDecode(payload);
        var keyValuePairs = JsonSerializer.Deserialize<Dictionary<string, object>>(jsonBytes);
        return keyValuePairs.Select(kvp => new Claim(kvp.Key, kvp.Value.ToString()));
    }

    public void Logout()
    {
        user = new ();
        NotifyAuthenticationStateChanged(
            Task.FromResult(new AuthenticationState(user)));
    }
    
}