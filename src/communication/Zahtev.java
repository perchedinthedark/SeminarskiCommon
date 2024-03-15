/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Zahtev implements Serializable{
    
    private Operacija operacija;
    private Object argument;

    public Zahtev() {
    }

    public Zahtev(Operacija operacija, Object argument) {
        this.operacija = operacija;
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    @Override
    public String toString() {
        return "Zahtev{" + "operacija=" + operacija + ", argument=" + argument + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.operacija);
        hash = 59 * hash + Objects.hashCode(this.argument);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zahtev other = (Zahtev) obj;
        if (this.operacija != other.operacija) {
            return false;
        }
        return Objects.equals(this.argument, other.argument);
    }
    
    
    
}
