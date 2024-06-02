package ru.skypro.StreamAPI.Exceptions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
