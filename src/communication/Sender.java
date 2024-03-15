/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Sender {
    
    private Socket soket;

    public Sender(Socket soket) {
        this.soket = soket;
    }
    
    
    public void posalji(Object object) throws Exception{
    
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(object);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Greska kod sendera: \n"+ex.getMessage());
        }
        
    
    
    }
}
