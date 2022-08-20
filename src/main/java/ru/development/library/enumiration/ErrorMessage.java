package ru.development.library.enumiration;

public enum ErrorMessage {

    BOOK_NOT_FOUND("Book with id = %s not found."),
    BOOK_ALREADY_EXIST("Book with name = %s is already in the library."),

    AUTHOR_NOT_FOUND("Author with id = %s not found."),
    AUTHOR_ALREADY_EXIST("%s is already in the library."),

    TECHNICAL_ERROR("A technical error has occurred."),

    VALIDATION_ERROR("Request validation error.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
