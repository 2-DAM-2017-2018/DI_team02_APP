/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.recurso;

import app.recurso.modelo.Recurso;
import app.recurso.modelo.ReservaRecurso;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agd19
 */
public class MainAppTest {
    
    public MainAppTest() {
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

    /**
     * Test of start method, of class MainApp.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Stage primaryStage = null;
        MainApp instance = new MainApp();
        instance.start(primaryStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecursoData method, of class MainApp.
     */
    @Test
    public void testGetRecursoData() {
        System.out.println("getRecursoData");
        MainApp instance = new MainApp();
        ObservableList<Recurso> expResult = null;
        ObservableList<Recurso> result = instance.getRecursoData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservaData method, of class MainApp.
     */
    @Test
    public void testGetReservaData() {
        System.out.println("getReservaData");
        MainApp instance = new MainApp();
        ObservableList<ReservaRecurso> expResult = null;
        ObservableList<ReservaRecurso> result = instance.getReservaData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CargarMenu method, of class MainApp.
     */
    @Test
    public void testCargarMenu() {
        System.out.println("CargarMenu");
        MainApp instance = new MainApp();
        instance.CargarMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showResourceEditDialog method, of class MainApp.
     */
    @Test
    public void testShowResourceEditDialog() {
        System.out.println("showResourceEditDialog");
        Recurso recurso = null;
        MainApp instance = new MainApp();
        boolean expResult = false;
        boolean result = instance.showResourceEditDialog(recurso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showReservaEditDialog method, of class MainApp.
     */
    @Test
    public void testShowReservaEditDialog() {
        System.out.println("showReservaEditDialog");
        ReservaRecurso reserva = null;
        MainApp instance = new MainApp();
        boolean expResult = false;
        boolean result = instance.showReservaEditDialog(reserva);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrimaryStage method, of class MainApp.
     */
    @Test
    public void testGetPrimaryStage() {
        System.out.println("getPrimaryStage");
        MainApp instance = new MainApp();
        Stage expResult = null;
        Stage result = instance.getPrimaryStage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MainApp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MainApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
