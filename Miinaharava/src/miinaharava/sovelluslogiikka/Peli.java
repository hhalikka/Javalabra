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
    private Pelilauta pelilauta;
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
        this.pelilauta.lisaaYmpyroivat();
    }
    /**
    * Lopettaa pelin.
    *
    */
    public void lopetaPeli() {
        this.peliKaynnissa=false;
    }
    
    public boolean peliKaynnissa() {
        return this.peliKaynnissa;
    }
    
    public Pelilauta getLauta() {
        return this.pelilauta;
    }
    
}
