package ro.ubb.src;


import ro.ubb.src.Exceptions.ValidatorException;
import ro.ubb.src.Repository.XMLFileRepository.NotaXMLRepo;
import ro.ubb.src.Repository.XMLFileRepository.StudentXMLRepo;
import ro.ubb.src.Repository.XMLFileRepository.TemaLabXMLRepo;
import ro.ubb.src.Service.XMLFileService.NotaXMLService;
import ro.ubb.src.Service.XMLFileService.StudentXMLService;
import ro.ubb.src.Service.XMLFileService.TemaLabXMLService;
import ro.ubb.src.UI.ui;
import ro.ubb.src.Validator.NotaValidator;
import ro.ubb.src.Validator.StudentValidator;
import ro.ubb.src.Validator.TemaLabValidator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}
