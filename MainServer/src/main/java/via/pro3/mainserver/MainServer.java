//package via.pro3.mainserver;
//
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import via.pro3.mainserver.Model.Model;
//import via.pro3.mainserver.Model.ModelManager;
//import via.pro3.mainserver.service.*;
//
//public class MainServer {
//    public static void main(String[] args) throws Exception
//    {
//      Model model = new ModelManager();
//
//        Server server =
//                ServerBuilder.forPort(9090)
//                        .addService(new ServerImpl())
//                        .addService(new PatientImpl(model))
//                        .addService(new RegisterPatientImpl(model))
//                        .addService(new LoginImpl(model))
//                        .addService(new DoctorImpl(model))
//                        .build().start();
//        System.out.println("Server started, listening on " + server.getPort());
//        server.awaitTermination();
//    }
//
//
//}
