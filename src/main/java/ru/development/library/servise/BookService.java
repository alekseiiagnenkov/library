package ru.development.library.servise;

import ru.development.library.exceptions.LibraryException;
import ru.development.library.model.dto.request.BookRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;
import ru.development.library.model.dto.response.BookRsDTO;

import java.util.List;

public interface BookService extends BaseService<BookRqDTO, BookRsDTO> {

    List<BookRsDTO> getBooksByFragmentName(String fragments);

    List<AuthorRsDTO> getAllAuthors(Long id) throws LibraryException;

}
