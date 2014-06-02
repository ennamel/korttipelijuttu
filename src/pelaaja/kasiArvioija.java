/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaaja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import korttipakka.Kortti;

public class kasiArvioija {

    private final Kasi kasi;

    public kasiArvioija(Kasi kasi) {
        this.kasi = kasi;
    }

    public int[] isPari() {    //palauttaa -1 jos ei paria, muuten palauttaa parin arvon
        int[] arvot = kasi.getArvot();
        int tarkistus = -2;
        List<Integer> kickerit = kasi.arvotAsList();
        

        int pari[] = {-1, -1, -1, -1, -1}; 

        for (int i = 0; i < arvot.length; i++) {   //käydään arvolistaläpi
            if (arvot[i] == tarkistus) {
                if (pari[0] == -1) {
                    pari[0] = arvot[i];
                } else if (pari[1] == -1) {
                    pari[1] = arvot[i];
                }
                if (pari[0] != -1 && pari[1] != 1) {
                    if (pari[0] > pari[1] && pari[1] < arvot[i]) {
                        pari[1] = arvot[i];
                    } else if (pari[1] > pari[0] && pari[0] < arvot[i]) {
                        pari[0] = arvot[i];
                    }

                }
            }
            tarkistus = arvot[i];
        }
        if (pari[0] < pari[1]){  //jos eka pari ei oo isompi, vaihdetaan päittäin
            int apu = pari[0];
            pari[0] = pari[1];
            pari[1] = apu;
            
        }
        
        
        Collections.sort(kickerit);    //sortataan käden sisältämien arvojen lista
        int apu = 2;
        for (int i=0; i<kickerit.size(); i++){  // käydään lista läpi
            while (arvot[2] == -1 || arvot[3] == -1 || arvot [4]==-1){  //tää pyöräytetään vaan jos on vielä täytettävää
                if (kickerit.get(i) != arvot[0] ||kickerit.get(i) != arvot[1]){  //kickeriks ei kelpaa arvo, joka on jommankumman parin arvona
                    arvot[apu] = kickerit.get(i);
                    apu++;
                }
                    
                
                
            }
            
        }

        return pari;
    }

}
