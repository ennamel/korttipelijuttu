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
        int[] arvot = this.kasi.getArvot();
        int tarkistus = -2;
        List<Integer> kickerit = this.kasi.arvotAsList();

        //System.out.println("debug arvot length: "+arvot.length+" kickerit lenght: "+kickerit.size());
        int pari[] = {-1, -1, -1, -1, -1};

        for (int i = 0; i < arvot.length; i++) {   //käydään arvolistaläpi
            int apuri = 0;
            for (int j = 0; j < arvot.length; j++) {
                if (arvot[j] == tarkistus) {
                    apuri++;
                }
                if (apuri > 1) {
                    if (pari[0] == -1) {
                        pari[0] = arvot[j];
                    } else if (pari[1] == -1 && arvot[j] != pari[0]) {
                        pari[1] = arvot[j];
                    }
                    if (pari[0] != -1 && pari[1] != -1) {
                        if (pari[0] > pari[1] && pari[1] < arvot[j]) {
                            pari[1] = arvot[j];
                        } else if (pari[1] > pari[0] && pari[0] < arvot[j]) {
                            pari[0] = arvot[j];
                        }

                    }
                }

            }
            tarkistus = arvot[i];
            System.out.println("debug: tarkistus: " + tarkistus);
            if (pari[0] == pari[1]) {
                pari[1] = -1;
            }
        }
        if (pari[0] < pari[1]) {  //jos eka pari ei oo isompi, vaihdetaan päittäin
            int apu = pari[0];
            pari[0] = pari[1];
            pari[1] = apu;

        }

        Collections.sort(kickerit);    //sortataan käden sisältämien arvojen lista
        int apu = 2;
        for (int i = kickerit.size() - 1; i > -1; i--) {  // käydään lista läpi
            if (apu < 5) {
                if (kickerit.get(i) != pari[0] && kickerit.get(i) != pari[1]) {  //kickeriks ei kelpaa arvo, joka on jommankumman parin arvona
                    pari[apu] = kickerit.get(i);
                    apu++;
                }
            }

        }

        return pari;
    }

}
