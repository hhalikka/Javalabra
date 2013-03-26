/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

/**
 *
 * @author Heidi
 */
public class Sijainti {
    private int leveysSijainti;
    private int korkeusSijainti;
    
    public Sijainti(int leveys, int korkeus) {
        this.leveysSijainti=leveys;
        this.korkeusSijainti=korkeus;
    }
    
    public boolean samaPaikka(Sijainti kasiteltava) {
        if(this.korkeusEtaisyys(kasiteltava)+this.leveysEtaisyys(kasiteltava)==0){
            return true;
        }
        return false;
    }
    
    public int korkeusEtaisyys(Sijainti kasiteltava) {
        return Math.abs(this.korkeusSijainti-kasiteltava.korkeusSijainti);
    }
    
    public int leveysEtaisyys(Sijainti kasiteltava) {
        return Math.abs(this.leveysSijainti-kasiteltava.leveysSijainti);
    }
    
    public boolean onYmpyroiva(Sijainti kasiteltava) {
        if(this.samaPaikka(kasiteltava)) {
            return false;
        }
        if(this.korkeusEtaisyys(kasiteltava)>1 || this.leveysEtaisyys(kasiteltava)>1) {
            return false;
        }
        return true;
    }
        
   
}
