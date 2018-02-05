package com.developmethis.partyflashlight.firebase;

/**
 * Created by Faizan Ejaz on 2/5/2018.
 */

public class item {
    public item(String iname, String idesc, Long iprice, String isize, Long ino) {
        this.iname = iname;
        this.idesc = idesc;
        this.iprice = iprice;
        this.isize = isize;
        this.ino = ino;
    }

    public item() {
        this.iname = "";
        this.idesc = "";
        this.iprice = 0L;
        this.isize = "";
        this.ino = 0L;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIdesc() {
        return idesc;
    }

    public void setIdesc(String idesc) {
        this.idesc = idesc;
    }

    public Long getIprice() {
        return iprice;
    }

    public void setIprice(Long iprice) {
        this.iprice = iprice;
    }

    public String getIsize() {
        return isize;
    }

    public void setIsize(String isize) {
        this.isize = isize;
    }

    public Long getIno() {
        return ino;
    }

    public void setIno(Long ino) {
        this.ino = ino;
    }
    String iname;
    String idesc;
    Long iprice;
    String isize;
    Long ino;
}
