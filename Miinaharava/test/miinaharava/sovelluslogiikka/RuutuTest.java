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
public class RuutuTest {
    
    public RuutuTest() {
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
    public void ruutuEiOleMerkitty() {
        Ruutu ruutu = new Ruutu();
        assertEquals(ruutu.merkitty(), false);
    }
    @Test
    public void ruutuEiOleMiina() {
        Ruutu ruutu = new Ruutu();
        assertEquals(ruutu.onMiina(), false);
    }
    @Test 
    public void ruutuOnAvaamaton() {
        Ruutu ruutu = new Ruutu();
        assertEquals(ruutu.avattu(), false);
    }
    @Test
    public void ruutuAvautuu() {
        Ruutu ruutu = new Ruutu();
        ruutu.avaa();
        assertEquals(ruutu.avattu(), true);
    }
    @Test
    public void avattuaRuutuaEiVoiSulkea() {
        Ruutu ruutu = new Ruutu();
        ruutu.avaa();
        ruutu.avaa();
        assertEquals(ruutu.avattu(), true);
    }
    @Test
    public void metrkittyaRuutuaEiVoiAvata() {
        Ruutu ruutu = new Ruutu();
        ruutu.merkinta();
        ruutu.avaa();
        assertEquals(ruutu.avattu(), false);
    }
   
    @Test
    public void miinojaEiOle() {
        Ruutu ruutu = new Ruutu();
        Ruutu toinenRuutu = new Ruutu();
        ruutu.lisaaYmpyroiva(toinenRuutu);
        assertEquals(ruutu.miinojenMaara(), 0);
        assertEquals(toinenRuutu.miinojenMaara(), 0);
    }
    @Test
    public void miinojaOnOikeaMaara() {
        Ruutu ruutu1 = new Ruutu();
        Ruutu ruutu2 = new Ruutu();
        Ruutu ruutu3 = new Ruutu();
        Ruutu ruutu4 = new Ruutu();
        ruutu1.lisaaYmpyroiva(ruutu2);
        ruutu1.lisaaYmpyroiva(ruutu3);
        ruutu1.lisaaYmpyroiva(ruutu4);
        ruutu2.miinaksi();
        ruutu4.miinaksi();
        assertEquals(ruutu1.miinojenMaara(), 2);
    }
}
