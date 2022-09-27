/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author mimeb
 */
public class PriceEndpoint {

    private double bid;
    private double ask;
    private String[] p;

    public PriceEndpoint(String[] fields) {
        this.bid = Double.parseDouble(fields[2]);
        this.ask = Double.parseDouble(fields[3]);
        this.p = fields;
        if (bid >= 100) {
            this.p[2] = String.valueOf(Math.round((bid - (0.1 / 100) * bid) * 100d) / 100d);
            this.p[3] = String.valueOf(Math.round((ask + (0.1 / 100) * ask) * 100d) / 100d);
        } else {
            this.p[2] = String.valueOf(Math.round((bid - (0.1 / 100) * bid) * 10000d) / 10000d);
            this.p[3] = String.valueOf(Math.round((ask + (0.1 / 100) * ask) * 10000d) / 10000d);
        }

    }

    public String[] getp() {
        return p;
    }

}
