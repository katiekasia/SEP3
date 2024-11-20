package via.pro3.mainserver.service;


import loginPatient.grpc.LoginPatientGrpc;
import via.pro3.mainserver.Model.Model;

public class LoginImpl extends LoginPatientGrpc.LoginPatientImplBase
{
    private final Model model;

    public LoginImpl(Model model)
    {
        this.model = model;
    }


}
