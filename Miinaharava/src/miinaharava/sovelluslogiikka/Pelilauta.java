/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 *Pelin pelilauta, joka sisältää pelin ruudut.
 * 
 * @author Heidi
 */
public class Pelilauta {
    private ArrayList<Ruutu> ruudut;
    private boolean peliKaynnissa;
    private ArrayList<Ruutu> miinat;
    
    public Pelilauta() {
        this.ruudut=new ArrayList<Ruutu>();
        this.peliKaynnissa=true;
        this.miinat=new ArrayList<Ruutu>();
    }
    /**
    * Metodi luo ja lisää pelilautaan ruudut.   
    *
    */
    public void lisaaRuudut() {
        for (int leveys=1; leveys<10; leveys++) { 
            for(int korkeus=1; korkeus<10; korkeus++) {
                Sijainti ruudunPaikka = new Sijainti(leveys, korkeus);
                this.ruudut.add(new Ruutu(ruudunPaikka)); }}}
    /**
    * Metodi lisää pelilaudan jokaiselle ruudulle sen ympyröivien ruutujen
    * listaan ne pelilaudan ruudut, jotka sijaitsevat sen ympärillä.
    *
    * @see miinaharava.sovelluslogiikka.Ruutu#lisaaYmpyroiva(miinaharava.sovelluslogiikka.Ruutu) 
    * @see miinaharava.sovelluslogiikka.Sijainti#onYmpyroiva(miinaharava.sovelluslogiikka.Sijainti) 
    *
    */
    public void lisaaYmpyroivat() {
        for(Ruutu ruutu : this.ruudut) {
            Sijainti ruudunSijainti = ruutu.getSijainti();
            for(Ruutu ympyroivaRuutu : this.ruudut) {
                Sijainti toisenSijainti = ympyroivaRuutu.getSijainti();
                if(ruudunSijainti.onYmpyroiva(toisenSijainti)) {
                    ruutu.lisaaYmpyroiva(ympyroivaRuutu); }}}}
    /**
    * Metodi lisää pelilautaan miinat, 40 kappaletta, arpojan avulla.
    *
    * @see miinaharava.sovelluslogiikka.Ruutu#miinaksi()   
    * 
    */
    public void miinoita() {
        int miinoja=10;
        Random miinoittaja=new Random();
        int miinojenLukumaara=0;
        while(true) {
            if(miinojenLukumaara==10) {
                        break; }
            for (Ruutu ruutu : this.ruudut) {
                int i=miinoittaja.nextInt(81)+1;
                if(i<=10&&miinojenLukumaara<10) {
                    ruutu.miinaksi();
                    this.miinat.add(ruutu);
                    miinojenLukumaara++;
            } }
        }
    }
    public boolean miinaaPainettu() {
        for(Ruutu miina:this.miinat) {
            if(miina.avattu()) {
                this.peliKaynnissa=false;
                return true;
            }
        }
        return false;
    }
    
    public boolean peliKaynnissa() {
        return this.peliKaynnissa;
    }
    
    public ArrayList<Ruutu> getRuudut() {
        return this.ruudut;
    }
    
}
