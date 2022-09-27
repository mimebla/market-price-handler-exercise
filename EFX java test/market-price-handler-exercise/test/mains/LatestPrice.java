/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mains;

import classes.CurrentPrice;
import classes.PriceEndpoint;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author mimeb
 */
public class LatestPrice {

    public static final String SEPARATOR = ",";
    public static final String refTime = "01-01-0001 00:00:00:000";

    public static void main(String[] args) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
        Timestamp ref_ts = new Timestamp(((java.util.Date) df.parse(refTime)).getTime());

        String Message = "";
        System.out.println("Enter the instrument name (EUR/USD, GBP/USD or EUR/JPY):");
        String KeyboardInput = "";
        Scanner ScannerInput = new Scanner(System.in);
        KeyboardInput = ScannerInput.nextLine();

        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader("src/resources/marketpricefeed.txt"));

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(SEPARATOR);
                PriceEndpoint P = new PriceEndpoint(fields);

                if (P.getp()[1] == null ? " " + KeyboardInput == null : P.getp()[1].equals(" " + KeyboardInput)) {
                    CurrentPrice cp = new CurrentPrice(P.getp(), ref_ts);
                    if (cp.getflag() == 1) {
                        ref_ts = cp.getref_ts();
                        Message = Arrays.toString(cp.getcp());
                    }
                }

                line = br.readLine();
            }

            System.out.println(Message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
