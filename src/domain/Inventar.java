/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Inventar implements Serializable{
    
    private long myLongVariable;
    private String naziv;
    private long kolicina;
    private String JM;
    private Soba soba;

    public Inventar() {
    }

    public Inventar(long myLongVariable, String naziv, long kolicina, String JM, Soba soba) {
        this.myLongVariable = myLongVariable;
        this.naziv = naziv;
        this.kolicina = kolicina;
        this.JM = JM;
        this.soba = soba;
    }

    
    public String getJM() {
        return JM;
    }

    public void setJM(String JM) {
        this.JM = JM;
    }

    public long getMyLongVariable() {
        return myLongVariable;
    }

    public void setMyLongVariable(long myLongVariable) {
        this.myLongVariable = myLongVariable;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public long getKolicina() {
        return kolicina;
    }

    public void setKolicina(long kolicina) {
        this.kolicina = kolicina;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    @Override
    public String toString() {
        return "Inventar{" + "myLongVariable=" + myLongVariable + ", naziv=" + naziv + ", kolicina=" + kolicina + ", JM=" + JM + ", soba=" + soba + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.myLongVariable ^ (this.myLongVariable >>> 32));
        hash = 97 * hash + Objects.hashCode(this.naziv);
        hash = 97 * hash + (int) (this.kolicina ^ (this.kolicina >>> 32));
        hash = 97 * hash + Objects.hashCode(this.JM);
        hash = 97 * hash + Objects.hashCode(this.soba);
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
        final Inventar other = (Inventar) obj;
        if (this.myLongVariable != other.myLongVariable) {
            return false;
        }
        if (this.kolicina != other.kolicina) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.JM, other.JM)) {
            return false;
        }
        return Objects.equals(this.soba, other.soba);
    }
}
