package ru.development.library.exception;

import ru.development.library.enumiration.ErrorMessage;

public class AuthorNotFoundException extends LibraryException {

    public AuthorNotFoundException(String id) {
        super(ErrorMessage.AUTHOR_NOT_FOUND, id);
    }
}
