/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Rezervacija extends DomainObject implements Serializable{
    
    private Gost gost;
    private Soba soba;
    private long id;
    private Date datumPrijave;
    private Date datumOdjave;
    private Zaposleni zaposleni;
    private double ukupnaCena;

    public Rezervacija() {
    }

    public Rezervacija(Gost gost, Soba soba, long id, Date datumPrijave, Date datumOdjave, Zaposleni zaposleni) {
        this.gost = gost;
        this.soba = soba;
        this.id = id;
        this.datumPrijave = datumPrijave;
        this.datumOdjave = datumOdjave;
        this.zaposleni = zaposleni;
        this.ukupnaCena = soba.getCena()*gost.getPopust();
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public Date getDatumOdjave() {
        return datumOdjave;
    }

    public void setDatumOdjave(Date datumOdjave) {
        this.datumOdjave = datumOdjave;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "gost=" + gost + ", soba=" + soba + ", id=" + id + ", datumPrijave=" + datumPrijave + ", datumOdjave=" + datumOdjave + ", zaposleni=" + zaposleni + ", ukupnaCena=" + ukupnaCena + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.gost);
        hash = 67 * hash + Objects.hashCode(this.soba);
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.datumPrijave);
        hash = 67 * hash + Objects.hashCode(this.datumOdjave);
        hash = 67 * hash + Objects.hashCode(this.zaposleni);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.ukupnaCena) ^ (Double.doubleToLongBits(this.ukupnaCena) >>> 32));
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
        final Rezervacija other = (Rezervacija) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.ukupnaCena) != Double.doubleToLongBits(other.ukupnaCena)) {
            return false;
        }
        if (!Objects.equals(this.gost, other.gost)) {
            return false;
        }
        if (!Objects.equals(this.soba, other.soba)) {
            return false;
        }
        if (!Objects.equals(this.datumPrijave, other.datumPrijave)) {
            return false;
        }
        if (!Objects.equals(this.datumOdjave, other.datumOdjave)) {
            return false;
        }
        return Objects.equals(this.zaposleni, other.zaposleni);
    }
    
    
     @Override
    public String getTableName() {
        return "rezervacija";
    }

    @Override
    public String getColumnsForInsert() {
        return "sobaID, gostID, zaposleniID, datumPrijave, datumOdjave, ukupnaCena";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
       if (!(domainObject instanceof Rezervacija)) throw new IllegalArgumentException("Invalid domain object passed.");
    
    Rezervacija rezervacija = (Rezervacija) domainObject;

    // Assuming getSoba(), getGost(), and getZaposleni() can't be null. If they can be, you'll need null checks.
    statement.setLong(1, rezervacija.getSoba().getId());
    statement.setLong(2, rezervacija.getGost().getId());
    statement.setLong(3, rezervacija.getZaposleni().getId());

    // Convert java.util.Date to java.sql.Date
    statement.setDate(4, new java.sql.Date(rezervacija.getDatumPrijave().getTime()));
    statement.setDate(5, new java.sql.Date(rezervacija.getDatumOdjave().getTime()));

    statement.setDouble(6, rezervacija.getGost().getPopust()*rezervacija.getSoba().getCena());
    }

    @Override
    public void setAutoIncrementPrimaryKey(long primaryKey) {
        setId(primaryKey);
        System.out.println("Gost je dobilo ID: " + primaryKey);
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

   

    @Override
    public String getColumnsForUpdate() {
         return "sobaID=?, gostID=?, zaposleniID=?, datumPrijave=?, datumOdjave=?, ukupnaCena=?";
    }

    @Override
    public int setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (!(domainObject instanceof Rezervacija)) {
        throw new IllegalArgumentException("Invalid domain object passed.");
    }
        
        Rezervacija rezervacija = (Rezervacija) domainObject;
        statement.setLong(1, rezervacija.getSoba().getId());
        statement.setLong(2, rezervacija.getGost().getId());
        statement.setLong(3, rezervacija.getZaposleni().getId());
        statement.setDate(4, new java.sql.Date(rezervacija.getDatumPrijave().getTime()));
        statement.setDate(5, new java.sql.Date(rezervacija.getDatumOdjave().getTime()));
        statement.setDouble(6, rezervacija.getSoba().getCena()*rezervacija.getGost().getPopust());
        statement.setLong(7, rezervacija.getId());
        
        return 7;
        
    }

    @Override
    public DomainObject readResultSet(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

    
    

