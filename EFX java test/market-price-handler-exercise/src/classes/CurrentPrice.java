/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author mimeb
 */
public class CurrentPrice {

    private Timestamp timestamp;
    private Timestamp ref_ts;
    private int flag;
    private String[] cp;

    public CurrentPrice(String[] p, Timestamp ts) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
        this.timestamp = new Timestamp(((java.util.Date) df.parse(p[4])).getTime());

        if (timestamp.after(ts) == true) {
            this.flag = 1;
            this.ref_ts = timestamp;
            this.cp = p;
        }
    }

    public int getflag() {
        return flag;
    }

    public Timestamp getref_ts() {
        return ref_ts;
    }

    public String[] getcp() {
        return cp;
    }

}
