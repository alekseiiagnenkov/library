package ru.development.library.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.development.library.exceptions.LibraryError;
import ru.development.library.exceptions.LibraryException;
import ru.development.library.mapper.AuthorMapper;
import ru.development.library.mapper.BookMapper;
import ru.development.library.model.Book;
import ru.development.library.model.dto.request.BookRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;
import ru.development.library.model.dto.response.BookRsDTO;
import ru.development.library.repository.AuthorRepository;
import ru.development.library.repository.BookRepository;
import ru.development.library.servise.AuthorService;
import ru.development.library.servise.BookService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    private final BookMapper bookMapper;

    @Override
    public List<AuthorRsDTO> getAllAuthors(String id) throws LibraryException {
        Book entity = bookRepository.findById(id)
                .orElseThrow(() -> new LibraryException(LibraryError.BOOK_NOT_FOUND));
        return entity.getAuthorList().stream()
                .map(authorMapper::entityToRsDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookRsDTO get(String id) throws LibraryException {
        return bookMapper.entityToRsDto(bookRepository.findById(id)
                .orElseThrow(() -> new LibraryException(LibraryError.BOOK_NOT_FOUND)));
    }

    @Override
    public List<BookRsDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::entityToRsDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String create(BookRqDTO request) throws LibraryException {
        if (bookRepository.findBooksByName(request.getName()).isPresent()) {
            throw new LibraryException(LibraryError.BOOK_ALREADY_EXIST);
        }

        request.getAuthorList().removeAll(authorRepository.findAll().stream()
                .map(authorMapper::entityToRqDto)
                .collect(Collectors.toList()));
        Book book = bookMapper.dtoToEntity(request);
        book = bookRepository.save(book);
        return bookRepository.save(book).getId();
    }

    @Override
    @Transactional
    public BookRsDTO update(String id, BookRqDTO request) throws LibraryException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new LibraryException(LibraryError.BOOK_NOT_FOUND));

        book.setName(request.getName());
        return bookMapper.entityToRsDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public void delete(String id) throws LibraryException {
        bookRepository.findById(id).orElseThrow(() -> new LibraryException(LibraryError.AUTHOR_NOT_FOUND));
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookRsDTO> getBooksByFragmentName(String fragments) {
        return bookRepository.getBooksByFragmentName(fragments).stream()
                .map(bookMapper::entityToRsDto)
                .collect(Collectors.toList());
    }
}
