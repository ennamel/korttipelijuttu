/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korttipakka;

import java.util.ArrayList;
import java.util.Random;

public class Korttipakka {

    private ArrayList<Kortti> pakka;
    private Random randomi;

    public Korttipakka() {

        pakka = new ArrayList<>();
        randomi = new Random();
        alustaKorttiPakka();
    }

    public void alustaKorttiPakka() {

        for (int i = 0; i < 14; i++) {
            Kortti korttinen = new Kortti(Maa.HERTTA, i);
            pakka.add(korttinen);
        }
        for (int i = 0; i < 14; i++) {
            Kortti korttinen = new Kortti(Maa.RUUTU, i);
            pakka.add(korttinen);
        }
        for (int i = 0; i < 14; i++) {
            Kortti korttinen = new Kortti(Maa.RISTI, i);
            pakka.add(korttinen);
        }
        for (int i = 0; i < 14; i++) {
            Kortti korttinen = new Kortti(Maa.PATA, i);
            pakka.add(korttinen);
        }

    }

    public ArrayList getPakka() {

        return this.pakka;
    }

    public Kortti arvoKortti() {
        int random = randomi.nextInt(pakka.size());
        Kortti kortti = pakka.get(random);
        pakka.remove(random);
        return kortti;

    }

    public ArrayList arvoKortteja(int maara) {
        ArrayList<Kortti> kasi = new ArrayList<>();

        for (int i = 0; i < maara; i++) {
            kasi.add(arvoKortti());
        }
        return kasi;
    }

    private void muokkaus() {

    }
    public void printPakka(){
        
        pakka.stream().forEach((keks) -> {
            System.out.println(keks+"\n");
        });
    }

}
