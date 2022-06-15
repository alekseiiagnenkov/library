package ru.development.library.exception;

import ru.development.library.enumiration.LibraryError;

public class AuthorNotFoundException extends LibraryException {

    public AuthorNotFoundException() {
        super(LibraryError.AUTHOR_NOT_FOUND);
    }
}
