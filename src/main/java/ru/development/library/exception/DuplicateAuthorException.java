package ru.development.library.exception;

import ru.development.library.enumiration.ErrorMessage;

public class DuplicateAuthorException extends LibraryException {

    public DuplicateAuthorException(String firstname, String lastname) {
        super(ErrorMessage.AUTHOR_ALREADY_EXIST, firstname + " " + lastname);
    }
}
