package ru.development.library.exception;

import ru.development.library.enumiration.ErrorMessage;

public abstract class LibraryException extends RuntimeException {

    protected LibraryException(ErrorMessage error, String id) {
        super(String.format(error.getMessage(), id));
    }
}
