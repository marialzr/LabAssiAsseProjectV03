package ro.ubb;

import junit.framework.TestCase;
import org.junit.Test;
import ro.ubb.src.Exceptions.ValidatorException;
import ro.ubb.src.Repository.XMLFileRepository.TemaLabXMLRepo;
import ro.ubb.src.Service.XMLFileService.TemaLabXMLService;
import ro.ubb.src.Validator.TemaLabValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestTemaLab extends TestCase {
    private TemaLabXMLService temaService;
    private String id, termenLimita, saptamanaPredarii, descriere;

    protected void setUp(){
        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo temaLabXMLRepo = new TemaLabXMLRepo(vt, "temaXML.xml");
        temaService = new TemaLabXMLService(temaLabXMLRepo);

        id = "1";
        termenLimita = "6";
        saptamanaPredarii = "4";
        descriere = "description";
    }

    @Test
    public void testAddTema() throws ValidatorException {
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};
        temaService.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, temaService.getSize());
    }



    @Test(expected = NumberFormatException.class)
    public void testStudentIdEmpty(){
        id = new String();
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};

        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> temaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, temaService.getSize());
    }

    @Test(expected = NumberFormatException.class)
    public void testStudentIdNull(){
        id = null;
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};

        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> temaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, temaService.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testDescriptionEmpty(){
        descriere = new String();
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};

        ValidatorException thrown = assertThrows(ValidatorException.class, () -> temaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, temaService.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testDescriptionNull(){
        descriere = null;
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};

        ValidatorException thrown = assertThrows(ValidatorException.class, () -> temaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, temaService.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testSaptamanaPredariiLess(){
        saptamanaPredarii = "-10";
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};

        ValidatorException thrown = assertThrows(ValidatorException.class, () -> temaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, temaService.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testSaptamanaPredariiGreater(){
        saptamanaPredarii = "20";
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};

        ValidatorException thrown = assertThrows(ValidatorException.class, () -> temaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, temaService.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testTermenLimitaLess(){
        termenLimita = "-10";
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};

        ValidatorException thrown = assertThrows(ValidatorException.class, () -> temaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, temaService.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testTermenLimitaGreater(){
        saptamanaPredarii = "20";
        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};

        ValidatorException thrown = assertThrows(ValidatorException.class, () -> temaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, temaService.getSize());
    }
}