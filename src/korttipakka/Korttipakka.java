/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package korttipakka;

import java.util.ArrayList;

public class Korttipakka {

    private ArrayList<Kortti> pakka;

    public Korttipakka(){
        alustaKorttiPakka();
        pakka = new ArrayList<>();
    }
    public void alustaKorttiPakka(){
        
        for (int i=0;i<14;i++){
            Kortti korttinen = new Kortti(Maa.HERTTA, i);
            pakka.add(korttinen);
        }
        for (int i=0;i<14;i++){
            Kortti korttinen = new Kortti(Maa.RUUTU, i);
            pakka.add(korttinen);
        }
        for (int i=0;i<14;i++){
            Kortti korttinen = new Kortti(Maa.RISTI, i);
            pakka.add(korttinen);
        }
        for (int i=0;i<14;i++){
            Kortti korttinen = new Kortti(Maa.PATA, i);
            pakka.add(korttinen);
        }
        
    }
    private void muokkaus(){
    
}
  
    
}
