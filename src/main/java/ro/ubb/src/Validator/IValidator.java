package ro.ubb.src.Validator;

import ro.ubb.src.Exceptions.ValidatorException;

public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}