package ru.development.library.servise;

import ru.development.library.exceptions.LibraryException;

import java.util.List;

public interface BaseService<REQUEST, RESPONSE> {

    RESPONSE get(Long id) throws LibraryException;

    List<RESPONSE> getAll();

    RESPONSE create(REQUEST dto) throws LibraryException;

    RESPONSE update(Long id, REQUEST dto) throws LibraryException;

    void delete(Long id) throws LibraryException;

}
