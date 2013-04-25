/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.util.ArrayList;
import javax.swing.JButton;
import miinaharava.sovelluslogiikka.Ruutu;

/**
 * Tallettaa Ruutu-oliot ja niitä käyttöliittymässä vastaavat JButtonit.
 * 
 * @author Heidi
 */
public class Nappi {
    private JButton button;
    private Ruutu ruutu;
   
    public Nappi(JButton button, Ruutu ruutu) {
        this.button=button;
        this.ruutu=ruutu;
    }
 /**
 * Metodi avaa ruudun, mikäli se ei ole merkitty tai avattu, ja asettaa
 * tekstiksi tiedon siitä, montako miinaa ruutua ympyröi. Mikäli ruutu
 * on miina, peli lopetetaan.
 *
 */
    public void avaaRuutu() {
        this.ruutu.avaa();
        if(this.onkoRuutuMiina()) {
            this.button.setText("X");
           //lopeta peli 
        } else {
            String miinojaYmparilla=""+this.ruutu.miinojenMaara();
            this.button.setText(miinojaYmparilla);  
        }
    }
 /**
 * Metodi merkitsee ruudun, tai poistaa merkityn ruudun merkinnän, ja
 * asettaa ruudun tekstin merkintätilan mukaan.
 *
 */
    public void merkitseRuutu() {
        if(this.onkoRuutuMerkitty()) {
            this.button.setText("");
        } else {
            this.button.setText("?");
        }
        this.ruutu.merkinta();
    }
 /**
 * Kertoo, onko ruutu merkitty.
 * 
 * @return true, mikäli ruutu on merkitty, muuten false.
 *
 */
    public boolean onkoRuutuMerkitty() {
        return this.ruutu.merkitty();
    }
 /**
 * Metodi kertoo onko ruutu miina.
 * 
 * @return true, mikäli ruutu on miina, muuten false.
 *
 */
    public boolean onkoRuutuMiina() {
        return this.ruutu.onMiina();
    }
    public JButton getButton() {
        return this.button;
    }
    public Ruutu getRuutu() {
        return this.ruutu;
    }
}
