package ro.ubb.src.Repository.MemoryRepository;


import ro.ubb.src.Domain.Nota;
import ro.ubb.src.Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer, Nota> {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}