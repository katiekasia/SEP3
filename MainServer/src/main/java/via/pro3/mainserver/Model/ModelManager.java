package via.pro3.mainserver.Model;


import patient.grpc.DBresponse;
import via.pro3.mainserver.DTOs.*;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private GeneratorInterface idGenerator;
  private final EventInterface eventRepository;
  private final EmailSenderInterface emailSender;


  public ModelManager(){
    DatabaseInterface database = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(database);
    this.emailSender = new EmailSender();
    idGenerator = new IdGenerator();
    idGenerator.setAppointmentIds(eventRepository.getAppointmentIds());
    idGenerator.setPrescriptionIds(eventRepository.getPrescriptionIds() );
  }



  @Override public String createAppointment(
      CreateAppointmentDto createAppointmentDto)
  {
    LocalDate date = LocalDate.parse(createAppointmentDto.getDate());
    LocalTime time = LocalTime.parse(createAppointmentDto.getTime());
    MyDateAndTime dateAndTime = new MyDateAndTime(date, time);
    Clinic clinic = eventRepository.getClinicByDoctorId(
        createAppointmentDto.getDoctorId());
    Doctor doctor = eventRepository.getDoctorById(
        createAppointmentDto.getDoctorId());
    Patient patient = getPatientByCpr(createAppointmentDto.getPatientCpr());

    Appointment appointment = new Appointment(
            //Problematic
        idGenerator.generateAppointmentId(), clinic,
        createAppointmentDto.getType(), dateAndTime,
        createAppointmentDto.getDescription(),
        createAppointmentDto.getStatus());
    doctor.addAppointment(appointment);
    patient.addAppointment(appointment);
    try
    {
      eventRepository.createAppointment(appointment, doctor, patient);

    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    emailSender.sendBookingConfirmation(doctor.getEmail(),patient.getEmail(),appointment);
    return "Appointment created in " + appointment.getCity() + " at "
        + appointment.getDateAndTime().toString();
  }

  @Override public Patient getPatientByCpr(String cpr)
  {
    try
    {
      return eventRepository.getPatientByCpr(cpr);
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  public List<Patient> getPatientsByDoctorId(String doctorid) {
    try
    {
      return eventRepository.getPatientsByDoctorId(doctorid);
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public Doctor getDoctorById(String id)
  {
    try
    {
      return eventRepository.getDoctorById(id);
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public List<GetPrescriptionsDto> getPrescriptionsByPatientCpr(String patientCpr, int page)
  {
    try
    {
      return eventRepository.getPrescriptionsByPatientCpr(patientCpr, page);
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public List<CityDto> getCities ()
  {
    try
    {
      return eventRepository.getCities();
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public List<Clinic> getClinicByCity (String code)
  {
    try
    {
      return eventRepository.getClinicByCity(code);
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public List<Doctor> getDoctorByClinic (String id_clinic)
  {
    try
    {
      return eventRepository.getDoctorsByClinic(id_clinic);
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public void registerPatient (RegisterDto registerDto){
    Patient patient = new Patient(registerDto.getCprNo(), registerDto.getName(),
        registerDto.getSurname(), registerDto.getPhone(),
        registerDto.getEmail(), registerDto.getPassword());

    try
    {
      eventRepository.createUser(patient);
      DBresponse response = DBresponse.newBuilder()
          .setConfirmation("Patient registered successfully").build();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Something went wrong");
    }

  }

  @Override public Patient loginPatient (LoginDto loginDto)
  {
    try
    {
      if (eventRepository.loginUser(loginDto))
      {
        Patient patient = getPatientByCpr(loginDto.getcpr());

        return patient;

      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    return null;
  }

  @Override public String changeDoctorPassword (ResetPasswordDto
      resetPasswordDto)
  {
    try
    {
      return eventRepository.changePassowrdDoctor(resetPasswordDto);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public void addPrescription (PrescriptionDto prescriptionDto){
    try
    {
      eventRepository.addPrescription(prescriptionDto);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }

  }

  @Override public Appointment getAppointmentByAppointmentId (
      int appointmentId)
  {
    try
    {
      return eventRepository.getAppointmentByAppointmentId(appointmentId);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public Doctor loginDoctor (LoginDto loginDto){
    try
    {
      if (eventRepository.loginDoctor(loginDto))
      {
        Doctor doctor = getDoctorById(loginDto.getcpr());

        return doctor;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    return null;
  }

  @Override public String getDoctorByClinicName (String clinicName){
    try
    {
      return eventRepository.getDoctorByClinicName(clinicName);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(
          "Error retrieving doctor by clinic: " + e.getMessage(), e);
    }
  }

  @Override public DaysDTO getDoctorsAvailability(String doctorId)
  {
    try
    {
      return eventRepository.getDoctorsAvailibility(doctorId);
    }catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public int getAppointmentsCount(String cpr)
  {
    try
    {
      return eventRepository.getAppointmentsCount(cpr);
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override public int getPrescriptionCount(String cpr)
  {
    try
    {

    return eventRepository.getPrescriptionCount(cpr);
  }catch (Exception e){
  e.printStackTrace();
  throw new RuntimeException(e.getMessage());
}
  }

  @Override public List<Appointment> getDoctorAppointments (String id)
  {
    try
    {
      List<Appointment> appointments = eventRepository.getAppointmentsByDoctorId(
          id);
      if (appointments == null || appointments.isEmpty())
      {
        return new ArrayList<>();
      }
      for (Appointment appointment : appointments){
        if (appointment.getStatus().equals("Expired")){
          eventRepository.updateAppointment(appointment.getAppointmentId(), appointment.getStatus());
        }
      }
      return appointments;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(
          "Error retrieving doctor appointments: " + e.getMessage(), e);
    }
  }

  @Override public Patient getPatientByAppointmentId ( int appointmentId)
  {
    try
    {
      Patient patient = eventRepository.getPatientByAppointmentId(
          appointmentId);
      return patient;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException(
          "Error retrieving patient : " + e.getMessage(), e);
    }
  }
  @Override public String updatePatient (UpdatePatientDto updatePatientDto)
  {
    try
    {
      return eventRepository.updateUser(updatePatientDto);
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }
  @Override
  public void cancelAppointment(int appointmentId, String patientCpr) {
    try {
      Appointment appointment = getAppointmentByAppointmentId(appointmentId);
      Patient patient = getPatientByCpr(patientCpr);
      Doctor doctor = eventRepository.getDoctorByAppointmentId(appointmentId);
      eventRepository.cancelAppointment(appointmentId, patientCpr);
      emailSender.sendBookingCancellation(doctor.getEmail(), patient.getEmail(), appointment);
    }  catch (IllegalStateException e) {
      e.printStackTrace();
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error cancelling appointment: " + e.getMessage(), e);
    }
  }

  @Override
  public String cancelAppointment(int appointmentId) {
    try {
      Appointment appointment = getAppointmentByAppointmentId(appointmentId);
      Patient patient = getPatientByAppointmentId(appointmentId);
      Doctor doctor = eventRepository.getDoctorByAppointmentId(appointmentId);
      emailSender.sendBookingCancellation(doctor.getEmail(), patient.getEmail(),appointment);
      return eventRepository.cancelAppointment(appointmentId);
    }  catch (IllegalStateException e) {
      e.printStackTrace();

      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error cancelling appointment: " + e.getMessage(), e);
    }
  }


  @Override
  public List<Appointment> getPatientAppointments(String cpr) {
    try {
      List<Appointment> appointments = eventRepository.getAppointmentsByPatientCpr(cpr);
      if (appointments == null || appointments.isEmpty())
      {
        return new ArrayList<>();
      }
      for (Appointment appointment : appointments){
        if (appointment.getStatus().equals("Expired")){
          eventRepository.updateAppointment(appointment.getAppointmentId(), appointment.getStatus());
        }
      }
      return appointments;

    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error retrieving patient appointments: " + e.getMessage(), e);
    }
  }
}
