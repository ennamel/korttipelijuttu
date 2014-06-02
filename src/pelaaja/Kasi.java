/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaaja;

import java.util.ArrayList;
import java.util.List;
import korttipakka.Kortti;
import korttipakka.Korttipakka;
import korttipakka.Maa;

/**
 *
 * @author ile
 */
public class Kasi implements Comparable<Kasi>{

    private ArrayList<Kortti> kasi;
    private int koko;

    public Kasi() {

    }

    @Override
    public String toString() {
        String returni = "";
        for (Kortti kortti : kasi) {
            returni = returni + kortti + " ";
        }
        return returni;

    }
    public ArrayList<Kortti> returnKasiList(){
        return this.kasi;
    }
    public int[] getArvot(){
        int[] arvot = new int[kasi.size()];
        int i = 0;
        for (Kortti korttinen : kasi){
            arvot[i] = korttinen.getArvo();
            i++;
        }
        return arvot;
        
    }
    public List<Integer> arvotAsList(){
        List<Integer> lista = new ArrayList<>();
        kasi.stream().forEach((korttinen) -> {
            lista.add(korttinen.getArvo());
        });
        return lista;
    }
    public ArrayList<Maa> getMaat(){
        ArrayList<Maa>  maat = new ArrayList<>();
        kasi.stream().forEach((korttinen) -> {
            maat.add(korttinen.getMaa());
        });
        return maat;
    }
    public void jaaNelosetjaAssa(Korttipakka kp){
        this.kasi.clear();
        kasi.add(new Kortti(Maa.HERTTA, 2));
        kasi.add(new Kortti(Maa.PATA, 2));
        kasi.add(new Kortti(Maa.RUUTU, 2));
        kasi.add(new Kortti(Maa.RISTI, 2));
        kasi.add(new Kortti(Maa.PATA, 14));
    }
      public void jaaTapari(Korttipakka kp){
        this.kasi.clear();
        kasi.add(new Kortti(Maa.HERTTA, 2));
        kasi.add(new Kortti(Maa.PATA, 2));
        kasi.add(new Kortti(Maa.RUUTU, 2));
        kasi.add(new Kortti(Maa.RISTI, 3));
        kasi.add(new Kortti(Maa.PATA, 3));
    }

    @Override
    public int compareTo(Kasi tKasi){
        
        
        return 0;
    }
    public void jaaKortteja(Korttipakka kp, int maara){
        
        this.kasi = kp.arvoKortteja(maara);
        
        
    }

}
