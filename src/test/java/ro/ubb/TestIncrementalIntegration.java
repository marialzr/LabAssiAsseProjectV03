package ro.ubb;

import junit.framework.TestCase;
import org.junit.Test;
import ro.ubb.src.Exceptions.ValidatorException;
import ro.ubb.src.Repository.XMLFileRepository.NotaXMLRepo;
import ro.ubb.src.Repository.XMLFileRepository.StudentXMLRepo;
import ro.ubb.src.Repository.XMLFileRepository.TemaLabXMLRepo;
import ro.ubb.src.Service.XMLFileService.NotaXMLService;
import ro.ubb.src.Service.XMLFileService.StudentXMLService;
import ro.ubb.src.Service.XMLFileService.TemaLabXMLService;
import ro.ubb.src.Validator.NotaValidator;
import ro.ubb.src.Validator.StudentValidator;
import ro.ubb.src.Validator.TemaLabValidator;

public class TestIncrementalIntegration extends TestCase {

    private NotaXMLService notaService;
    private StudentXMLService stsrv;
    private TemaLabXMLService temaService;

    protected void setUp(){
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        stsrv=new StudentXMLService(strepo);

        NotaValidator vn=new NotaValidator();
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        notaService=new NotaXMLService(ntrepo);

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo temaLabXMLRepo = new TemaLabXMLRepo(vt, "temaXML.xml");
        temaService = new TemaLabXMLService(temaLabXMLRepo);
    }

    @Test
    public void testAddStudent() throws ValidatorException {
        String id = "1";
        String nume = "Student";
        String grupa = "934";
        String email = "stud@gmail.com";
        String prof = "Prof";

        int sizeBefore = stsrv.getSize();
        String params[] ={id, nume, grupa, email, prof};
        stsrv.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, stsrv.getSize());
    }

    @Test
    public void testAddAssignment() throws ValidatorException {
        String id = "1";
        String termenLimita = "6";
        String saptamanaPredarii = "4";
        String descriere = "description";

        int sizeBefore = temaService.getSize();
        String params[] = {id, descriere, termenLimita, saptamanaPredarii};
        temaService.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, temaService.getSize());
    }

    @Test
    public void testAddGrade() throws ValidatorException {
        String id = "1";
        String ids = "1";
        String idt = "1";
        String val = "3";
        String data = "2018-03-01T13:15:12";

        String params[] ={id,ids,idt,val,data};
        int sizeBefore = notaService.getSize();
        notaService.add(params);
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, notaService.getSize());
    }

    @Test
    public void testAddAssignmentIntegr() throws ValidatorException {
        testAddStudent();
        testAddAssignment();
    }

    @Test
    public void testAddGradeIntegr() throws ValidatorException {
        testAddStudent();
        testAddAssignment();
        testAddGrade();
    }
}
