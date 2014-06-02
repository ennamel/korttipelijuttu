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

    /* ISPARI METODIN PALAUTUKSET ERI TILANTEISSA:
    PARI: 0. alkio on parin arvo, 1. ja 5. alkio ovat KUMMATKIN -1. Kickerit saa alkioista 2,3,4
    
    KAKSI PARIA: 0. alkio on suuremman parin arvo, 1. alkio pienemmän parin arvo. 5. alkio AINA -1. Kickerin saa alkiosta 2
    
    KOLMOSET: 0. alkio on kolmosten arvo, 1. alkio AINA -1, 5. alkio AINA 1, kickerit saa alkioista 2 ja 3.
    
    TÄPÄRI: 0. alkio on kolmosten arvo, 1. alkio on parin arvo, 5. alkio AINA 1
    
    NELOSET : 0. alkio nelosten arvo. 5. alkio AINA 4. Kickeri alkiosta 2
    
    
    */
    
    public int[] isPari() {     
        int[] arvot = this.kasi.getArvot();
        int tarkistus = -2;
        List<Integer> kickerit = this.kasi.arvotAsList();

        //System.out.println("debug arvot length: "+arvot.length+" kickerit lenght: "+kickerit.size());
        int pari[] = {-1, -1, -1, -1, -1, -1};

        for (int i = 0; i < arvot.length; i++) {   //käydään arvolistaläpi
            int apuri = 0;
            for (int j = 0; j < arvot.length; j++) {
                if (arvot[j] == arvot[i]) {
                    apuri++;

                }
                // System.out.println(arvot[i]+" apuri: "+apuri);
                if (apuri > 1) {
                    if (pari[0] == -1) {
                        pari[0] = arvot[i];
                    } else if (pari[1] == -1 && arvot[i] != pari[0]) {
                        pari[1] = arvot[i];
                    }
                    if (pari[0] != -1 && pari[1] != -1) {
                        if (pari[0] > pari[1] && pari[1] < arvot[i]) {
                            pari[1] = arvot[i];
                        } else if (pari[1] > pari[0] && pari[0] < arvot[i] && pari[5] == -1 ) {
                            pari[0] = arvot[i];
                        }

                    }
                }
                if (apuri == 3) {
                    if (pari[0] != arvot[i]) {
                        int auttaja = pari[0];
                        pari[0] = arvot[i];
                        pari[1] = auttaja;

                    }
                    pari[5] = 1;

                }
                if (apuri == 4){
                    if (pari[0] != arvot[i]) {
                        int auttaja = pari[0];
                        pari[0] = arvot[i];
                        pari[1] = auttaja;

                    }
                    pari[5] = 4;
                    break;
                }

            }

            if (pari[0] == pari[1]) {
                pari[1] = -1;
            }
        }
        if (pari[0] < pari[1] && pari[5] == -1) {  //jos eka pari ei oo isompi, vaihdetaan päittäin
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
