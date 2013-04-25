/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

import javax.swing.SwingUtilities;
import miinaharava.kayttoliittyma.Kayttoliittyma;
import miinaharava.sovelluslogiikka.Peli;

/**
 *
 * @author Heidi
 */
public class Miinaharava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Peli uusiPeli = new Peli();
        uusiPeli.aloitaPeli();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(uusiPeli);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
