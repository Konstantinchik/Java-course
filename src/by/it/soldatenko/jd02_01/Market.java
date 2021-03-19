package by.it.soldatenko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    static int quantityOut = 0;
    static int quantityIn = 0;

    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();
        int n = 0;
        int x=2;
        int p=0;
        for (int t = 1; t <= 120; t++) {
            double sin = Math.sin(Math.toRadians(t * 6));
            if (sin >0){p++;}
            if (sin <0){p--;}
            int nN=quantityIn-quantityOut;
            if(nN<p+10){x=10;}//
            if(nN>p+10){x=0;}
            System.out.println(p +" "+t +" nN " + nN + " "+x);
            for (int i = 0; i <= x; i++) {
                Buyer buyer = new Buyer(++n);
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000 / Dispetcher.K_SPEED);
        }
        try {
            for (Buyer buyer : buyers) {
                buyer.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println( " Market closed");
        System.out.println("customers "+n);
    }
}