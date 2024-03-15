/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Gost extends DomainObject implements Serializable{
    
    private long id;
    private String ime;
    private String prezime;
    private String kontakt;
    private double popust;

    public Gost() {
    }

    public Gost(long id, String ime, String prezime, String kontakt, double popust) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt = kontakt;
        this.popust = popust;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    @Override
    public String toString() {
        return "Gost{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", kontakt=" + kontakt + ", popust=" + popust + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.ime);
        hash = 97 * hash + Objects.hashCode(this.prezime);
        hash = 97 * hash + Objects.hashCode(this.kontakt);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.popust) ^ (Double.doubleToLongBits(this.popust) >>> 32));
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
        final Gost other = (Gost) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.popust) != Double.doubleToLongBits(other.popust)) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.kontakt, other.kontakt);
    }

    @Override
    public String getTableName() {
        return "gost";
    }

    @Override
    public String getColumnsForInsert() {
        return "ime, prezime, kontakt, popust";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        Gost gost = (Gost) domainObject;
        statement.setString(1, gost.getIme());
        statement.setString(2, gost.getPrezime());
        statement.setString(3, gost.getKontakt());
        statement.setDouble(4, gost.getPopust());
    }

    @Override
    public void setAutoIncrementPrimaryKey(long primaryKey) {
        setId(primaryKey);
        System.out.println("Gost je dobilo ID: " + primaryKey);
    }

   

    @Override
    public String getColumnsForUpdate() {
         return "ime = ?, prezime = ?, kontakt = ?, popust = ?";
    }

    @Override
    public int setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
      if (!(domainObject instanceof Gost)) {
        throw new IllegalArgumentException("Invalid domain object passed.");
    }
    
    Gost gost = (Gost) domainObject;
    
    statement.setString(1, gost.getIme());
    statement.setString(2, gost.getPrezime());
    statement.setString(3, gost.getKontakt());
    statement.setDouble(4, gost.getPopust());
    
    // Assuming the ID is used to specify which record to update and is the last parameter
    statement.setLong(5, gost.getId());
    
    // Return the index of the last parameter set
    return 5;
    }

    @Override
    public DomainObject readResultSet(ResultSet resultSet) {
        try {
            Gost gost = new Gost();
            gost.setId(resultSet.getLong("id"));
            gost.setIme(resultSet.getString("ime"));
            gost.setPrezime(resultSet.getString("prezime"));
            gost.setKontakt(resultSet.getString("kontakt"));
            gost.setPopust(resultSet.getDouble("popust"));
            return gost;
        } catch (SQLException ex) {
            Logger.getLogger(Gost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
    
}
