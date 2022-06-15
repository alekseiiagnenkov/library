package ru.development.library.exceptions;

import ru.development.library.enumiration.LibraryError;

public abstract class LibraryException extends RuntimeException {

    protected LibraryException(LibraryError error) {
        super(error.getMessage());
    }
}
