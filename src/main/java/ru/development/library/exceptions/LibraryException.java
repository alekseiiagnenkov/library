package ru.development.library.exceptions;

public class LibraryException extends Exception {

    private final String message;

    public LibraryException(LibraryError error){
        this.message = error.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
