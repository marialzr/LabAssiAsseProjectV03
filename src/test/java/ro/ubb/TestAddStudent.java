package ro.ubb;

import junit.framework.TestCase;
import org.junit.Test;
import ro.ubb.src.Exceptions.ValidatorException;
import ro.ubb.src.Repository.XMLFileRepository.StudentXMLRepo;
import ro.ubb.src.Service.XMLFileService.StudentXMLService;
import ro.ubb.src.Validator.StudentValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAddStudent extends TestCase {
    private StudentXMLService stsrv;
    private String id,nume,grupa,email,prof;


    protected void setUp(){
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        stsrv=new StudentXMLService(strepo);

        id = "1";
        nume = "Ema";
        grupa = "934";
        email = "ematurcu@gmail.com";
        prof = "Rares Boian";
    }

    @Test
    public void testAddStudent() throws ValidatorException {
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        stsrv.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, stsrv.getSize());
    }

    @Test(expected =  ValidatorException.class)
    public void testAddStudentIdNull() {
        id = null;
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        ValidatorException thrown = assertThrows(ValidatorException.class, () -> stsrv.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, stsrv.getSize());
    }

    @Test
    public void testAddStudentIdNotNull() throws ValidatorException {
        id = "1";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        stsrv.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, stsrv.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testAddStudentNumeNull() {
        nume = "";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        ValidatorException thrown = assertThrows(ValidatorException.class, () -> stsrv.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, stsrv.getSize());
    }

    @Test
    public void testAddStudentNumeNotNull() throws ValidatorException{
        nume = "Ema";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        stsrv.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, stsrv.getSize());
    }

    @Test
    public void testAddStudentIntegerGrupa() {
        grupa = "934";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        ValidatorException thrown = assertThrows(ValidatorException.class, () -> stsrv.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, stsrv.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testAddStudentWrongGrupa() {
        grupa = "ab";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        ValidatorException thrown = assertThrows(ValidatorException.class, () -> stsrv.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, stsrv.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testAddStudenEmailNull() {
        email = "";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        ValidatorException thrown = assertThrows(ValidatorException.class, () -> stsrv.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, stsrv.getSize());
    }

    @Test
    public void testAddStudentEmailNotNull() throws ValidatorException {
        email = "ema.turcu2@gmail.com";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        stsrv.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, stsrv.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testAddStudentIndrumatorNull() {
        prof = null;
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        ValidatorException thrown = assertThrows(ValidatorException.class, () -> stsrv.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, stsrv.getSize());
    }

    @Test
    public void testAddStudentIndrumatorNotNull() throws ValidatorException {
        prof = "Maria";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        stsrv.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, stsrv.getSize());
    }
}
