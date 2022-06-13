package ru.development.library.servise;

import ru.development.library.exceptions.LibraryException;
import ru.development.library.model.dto.request.AuthorRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;
import ru.development.library.model.dto.response.BookRsDTO;

import java.util.List;

public interface AuthorService extends BaseService<AuthorRqDTO, AuthorRsDTO>{

    List<BookRsDTO> getAllBooks(Long id) throws LibraryException;

}
