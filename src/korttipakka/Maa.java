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
public enum Maa {
    RUUTU(1),RISTI(3),HERTTA(2),PATA(4); //Annetaan maille lukuarvot ni ehkä helpottaa jossain?
    
    private final  int arvo;
    
    
    
    private Maa(int arvo){
     this.arvo = arvo;   
    }
    public int getMaaArvo(){ //tällä saa sit sen arvon, jos sitä tarvii (Maa.RUUTU.getMaaArvo() palauttaa 1 esim)
        return this.arvo;
    }
}
