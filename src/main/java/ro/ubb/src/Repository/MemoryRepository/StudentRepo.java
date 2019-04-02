package ro.ubb.src.Repository.MemoryRepository;

import ro.ubb.src.Domain.Student;
import ro.ubb.src.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}