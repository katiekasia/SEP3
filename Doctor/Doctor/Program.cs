using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using Doctor;
using Doctor.Pages.Auth;
using Doctor.Services;
using Microsoft.AspNetCore.Components.Authorization;
using PatientFinal.Services;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(sp => new HttpClient
    { BaseAddress = new Uri(builder.HostEnvironment.BaseAddress) });
builder.Services.AddScoped<ILoginService, HttpLoginService>();
builder.Services.AddScoped<IAppointmentService, HttpAppointmentService>();
builder.Services.AddScoped<AuthenticationStateProvider, SimpleAuthProvider>();
builder.Services.AddScoped<IPrescriptionGetService, HttpPrescriptionGetService>();
builder.Services.AddAuthorizationCore();


await builder.Build().RunAsync();