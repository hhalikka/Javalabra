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
public class PeliTest {
    
    public PeliTest() {
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
    public void peliOnKaynnissa() {
        Peli peli = new Peli();
        peli.aloitaPeli();
        assertEquals(peli.peliKaynnissa(), true);
    }
    @Test
    public void peliEiOleKaynnissaKunLopetettu() {
        Peli peli = new Peli();
        peli.aloitaPeli();
        peli.lopetaPeli();
        assertEquals(peli.peliKaynnissa(), false);
    }
    @Test
    public void peliaEiOleVoitettu() {
        Peli peli = new Peli();
        peli.aloitaPeli();
        assertEquals(peli.voitettu(), false);
    }
}
