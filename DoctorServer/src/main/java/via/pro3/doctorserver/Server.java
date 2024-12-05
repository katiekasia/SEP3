package via.pro3.doctorserver;

import DTOs.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import doctor.grpc.*;
import doctor.grpc.PatientDtoMessage;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Doctor")

public class Server {
    private final DoctorGrpc.DoctorBlockingStub blockingStub;

    public Server() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        blockingStub = DoctorGrpc.newBlockingStub(channel);
    }

    @PostMapping("/login")
    public ResponseDto loginDoctor(@RequestBody LoginDto loginDto) {
        if (loginDto == null || loginDto.getcpr() == null || loginDto.getPassword() == null) {
            throw new IllegalArgumentException("Invalid login credentials");
        }

        try {
            LoginDoctorRequest request = LoginDoctorRequest.newBuilder()
                    .setId(loginDto.getcpr())
                    .setPassword(loginDto.getPassword())
                    .build();

            LoginDoctorResponse response = blockingStub.loginDoctor(request);

            ResponseDto responseDto = new ResponseDto();
            responseDto.setResponse(response.getConfirmation());

            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }
    @PostMapping("/resetPassword")
    public ResponseDto changePassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        if (resetPasswordDto == null) {
            throw new IllegalArgumentException("Invalid reset password");
        }
        try{
            ChangePasswordRequest request = ChangePasswordRequest
                    .newBuilder()
                    .setId(resetPasswordDto.getId())
                    .setCurrentPassword(resetPasswordDto.getCurrentPassword())
                    .setNewPassword(resetPasswordDto.getNewPassword())
                    .build();

            LoginDoctorResponse response = blockingStub.changePassword(request);

            ResponseDto responseDto = new ResponseDto();
            responseDto.setResponse(response.getConfirmation());
            return responseDto;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Reset password failed: " + e.getMessage());
        }
    }

    @PostMapping("/getDoctorById")
    public DoctorDto getDoctorById(@RequestBody String id){
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("Invalid doctor id");
        }
        try{
            GetDoctorByIdRequest request = GetDoctorByIdRequest.newBuilder()
                    .setId(id)
                    .build();

            GetDoctorByIdResponse response = blockingStub.getDoctorById(request);

            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setFirstname(response.getFirstname());
            doctorDto.setLastname(response.getLastname());
            doctorDto.setSpecialisation(response.getSpecialisation());
            return doctorDto;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Get doctor failed: " + e.getMessage());
        }
    }


    @GetMapping("/Prescriptions/getPatients")
    public List<PatientDto> getPatients(@RequestParam String doctorid) {
        try {
            GetPatientsRequest request = GetPatientsRequest.newBuilder().setDoctorid(doctorid).build();

            GetPatientsResponse response = blockingStub.getPatientsByDoctorId(request);

            List<PatientDto> patientDtos = new ArrayList<>();

            for (PatientDtoMessage patientDto : response.getPatientsList()) {
                PatientDto dto = new PatientDto(
                        patientDto.getCpr(),
                        patientDto.getFirstName(),
                        patientDto.getLastName(),
                        patientDto.getEmail(),
                        patientDto.getPhoneNumber()
                );

                patientDtos.add(dto);
            }

            return patientDtos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Get patients failed: " + e.getMessage());
        }
    }

    @PostMapping("/Prescriptions/addPrescription")
    public ResponseDto addPrescription(@RequestBody PrescriptionDto prescriptionDto) {
        try{
            AddPrescriptionRequest request = AddPrescriptionRequest.newBuilder()
                    .setId(prescriptionDto.getId())
                    .setDiagnosis(prescriptionDto.getDiagnosis())
                    .setMedication(prescriptionDto.getMedication())
                    .setRecommendations(prescriptionDto.getRecommendations())
                    .setDate(prescriptionDto.getDate())
                    .setTime(prescriptionDto.getTime())
                    .setPatientcpr(prescriptionDto.getPatientCpr())
                    .setDoctorid(prescriptionDto.getDoctorId())
                    .build();

            ResponseDto responseDto = new ResponseDto();

            Response response = blockingStub.addPrescription(request);
            responseDto.setResponse(response.getConfirmation());

            return responseDto;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Add prescription failed: " + e.getMessage());
        }
    }
}
