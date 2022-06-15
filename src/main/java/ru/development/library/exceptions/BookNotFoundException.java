package ru.development.library.exceptions;

import ru.development.library.enumiration.LibraryError;

public class BookNotFoundException extends LibraryException {

    public BookNotFoundException() {
        super(LibraryError.BOOK_NOT_FOUND);
    }

}
