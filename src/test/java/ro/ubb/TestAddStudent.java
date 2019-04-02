package ro.ubb;

import junit.framework.TestCase;
import org.junit.Test;
import ro.ubb.src.Domain.Student;
import ro.ubb.src.Exceptions.ValidatorException;
import ro.ubb.src.Repository.XMLFileRepository.StudentXMLRepo;
import ro.ubb.src.Service.XMLFileService.StudentXMLService;
import ro.ubb.src.Validator.StudentValidator;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

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
    public void testAdd() throws ValidatorException {
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        stsrv.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, stsrv.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testWrongGrupa() {
        grupa = "abc";
        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        ValidatorException thrown = assertThrows(ValidatorException.class,
                () -> stsrv.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, stsrv.getSize());
    }

}
