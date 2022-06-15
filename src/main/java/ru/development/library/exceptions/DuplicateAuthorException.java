package ru.development.library.exceptions;

import ru.development.library.enumiration.LibraryError;

public class DuplicateAuthorException extends LibraryException{

    public DuplicateAuthorException() {
        super(LibraryError.AUTHOR_ALREADY_EXIST);
    }
}
