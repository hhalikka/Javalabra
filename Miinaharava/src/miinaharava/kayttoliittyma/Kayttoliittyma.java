/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import miinaharava.sovelluslogiikka.Pelilauta;
import miinaharava.sovelluslogiikka.Ruutu;
import miinaharava.sovelluslogiikka.Sijainti;

/**
 *
 * @author Heidi
 */
public class Kayttoliittyma implements Runnable {
    private JLabel pelinTila;
    private JFrame frame;
    private Pelilauta pelilauta;
    
    public Kayttoliittyma(Pelilauta pelilauta) {
        this.pelinTila=new JLabel();
        this.pelilauta=pelilauta;
    }
 /**
 * Metodi luo käyttölittymän komponentit.
 *
 */
    public void luodaanKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        container.add(this.pelinTila, BorderLayout.NORTH);
        asetaPelinTilaTeksti();
        container.add(luoRuudut());
    }
    
    private JPanel luoRuudut() {
        JPanel panel = new JPanel(new GridLayout(9, 9));
        ArrayList<Ruutu> ruudut = pelilauta.getRuudut();
        for(int i=1;i<10;i++) {
            for(int j=1;j<10;j++) {
                for(Ruutu ruutu : ruudut) {
                    if(ruutu.getSijainti().getKorkeus()==i && ruutu.getSijainti().getLeveys()==j) {
                        JButton button = new JButton();
                        Nappi nappi = new Nappi(button, ruutu);
                        panel.add(button);
                        button.addMouseListener(new Hiirenkuuntelija(nappi));}}}}
        return panel;
    }
    
    private void asetaPelinTilaTeksti() {
        String tila="";
        if(this.pelilauta.peliKaynnissa()) {
            tila+="Peli käynnissä";
        } else {
            tila+="Hävisit";
        }
        this.pelinTila.setText(tila);
    }
    
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luodaanKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
}
