// See https://aka.ms/new-console-template for more information

using NUnit.Framework;
using PatientFinal.Services;
using PatientFinal.DTOs;

[TestFixture]
public class AppointmentServiceTests
{
    private IAppointmentService _appointmentService;

    [SetUp]
    public void Setup()
    {
        var httpClient = new HttpClient();
        _appointmentService = new HttpAppointmentService(httpClient);
    }

    [Test]
    public async Task GetAppointments_ValidCpr_ReturnsAppointments()
    {
        // Arrange
        string testCpr = "1234567890"; // Use valid CPR

        // Act
        var appointments = await _appointmentService.GetAppointments(testCpr);

        // Assert
        Assert.That(appointments, Is.Not.Null);
        foreach (var apt in appointments)
        {
            Console.WriteLine($"\nAppointment ID: {apt.Id}");
            Console.WriteLine($"Date: {apt.Date}");
            Console.WriteLine($"Doctor: Dr. {apt.DoctorFirstName} {apt.DoctorLastName}");
            Console.WriteLine($"Clinic: {apt.ClinicName}");
        }
    }

    [Test]
    public async Task CreateAppointment_ValidData_ReturnsSuccess()
    {
        // Arrange
        var appointment = new CreateAppointmentDto
        {
            type = "Regular checkup",
            description = "Test appointment",
            status = "Active",
            patientCpr = "1234567890", // Use valid CPR
            doctorId = "D1", // Use valid doctor ID
            date = "2024-12-10",
            time = "10:00"
        };

        // Act
        var response = await _appointmentService.CreateAppointment(appointment);

        // Assert
        Assert.That(response, Is.Not.Null);
        Assert.That(response.response, Does.Contain("created"));
    }
}
