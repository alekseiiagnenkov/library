package ru.development.library.exception;

import ru.development.library.enumiration.ErrorMessage;

public class BookNotFoundException extends LibraryException {

    public BookNotFoundException(String id) {
        super(ErrorMessage.BOOK_NOT_FOUND, id);
    }

}
