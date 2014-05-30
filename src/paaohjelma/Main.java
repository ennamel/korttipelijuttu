/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paaohjelma;

import korttipakka.Korttipakka;
import pelaaja.Pelaaja;

/**
 *
 * @author ile
 */
public class Main {

    public static void main(String[] args) {
        Korttipakka pakka = new Korttipakka();
        Pelaaja pekka = new Pelaaja("Pekka");
        pekka.jaaKasi(pakka, 5);
        
        System.out.println(pekka);
        
        pakka.printPakka();
    }
}
