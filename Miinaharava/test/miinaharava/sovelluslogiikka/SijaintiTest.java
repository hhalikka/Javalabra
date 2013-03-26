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
public class SijaintiTest {
    
    public SijaintiTest() {
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
    public void tunnistaaSijainnitSamoiksi() {
        Sijainti eka = new Sijainti(1, 7);
        Sijainti toka = new Sijainti(1, 7);
        assertEquals(true, eka.samaPaikka(toka));
    }
    @Test
    public void tunnistaaSijainnitEriPaikoiksi() {
        Sijainti eka = new Sijainti(1, 3);
        Sijainti toka = new Sijainti(1, 4);
        assertEquals(false, eka.samaPaikka(toka));
    }
    @Test
    public void korkeudellaEtaisyysOnOikein() {
        Sijainti eka = new Sijainti(1, 5);
        Sijainti toka = new Sijainti(1, 7);
        assertEquals(2, eka.korkeusEtaisyys(toka));
    }
    @Test
    public void leveydellaEtaisyysOnOikein() {
        Sijainti eka = new Sijainti(4, 7);
        Sijainti toka = new Sijainti(10, 7);
        assertEquals(6, eka.leveysEtaisyys(toka));
    }
    @Test
    public void eiLuuleSamaaYmpyroivaksi() {
        Sijainti eka = new Sijainti(1, 7);
        Sijainti toka = new Sijainti(1, 7);
        assertEquals(false, eka.onYmpyroiva(toka));
    }
    @Test
    public void tunnistaaYmpyroivat() {
        Sijainti eka = new Sijainti(1, 7);
        Sijainti toka = new Sijainti(2, 6);
        Sijainti kolmas = new Sijainti(3,6);
        assertEquals(true, eka.onYmpyroiva(toka));
        assertEquals(true, toka.onYmpyroiva(kolmas));
    }
}
