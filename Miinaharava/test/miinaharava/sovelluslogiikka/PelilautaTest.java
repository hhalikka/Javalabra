/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Heidi
 */
public class PelilautaTest {
    
    public PelilautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void ruutujaOikeaMaara() {
        Pelilauta pelilauta = new Pelilauta();
        pelilauta.lisaaRuudut();
        assertEquals(pelilauta.getRuudut().size(), 256);
    }
    @Test
    public void miinojaNeljakymmenta() {
        Pelilauta pelilauta = new Pelilauta();
        pelilauta.lisaaRuudut();
        pelilauta.miinoita();
        int i=0;
        for(Ruutu ruutu:pelilauta.getRuudut()) {
            if(ruutu.onMiina()) {
                i++;
            }
        }
        assertEquals(i, 40);
    }
}
