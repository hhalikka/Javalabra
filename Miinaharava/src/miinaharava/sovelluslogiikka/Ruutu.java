/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

import java.util.ArrayList;

/**
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
    
    public void lisaaYmpyroiva(Ruutu ruutu) {
        this.ympyroivatRuudut.add(ruutu);
    }
    
    public void avaa() {
        if(!this.onMiina&&!this.merkitty) {
            this.avattu=true;
            if(this.miinojenMaara()==0) {
                this.avaaYmpyroivat();
        } } else if(this.onMiina) {
            //peli lopetetaan!
        } else {
            //merkitty, ei tehdä mitään
        }
    }
    
    public void avaaYmpyroivat() {
       for (Ruutu ruutu : this.ympyroivatRuudut) {
           if(!ruutu.onMiina) {
               ruutu.avaa();
           }
       } 
    }
    public void merkinta() {
        if(this.merkitty) {
            this.merkitty=false;
        } else {
            this.merkitty=true;
        }
    }
    public int miinojenMaara() {
        int miinoja=0;
        for(Ruutu ruutu : this.ympyroivatRuudut) {
            if(ruutu.onMiina) {
                miinoja++;
            }
        }
        return miinoja;
    }
    
    public boolean onMiina() {
        return this.onMiina;
    }
    public boolean merkitty() {
        return this.merkitty;
    }
    public boolean avattu() {
        return this.avattu;
    }
    
    public Sijainti getSijainti() {
        return this.sijainti;
    }
    
    public void miinaksi() {
        this.onMiina=true;
    }
}
