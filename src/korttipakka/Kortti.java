/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korttipakka;

/**
 *
 * @author ile
 */
public class Kortti {

    private final Maa maa;
    private final int arvo;

    public Kortti(Maa maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public int getArvo() {
        return this.arvo;
    }

    public int getMaaArvo() {
        return this.maa.getMaaArvo();
    }

    public Maa getMaa() {
        return this.maa;
    }

}
