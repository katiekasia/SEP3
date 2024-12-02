package via.pro3.mainserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import via.pro3.mainserver.Model.Model;
import via.pro3.mainserver.Model.ModelManager;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.service.LoginImpl;
import via.pro3.mainserver.service.PatientImpl;
import via.pro3.mainserver.service.RegisterPatientImpl;
import via.pro3.mainserver.service.ServerImpl;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class MainServerApplication {
    private final Logger log = LoggerFactory.getLogger(MainServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MainServerApplication.class, args);

        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();


            System.out.println("Server IP Address: " + ipAddress);
        } catch (UnknownHostException e) {
            System.err.println("Unable to retrieve IP address: " + e.getMessage());
        }
    }

    @Bean public CommandLineRunner init()
    {
        return (args) -> {
            Model model = new ModelManager();

            Server server =
                ServerBuilder.forPort(9090)
                    .addService(new ServerImpl())
                    .addService(new PatientImpl(model))
                    .addService(new RegisterPatientImpl(model))
                    .addService(new LoginImpl(model))
                    .build().start();
            log.info("Server started, listening on " + server.getPort());
            server.awaitTermination();
        };
    }
}

