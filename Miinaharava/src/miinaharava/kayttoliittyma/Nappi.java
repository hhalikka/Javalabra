/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.util.ArrayList;
import javax.swing.JButton;
import miinaharava.sovelluslogiikka.Ruutu;
import miinaharava.sovelluslogiikka.Sijainti;

/**
 * Tallettaa Ruutu-oliot ja niitä käyttöliittymässä vastaavat JButtonit.
 * 
 * @author Heidi
 */
public class Nappi {
    private Sijainti sijainti;
    private JButton button;
    private Ruutu ruutu;
    private ArrayList<Nappi> ympyroivatNapit;
   
    public Nappi(JButton button, Ruutu ruutu) {
        this.button=button;
        this.ruutu=ruutu;
        this.ympyroivatNapit=new ArrayList<Nappi>();
        this.sijainti=ruutu.getSijainti();
    }
 /**
 * Metodi avaa ruudun, mikäli se ei ole merkitty tai avattu, ja asettaa
 * tekstiksi tiedon siitä, montako miinaa ruutua ympyröi. Mikäli ruutu
 * on miina, peli lopetetaan.
 *
 */
    public void avaaRuutu() {
        if(!this.ruutu.avattu()) {
            this.ruutu.avaa();
            this.asetaTeksti(); 
            if(this.ruutu.miinojenMaara()==0 && !this.onkoRuutuMiina()) {
                for(Nappi ympyroiva : this.ympyroivatNapit) {
                    ympyroiva.avaaRuutu();
            }}}}
        
    
 /**
 * Metodi merkitsee ruudun, tai poistaa merkityn ruudun merkinnän, ja
 * asettaa ruudun tekstin merkintätilan mukaan.
 *
 */
    public void merkitseRuutu() {
        if(!this.ruutu.avattu()) {
            if(this.onkoRuutuMerkitty()) {
                this.button.setText("");
            } else {
                this.button.setText("?");
        }
        this.ruutu.merkinta();
    }}
 /**
 * Kertoo, onko ruutu merkitty.
 * 
 * @return true, mikäli ruutu on merkitty, muuten false.
 *
 */
    public boolean onkoRuutuMerkitty() {
        return this.ruutu.merkitty();
    }
    public void asetaTeksti() {
        Ruutu ruutu=this.ruutu;
        if(ruutu.onMiina()) {
            this.button.setText("X");
        } else {
            String miinojaYmparilla=""+ruutu.miinojenMaara();
            this.button.setText(miinojaYmparilla);
        }
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
    
    public void lisaaYmpyroivaksi(Nappi lisattava) {
        this.ympyroivatNapit.add(lisattava);
    }
    
    public JButton getButton() {
        return this.button;
    }
    public Ruutu getRuutu() {
        return this.ruutu;
    }
    public ArrayList<Nappi> getYmpyroivat() {
        return this.ympyroivatNapit;
    }
    public Sijainti getSijainti() {
        return this.sijainti;
    }
}
