/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

/**
 * Yhden ruudun sijainnin pelilaudalla tallettava olio,
 * @author Heidi
 */
public class Sijainti {
    private int leveysSijainti;
    private int korkeusSijainti;
    
    public Sijainti(int leveys, int korkeus) {
        this.leveysSijainti=leveys;
        this.korkeusSijainti=korkeus;
    }
    /**
    * Kertoo, ovatko parametrina annettu sijainti ja sijainti, jolle 
    * metodia kutsutaan, samat.
    *
    * @param kasiteltava toinen sijainti   
    * 
    * @return true, mikäli sijainnit ovat samat, muuten false.
    */
    public boolean samaPaikka(Sijainti kasiteltava) {
        if(this.korkeusEtaisyys(kasiteltava)+this.leveysEtaisyys(kasiteltava)==0){
            return true;
        }
        return false;
    }
    /**
    * Kertoo kahden sijainnin etäisyyden korkeustasolla.
    *
    * @param kasiteltava toinen sijainti  
    * 
    * @return sijaintien välinen etäisyys korkeudella
    */
    public int korkeusEtaisyys(Sijainti kasiteltava) {
        return Math.abs(this.korkeusSijainti-kasiteltava.korkeusSijainti);
    }
    /**
    * Kertoo kahden sijainnin etäisyyden leveystasolla.
    *
    * @param kasiteltava toinen sijainti   
    * 
    * @return sijaintien välinen etäisyys leveydellä
    */
    public int leveysEtaisyys(Sijainti kasiteltava) {
        return Math.abs(this.leveysSijainti-kasiteltava.leveysSijainti);
    }
    /**
    *Palautta true, mikäli parametrina annettu sijainti sijaitsee sijainnin,
    * jolle metodia kutsutaan, ympärillä, eli ruudut ovat kosketuksissa.
    *
    * @param kasiteltava toinen sijainti
    * 
    * @return true, mikäli sijainnit ovat kosketuksissa, muuten false.
    */
    public boolean onYmpyroiva(Sijainti kasiteltava) {
        if(this.samaPaikka(kasiteltava)) {
            return false; }
        if(this.korkeusEtaisyys(kasiteltava)>1 || this.leveysEtaisyys(kasiteltava)>1) {
            return false; }
        return true;
    }
    public int getKorkeus() {
        return this.korkeusSijainti;
    }
    public int getLeveys() {
        return this.leveysSijainti;
    }
        
   
}
