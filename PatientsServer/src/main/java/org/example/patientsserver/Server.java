package org.example.patientsserver;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import patient.grpc.DBresponse;
import patient.grpc.PatientProtoGrpc;
import patient.grpc.dataRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/getName")
public class Server
{
  private PatientProtoGrpc.PatientProtoBlockingStub blockingStub;
  public Server(){
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

    blockingStub = PatientProtoGrpc.newBlockingStub(channel);
  }

  @GetMapping("/name")
  public String getName(@RequestParam String name)
  {
    System.out.println("Client connected at: " + LocalDateTime.now());

    dataRequest request = dataRequest.newBuilder().setEmail(name).build();

    DBresponse response = blockingStub.fetchData(request);

    return "Data: " + response.toString();}
}
