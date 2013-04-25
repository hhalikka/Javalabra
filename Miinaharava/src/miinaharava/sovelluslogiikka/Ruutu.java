/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

import java.util.ArrayList;

/**
 *Pelin yksi ruutu, jolla on sijainti, ympyröivät ruudut, sekä tieto siitä,
 * onko ruutu miina, onko se merkitty, onko se avattu ja moniko miina sitä
 * ympyröi.
 * 
 * @author Heidi
 */
public class Ruutu {
    private ArrayList<Ruutu> ympyroivatRuudut;
    private boolean onMiina;
    private boolean avattu;
    private Sijainti sijainti;
    private boolean merkitty;
    
    public Ruutu() {
        this.avattu=false;
        this.onMiina=false;
        this.merkitty=false;
        this.ympyroivatRuudut=new ArrayList<Ruutu>();
    }
    
    public Ruutu(Sijainti sijainti) {
        this.avattu=false;
        this.onMiina=false;
        this.sijainti=sijainti;
        this.ympyroivatRuudut=new ArrayList<Ruutu>();
        this.merkitty=false;
    }
    /**
    * Metodi lisää ruudun ympyröivien listaan parametrina annetun ruudun
    *
    * @param ruutu lisättävä ruutu  
    * 
    */
    public void lisaaYmpyroiva(Ruutu ruutu) {
        this.ympyroivatRuudut.add(ruutu);
    }
    /**
    * Metodi avaa ruudun, mikäli se ei ole avattu vielä.
    *
    */
    public void avaa() {
        if(!this.onMiina&&!this.merkitty) {
            this.avattu=true;
        } else if(this.onMiina) {
            //peli lopetetaan!
        } else {
            //merkitty, ei tehdä mitään
        }
    }
    /**
    * Metodi merkitsee merkitsemättömän ruudun, ja poistaa merkinnän
    * merkitystä ruudusta.
    *
    */
    public void merkinta() {
        if(this.merkitty) {
            this.merkitty=false;
        } else {
            this.merkitty=true;
        }
    }
    /**
    * Metodi palauttaa ruutua ympyröivien miinojen määrän.   
    * 
    * @return ympyröivien miinojen määrä
    */
    public int miinojenMaara() {
        int miinoja=0;
        for(Ruutu ruutu : this.ympyroivatRuudut) {
            if(ruutu.onMiina) {
                miinoja++;
            }
        }
        return miinoja;
    }
    /**
    * Palauttaa true, mikäli ruutu sisältää miinan.   
    * 
    * @return true mikäli ruutu on miina 
    */
    
    public boolean onMiina() {
        return this.onMiina;
    }
    /**
    * Palauttaa true, mikäli ruutu on merkitty.  
    * 
    * @return true jos ruutu on merkitty
    */
    public boolean merkitty() {
        return this.merkitty;
    }
    /**
    *Palauttaa true, mikäli ruutu on avattu.  
    * 
    * @return true jos ruutu on avattu
    */
    public boolean avattu() {
        return this.avattu;
    }
    /**
    * Tekee ruudusta miinan, eli muuttaa sen onMiina-arvon true:ksi.  
    * 
    */
    public void miinaksi() {
        this.onMiina=true;
    }
    
    public ArrayList<Ruutu> getYmpyroivat() {
        return this.ympyroivatRuudut;
    }
    public Sijainti getSijainti() {
        return this.sijainti;
    }
}
