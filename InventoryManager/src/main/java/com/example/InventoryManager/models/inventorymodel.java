package com.example.InventoryManager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;


@Entity(name = "inventorytable")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class inventorymodel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer inventoryid ;
    private String inventoryname;
    private String inventorytype;
    private Integer mfcyear;
    private Date dbupdate;


    public inventorymodel() {
    }

    public inventorymodel(int inventoryid, String inventoryname, String inventorytype, int mfcyear, LocalDate dbupdate) {

    }

    public Integer getInventoryid() {
        return this.inventoryid;
    }

    public void setInventoryid(Integer inventoryid) {
        this.inventoryid = inventoryid;
    }

    public String getInventoryname() {
        return this.inventoryname;
    }

    public void setInventoryname(String inventoryname) {
        this.inventoryname = inventoryname;
    }

    public String getInventorytype() {
        return inventorytype;
    }

    public void setInventorytype(String inventorytype) {
        this.inventorytype = inventorytype;
    }

    public Integer getMfcyear() {
        return mfcyear;
    }

    public void setMfcyear(Integer mfcyear) {
        this.mfcyear = mfcyear;
    }

    public Date getDbupdate() {
        return dbupdate;
    }

    public void setDbupdate(Date dbupdate) {
        this.dbupdate = dbupdate;
    }
}


