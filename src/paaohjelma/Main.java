/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paaohjelma;

import korttipakka.Korttipakka;
import pelaaja.Pelaaja;
import pelaaja.kasiArvioija;

/**
 *
 * @author ile
 */
public class Main {

    public static void main(String[] args) {
        Korttipakka pakka = new Korttipakka();
        Pelaaja pekka = new Pelaaja("Pekka");
        pekka.jaaKasi(pakka, 7);
        pekka.getKasi().jaaTapari(pakka);
        
        System.out.println(pekka);
        kasiArvioija kekkedee = new kasiArvioija(pekka.getKasi());
        int[] pbleet = kekkedee.isPari();
        
        for (int i=0;i<pbleet.length;i++){
            System.out.println("Alkio "+i+": "+pbleet[i]);
        }
        //pakka.printPakka();
    }
}
