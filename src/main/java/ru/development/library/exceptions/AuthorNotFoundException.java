package ru.development.library.exceptions;

import ru.development.library.enumiration.LibraryError;

public class AuthorNotFoundException extends LibraryException {

    public AuthorNotFoundException() {
        super(LibraryError.AUTHOR_NOT_FOUND);
    }
}
