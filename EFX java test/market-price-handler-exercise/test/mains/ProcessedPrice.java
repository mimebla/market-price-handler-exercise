/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mains;

import classes.PriceEndpoint;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author mimeb
 */
public class ProcessedPrice {

    public static final String SEPARATOR = ",";

    public static void main(String[] args) {

        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader("src/resources/marketpricefeed.txt"));

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(SEPARATOR);
                PriceEndpoint P = new PriceEndpoint(fields);
                String Message = Arrays.toString(P.getp());
                System.out.println(Message);

                line = br.readLine();
            }
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
