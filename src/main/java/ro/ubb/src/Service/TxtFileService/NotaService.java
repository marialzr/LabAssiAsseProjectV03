package ro.ubb.src.Service.TxtFileService;

import ro.ubb.src.Domain.Nota;
import ro.ubb.src.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
