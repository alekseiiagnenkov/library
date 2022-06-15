package ru.development.library.exceptions;

import ru.development.library.enumiration.LibraryError;

public class DuplicateBookException extends LibraryException {
    public DuplicateBookException() {
        super(LibraryError.BOOK_ALREADY_EXIST);
    }
}
