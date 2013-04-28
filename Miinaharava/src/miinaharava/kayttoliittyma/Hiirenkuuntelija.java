/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import miinaharava.Miinaharava;
import miinaharava.sovelluslogiikka.Ruutu;

/**
 * 
 * @author Heidi
 */
public class Hiirenkuuntelija implements MouseListener {
    private Nappi nappi;
    private Kayttoliittyma kayttoliittyma;
    
    public Hiirenkuuntelija(Nappi nappi, Kayttoliittyma kayttoliittyma) {
        this.kayttoliittyma=kayttoliittyma;
        this.nappi=nappi;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(this.kayttoliittyma.peliKaynnissa()){
            if(me.getButton()==MouseEvent.BUTTON3) {
                merkitse();
                this.kayttoliittyma.asetaMiinojaJaljellaTeksti();
            } else {
                 if(!this.nappi.getRuutu().merkitty()&&!this.nappi.getRuutu().avattu()) {
                    avaaRuutu();  
        }}}}
 /**
 * Metodi avaa ruudun, jota on painettu hiirellä.
 * 
 * @see miinaharava.kayttoliittyma.Nappi#avaaRuutu() 
 *
 */
    public void avaaRuutu() {
        this.nappi.avaaRuutu();
        if(this.nappi.onkoRuutuMiina()) {
            this.kayttoliittyma.lopetaPeli();
        } else if(this.kayttoliittyma.voitettu()) {
            this.kayttoliittyma.lopetaPeli();
        }
    }
 /**
 * Metodi merkitsee ruudun.
 *
 * @see miinaharava.kayttoliittyma.Nappi#merkitseRuutu() 
 */
    public void merkitse() {
        this.nappi.merkitseRuutu();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
