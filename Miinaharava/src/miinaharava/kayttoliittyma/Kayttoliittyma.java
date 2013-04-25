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
import miinaharava.sovelluslogiikka.Peli;
import miinaharava.sovelluslogiikka.Pelilauta;
import miinaharava.sovelluslogiikka.Ruutu;
import miinaharava.sovelluslogiikka.Sijainti;

/**
 *
 * @author Heidi
 */
public class Kayttoliittyma implements Runnable {
    private ArrayList<Nappi> napit;
    private Peli peli;
    private JLabel pelinTila;
    private JFrame frame;
    private Pelilauta pelilauta;
    private boolean peliKaynnissa;
    
    public Kayttoliittyma(Peli peli) {
        this.napit=new ArrayList<Nappi>();
        this.pelinTila=new JLabel();
        this.pelilauta=peli.getLauta();
        this.peliKaynnissa=true;
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
        lisataanNapeilleYmpyroivat();
    }
    
    public JPanel luoRuudut() {
        JPanel panel = new JPanel(new GridLayout(9, 9));
        ArrayList<Ruutu> ruudut = this.pelilauta.getRuudut();
        for(int i=1;i<10;i++) {
            for(int j=1;j<10;j++) {
                for(Ruutu ruutu : ruudut) {
                    if(ruutu.getSijainti().getKorkeus()==i && ruutu.getSijainti().getLeveys()==j) {
                        JButton button = new JButton();
                        Nappi nappi = new Nappi(button, ruutu);
                        this.napit.add(nappi);
                        panel.add(button);
                        button.addMouseListener(new Hiirenkuuntelija(nappi, this));}}}}
        return panel;
    }
    
    public void asetaPelinTilaTeksti() {
        String tila="";
        if(this.peliKaynnissa) {
            tila+="Peli käynnissä";
        } else {
            tila+="Hävisit!";
        }
        this.pelinTila.setText(tila);
    }
    
    public void lisataanNapeilleYmpyroivat() {
        for(Nappi nappi:this.napit) {
            for(Nappi ympyroivaksiLisattava:this.napit) {
                if(nappi.getSijainti().onYmpyroiva(ympyroivaksiLisattava.getSijainti())){
                    nappi.lisaaYmpyroivaksi(ympyroivaksiLisattava);
                }
            }
        }
    }
    
    public void lopetaPeli() {
        this.peliKaynnissa=false;
        asetaPelinTilaTeksti();
    }
    public boolean peliKaynnissa() {
        return this.peliKaynnissa;
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
