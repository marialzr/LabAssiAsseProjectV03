package ro.ubb;

import junit.framework.TestCase;
import org.junit.Test;
import ro.ubb.src.Exceptions.ValidatorException;
import ro.ubb.src.Repository.XMLFileRepository.NotaXMLRepo;
import ro.ubb.src.Service.TxtFileService.NotaService;
import ro.ubb.src.Service.XMLFileService.NotaXMLService;
import ro.ubb.src.Validator.NotaValidator;

import javax.xml.bind.ValidationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAddAssignment extends TestCase {
    private NotaXMLService notaService;
    private String id;
    private String ids;
    private String idt;
    private String val;
    private String data;


    protected void setUp(){
        NotaValidator vn=new NotaValidator();
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        notaService=new NotaXMLService(ntrepo);

        id = "1";
        ids = "1";
        idt = "1";
        val = "3";
        data = "2018-03-01T13:15:12";
    }

    @Test
    public void testAdd() throws ValidatorException {
        String params[] ={id,ids,idt,val,data};
        int sizeBefore = notaService.getSize();
        notaService.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, notaService.getSize());
    }

    @Test(expected = ValidatorException.class)
    public void testAddNull(){
        id = "-1";
        String params[] ={id,ids,idt,val,data};
        int sizeBefore = notaService.getSize();

        ValidatorException thrown = assertThrows(ValidatorException.class, () -> notaService.add(params), "Expected doThing() to throw, but it didn't");

        assertEquals(sizeBefore, notaService.getSize());
    }
}
