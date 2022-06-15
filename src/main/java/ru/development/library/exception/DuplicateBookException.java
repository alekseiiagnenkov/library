package ru.development.library.exception;

import ru.development.library.enumiration.LibraryError;

public class DuplicateBookException extends LibraryException {
    public DuplicateBookException() {
        super(LibraryError.BOOK_ALREADY_EXIST);
    }
}
