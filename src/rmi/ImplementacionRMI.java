/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class ImplementacionRMI implements IRemota {

    public ImplementacionRMI() {
        super();
    }

    @Override
    public int mensaje(String palabra) throws RemoteException {
        int retorno = 0;

        for (int i = 0; i < palabra.length(); i++) {
            retorno += palabra.charAt(i);
        }

        return retorno;
    }

    public static void main(String[] args) {

        

        System.setProperty("java.security.policy", "file:///Volumes/Datos/tra");
        System.setProperty("java.rmi.server.hostname", "MacBook-Pro-de-David.local");
        System.setProperty("java.security.debug", "access,failure");
        
        
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        
        //System.setProperty("java.rmi.server.codebase", "file:///Volumes/Datos/Trabajo/Dyalogo/JDYALOGO/Netbeans/Curso/dist/");
        

        //System.out.println("POLL: "+System.getProperty("java.security.policy"));
        try {
            String name = "IRemota";
            IRemota engine = new ImplementacionRMI();
            IRemota stub = (IRemota) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }

}
