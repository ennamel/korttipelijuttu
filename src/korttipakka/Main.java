/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package korttipakka;

import java.util.ArrayList;


public class Main {
    
    public static void main(String[] args){
        
        Korttipakka pakka = new Korttipakka();
        ArrayList<Kortti> pakkah = pakka.getPakka();
        Kortti keks = pakka.arvoKortti();
        System.out.println("Arvottu kortti: "+keks+"\n\n");
        
           
        for (Kortti kortti : pakkah) {
            System.out.println(kortti+"\n");
        }
        
        
        
        
    }
    
    
    
}
