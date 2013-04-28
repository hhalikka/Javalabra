/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

/**
 *Luo uuden pelin, ja sen pelilaudan. Pitää kirjaa pelin tilasta.
 * 
 * @author Heidi
 */
public class Peli {
    /**
    * Pelin pelilauta, joka sisältää ruudut.
    *
    */
    private Pelilauta pelilauta;
    /**
    * Kertoo, onko peli käynnissä vai loppunut.
    *
    */
    private boolean peliKaynnissa;
    
    public Peli() {
        this.pelilauta=new Pelilauta();
        this.peliKaynnissa=true;
    }
    /**
    *Metodi aloittaa pelin kutsumalla sen pelilaudan metodeja lisaaRuudut,
    *  miinoita ja lisaaYmpyroivat
    * 
    *@see miinaharava.sovelluslogiikka.Pelilauta#lisaaRuudut() 
    * @see miinaharava.sovelluslogiikka.Pelilauta#miinoita() 
    * @see miinaharava.sovelluslogiikka.Pelilauta#lisaaYmpyroivat() 
    */
    public void aloitaPeli() {
        this.pelilauta.lisaaRuudut();
        this.pelilauta.miinoita();
        this.pelilauta.lisaaMiinattomat();
        this.pelilauta.lisaaYmpyroivat();
    }
    /**
    * Lopettaa pelin.
    *
    */
    public void lopetaPeli() {
        this.peliKaynnissa=false;
    }
    
    /**
    * Kertoo, onko peli käynnissä vai loppunut.
    * 
    * @return true, mikäli peli on käynnissä, false, mikäli se on loppunut.
    *
    */
    public boolean peliKaynnissa() {
        return this.peliKaynnissa;
    }
    
    /**
    * Metodi tarkistaa onko jokainen miinaton ruutu avattu, eli onko peli 
    * voitettu.
    * 
    * @return true, mikäli peli on voitettu, muuten false.
    *
    */
    public boolean voitettu() {
        for(Ruutu ruutu:this.pelilauta.getMiinattomat()) {
            if(!ruutu.avattu()) {
                return false;
            }
        }
        return true;
    }
    
    /**
    * Kertoo montako miinaa on vielä löytämättä.
    * 
    * @return jäljelläolevien miinojen määrä
    *
    */
    public int miinojaJaljella() {
        return this.pelilauta.miinojaJaljella();
    }
    
    public Pelilauta getLauta() {
        return this.pelilauta;
    }
    
}
