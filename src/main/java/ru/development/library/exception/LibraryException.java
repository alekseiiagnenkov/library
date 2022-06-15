package ru.development.library.exception;

import ru.development.library.enumiration.LibraryError;

public abstract class LibraryException extends RuntimeException {

    protected LibraryException(LibraryError error) {
        super(error.getMessage());
    }
}
