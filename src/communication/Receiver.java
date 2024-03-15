/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Receiver {
    
    private Socket soket;

    public Receiver(Socket soket) {
        this.soket = soket;
    }
    
    public Object primiOdgovor() throws Exception{
    
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            return ois.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Error kod receivera:\n"+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Error kod receivera:\n"+ex.getMessage());
        }

    }
    
}
