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
    
    public Hiirenkuuntelija(Nappi nappi) {
        this.nappi=nappi;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton()==MouseEvent.BUTTON3) {
            merkitse();
        } else {
            if(!this.nappi.getRuutu().merkitty()&&!this.nappi.getRuutu().avattu()) {
              avaaRuutu();  
        }}}
 /**
 * Metodi avaa ruudun, jota on painettu hiirellä.
 * 
 * @see miinaharava.kayttoliittyma.Nappi#avaaRuutu() 
 *
 */
    public void avaaRuutu() {
        this.nappi.avaaRuutu();
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
