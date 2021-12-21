/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import App.Biography;
import java.util.ArrayList;
import App.ManageBiographySystem;
import App.Biographies;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason
 */
public class ManageBiographySystemTest {

    public ManageBiographySystemTest() {
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
    public void addNewBio() {
        ArrayList bios = ManageBiographySystem.getBios();
        ArrayList specialities = new ArrayList();
        specialities.add("Consumer");
        specialities.add("Financial");
        specialities.add("Retail");
        String newType = ("Financial");
        String[][] constructorInput = {{"5", "Test_Text", "1", "Financial", "31/01/2021"}};
        Biography newBio = new Biography(0, constructorInput);
        ArrayList<Biographies> methodreturn = ManageBiographySystem.addNewBio(bios, specialities, newType, newBio);
        Biography getResult = (Biography) methodreturn.get(1).getBios().get(1);
        String result = getResult.getText();
        String expectedResult = "Test_Text";
        assertEquals(result, expectedResult);
    }

    @Test
    public void updateBio() {
        ArrayList bios = ManageBiographySystem.getBios();
        Biographies bioGroup = (Biographies) bios.get(0);
        ManageBiographySystem.updateBio(bios, "Test_Text", 2, 0);
        ArrayList<Biography> bioList = bioGroup.getBios();
        Biography bio = (Biography) bioList.get(2);
        String result = bio.getEdited();
        String result2 = bio.getText();
        String expectedResult = "31/01/2021";
        String expectedResult2 = "Test_Text";
        assertEquals(result, expectedResult);
        assertEquals(result2, expectedResult2);
    }
}
