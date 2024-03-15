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
public class Odgovor implements Serializable{
    
    private Operacija operacija;
    private Object rezultat;

    public Odgovor() {
    }

    public Odgovor(Operacija operacija, Object rezultat) {
        this.operacija = operacija;
        this.rezultat = rezultat;
    }

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    @Override
    public String toString() {
        return "Odgovor{" + "operacija=" + operacija + ", rezultat=" + rezultat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.operacija);
        hash = 61 * hash + Objects.hashCode(this.rezultat);
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
        final Odgovor other = (Odgovor) obj;
        if (this.operacija != other.operacija) {
            return false;
        }
        return Objects.equals(this.rezultat, other.rezultat);
    }
    
    
    
}
