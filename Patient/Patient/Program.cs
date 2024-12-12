
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using MudBlazor.Services;
using Patient;
using Patient.Auth;
using Patient.Services;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");



builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri(builder.HostEnvironment.BaseAddress) });
builder.Services.AddScoped<IAppointmentService, HttpAppointmentService>();
builder.Services.AddScoped<IRegisterService, HttpRegisterService>();
builder.Services.AddScoped<IUpdateService, HttpUpdatePatientService>();
builder.Services.AddScoped<ILoginService, HttpLoginService>();
builder.Services.AddScoped<SimpleAuthProvider>();
builder.Services.AddScoped<AuthenticationStateProvider, SimpleAuthProvider>();
builder.Services.AddScoped<IPrescriptionService, HttpPrescriptionService>();
builder.Services.AddSingleton<IAppointmentStateService, AppointmentStateService>();
builder.Services.AddSingleton<IPrescriptionStateService, PrescriptionStateService>();

builder.Services.AddAuthorizationCore();
builder.Services.AddMudServices();



await builder.Build().RunAsync();