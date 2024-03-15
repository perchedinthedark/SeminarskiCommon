/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
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
public class Soba extends DomainObject implements Serializable{
    
    private long id;
    private String tip;
    private long brojKreveta;
    private boolean dostupna;
    private double cena;
    private String pogled;

    public Soba() {
    }

    public Soba(long id, String tip, long brojKreveta, boolean dostupna, double cena, String pogled) {
        this.id = id;
        this.tip = tip;
        this.brojKreveta = brojKreveta;
        this.dostupna = dostupna;
        this.cena = cena;
        this.pogled = pogled;
    }

    public String getPogled() {
        return pogled;
    }

    public void setPogled(String pogled) {
        this.pogled = pogled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public long getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(long brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public boolean isDostupna() {
        return dostupna;
    }

    public void setDostupna(boolean dostupna) {
        this.dostupna = dostupna;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Soba{" + "id=" + id + ", tip=" + tip + ", brojKreveta=" + brojKreveta + ", dostupna=" + dostupna + ", cena=" + cena + ", pogled=" + pogled + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.tip);
        hash = 37 * hash + (int) (this.brojKreveta ^ (this.brojKreveta >>> 32));
        hash = 37 * hash + (this.dostupna ? 1 : 0);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.cena) ^ (Double.doubleToLongBits(this.cena) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.pogled);
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
        final Soba other = (Soba) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.brojKreveta != other.brojKreveta) {
            return false;
        }
        if (this.dostupna != other.dostupna) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.tip, other.tip)) {
            return false;
        }
        return Objects.equals(this.pogled, other.pogled);
    }

     @Override
    public String getTableName() {
        return "soba";
    }

    @Override
    public String getColumnsForInsert() {
        return "tip, brojKreveta, dostupna, cena, pogled";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        Soba soba = (Soba) domainObject;
        statement.setString(1, soba.getTip());
        statement.setLong(2, soba.getBrojKreveta());
        statement.setBoolean(3, soba.isDostupna());
        statement.setDouble(4, soba.getCena());
        statement.setString(5, soba.getPogled());
    }

    @Override
    public void setAutoIncrementPrimaryKey(long primaryKey) {
        setId(primaryKey);
        System.out.println("Gost je dobilo ID: " + primaryKey);
    }

  

    @Override
    public String getColumnsForUpdate() {
        return "tip=?, brojKreveta=?, dostupna=?, cena=?, pogled=?";
    }

    @Override
    public int setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (!(domainObject instanceof Soba)) {
        throw new IllegalArgumentException("Invalid domain object passed.");
    }
        
        Soba soba = (Soba) domainObject;
        statement.setString(1, soba.getTip());
        statement.setLong(2, soba.getBrojKreveta());
        statement.setBoolean(3, soba.isDostupna());
        statement.setDouble(4, soba.getCena());
        statement.setString(5, soba.getPogled());
        
        statement.setLong(6, soba.getId());
        
        return 6;
        
    }

    @Override
    public DomainObject readResultSet(ResultSet resultSet) {
        try {
            Soba soba = new Soba();
            soba.setId(resultSet.getLong("id"));
            soba.setTip(resultSet.getString("tip"));
            soba.setCena(resultSet.getDouble("cena"));
            soba.setDostupna(resultSet.getBoolean("dostupna"));
            soba.setBrojKreveta(resultSet.getLong("brojKreveta"));
            soba.setPogled(resultSet.getString("pogled"));
            return soba;
        } catch (SQLException ex) {
            Logger.getLogger(Soba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
    
    
    
}
