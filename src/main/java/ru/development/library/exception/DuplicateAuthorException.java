package ru.development.library.exception;

import ru.development.library.enumiration.LibraryError;

public class DuplicateAuthorException extends LibraryException{

    public DuplicateAuthorException() {
        super(LibraryError.AUTHOR_ALREADY_EXIST);
    }
}
