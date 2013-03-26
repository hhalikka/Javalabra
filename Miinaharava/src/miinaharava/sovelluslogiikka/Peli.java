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
    
    public void aloitaPeli() {
        this.pelilauta.lisaaRuudut();
        this.pelilauta.miinoita();
        this.pelilauta.lisaaYmpyroivat();
    }
    
    public void lopetaPeli() {
        //ei tehdä mitään vielä
    }
    
}
