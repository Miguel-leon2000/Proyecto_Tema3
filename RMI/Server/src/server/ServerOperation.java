package server;

import model.Contact;
import rmiinterface.RMIInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

    protected ServerOperation() throws RemoteException {
        super();
    }

    @Override
    public String helloTo(String name) throws RemoteException{
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }

    @Override
    public Contact getContact() throws RemoteException {
        return new Contact( "Miguel", "7321155597");
    }

    public static void main(String[] args){

        try {

            Naming.rebind("//85.187.158.121:1099/MyServer", new ServerOperation()); //1099
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }


}
