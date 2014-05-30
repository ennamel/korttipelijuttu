/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaaja;

import korttipakka.Korttipakka;

/**
 *
 * @author ile
 */
public class Pelaaja {

    private Kasi kasi;
    private final String nimi;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
    }

    public void jaaKasi(Korttipakka kp, int maara) {
        this.kasi = new Kasi(kp, maara);

    }

    @Override
    public String toString() {

        return "Nimi: "+nimi + " Käsi: "+ this.kasi;

    }

}
