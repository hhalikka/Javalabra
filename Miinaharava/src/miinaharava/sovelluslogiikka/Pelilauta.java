/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Heidi
 */
public class Pelilauta {
    private ArrayList<Ruutu> ruudut;
    
    public Pelilauta() {
        this.ruudut=new ArrayList<Ruutu>();
    }
    public void lisaaRuudut() {
        for (int leveys=1; leveys<17; leveys++) { 
            for(int korkeus=1; korkeus<17; korkeus++) {
            Sijainti ruudunPaikka = new Sijainti(leveys, korkeus);
            this.ruudut.add(new Ruutu(ruudunPaikka));
        }}
    }
   
    
    public void miinoita() {
        int miinoja=40;
        Random miinoittaja=new Random();
        int miinojenLukumaara=0;
        while(miinojenLukumaara!=40) {
            for (Ruutu ruutu : this.ruudut) {
                int i=miinoittaja.nextInt(256)+1;
                if(i<=40&&miinojenLukumaara<40) {
                    ruutu.miinaksi();
                    miinojenLukumaara++;
            } }
        }
    }
    public ArrayList<Ruutu> getRuudut() {
        return this.ruudut;
    }
    
}
