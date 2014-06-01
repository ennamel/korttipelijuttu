/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaaja;

import java.util.ArrayList;
import korttipakka.Kortti;
import korttipakka.Korttipakka;

/**
 *
 * @author ile
 */
public class Kasi implements Comparable<Kasi>{

    private ArrayList<Kortti> kasi;

    public Kasi(Korttipakka kp, int koko) {

        this.kasi = kp.arvoKortteja(koko);

    }

    @Override
    public String toString() {
        String returni = "";
        for (Kortti kortti : kasi) {
            returni = returni + kortti + " ";
        }
        return returni;

    }
    public int isPari(){
        
        
        
        
        return 0;
    }
    @Override
    public int compareTo(Kasi tKasi){
        
        
        return 0;
    }

}
