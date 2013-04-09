/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

/**
 *
 * @author Heidi
 */
public class Peli {
    private Pelilauta pelilauta;
    
    public Peli() {
        this.pelilauta=new Pelilauta();
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
        //ei tehdä mitään vielä
    }
    
}
