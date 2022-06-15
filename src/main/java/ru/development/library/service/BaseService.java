package ru.development.library.service;

import ru.development.library.exceptions.LibraryException;

import java.util.List;

public interface BaseService<REQUEST, RESPONSE> {

    RESPONSE get(String id) throws LibraryException;

    List<RESPONSE> getAll();

    String create(REQUEST dto) throws LibraryException;

    RESPONSE update(String id, REQUEST dto) throws LibraryException;

    void delete(String id) throws LibraryException;

}
