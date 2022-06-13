package ru.development.library.exceptions;

public enum LibraryError {

    BOOK_NOT_FOUND("Book not found."),
    BOOK_ALREADY_EXIST("This book is already in the library."),

    AUTHOR_NOT_FOUND("Author not found."),
    AUTHOR_ALREADY_EXIST("This author is already in the library."),

    TECHNICAL_ERROR("A technical error has occurred."),

    VALIDATION_ERROR("Request validation error.");

    private final String message;

    LibraryError(final String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
