package ru.development.library.exception;

import ru.development.library.enumiration.ErrorMessage;

public class DuplicateBookException extends LibraryException {
    public DuplicateBookException(String name) {
        super(ErrorMessage.BOOK_ALREADY_EXIST, name);
    }
}
