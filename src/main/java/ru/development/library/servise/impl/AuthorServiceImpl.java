package ru.development.library.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.development.library.exceptions.LibraryError;
import ru.development.library.exceptions.LibraryException;
import ru.development.library.mapper.AuthorMapper;
import ru.development.library.mapper.BookMapper;
import ru.development.library.model.Author;
import ru.development.library.model.dto.request.AuthorRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;
import ru.development.library.model.dto.response.BookRsDTO;
import ru.development.library.repository.AuthorRepository;
import ru.development.library.servise.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    private final BookMapper bookMapper;

    @Override
    public List<BookRsDTO> getAllBooks(Long id) throws LibraryException {
        Author entity = authorRepository.findById(id)
                .orElseThrow(() -> new LibraryException(LibraryError.AUTHOR_NOT_FOUND));
        return entity.getBookList().stream()
                .map(bookMapper::entityToRsDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorRsDTO get(Long id) throws LibraryException {
        return authorMapper.entityToRsDto(authorRepository.findById(id)
                .orElseThrow(() -> new LibraryException(LibraryError.AUTHOR_NOT_FOUND)));
    }

    @Override
    public List<AuthorRsDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::entityToRsDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AuthorRsDTO create(AuthorRqDTO dto) throws LibraryException {
        if (authorRepository.getAuthorByFirstNameAndLastName(dto.getFirstName(), dto.getLastName()) != null) {
            throw new LibraryException(LibraryError.AUTHOR_ALREADY_EXIST);
        }
        Author entity = authorMapper.dtoToEntity(dto);
        return authorMapper.entityToRsDto(authorRepository.save(entity));
    }

    @Override
    @Transactional
    public AuthorRsDTO update(Long id, AuthorRqDTO dto) throws LibraryException {
        Author entity = authorRepository.findById(id).orElseThrow(() -> new LibraryException(LibraryError.AUTHOR_NOT_FOUND));
        entity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null)
            entity.setLastName(dto.getLastName());
        entity.setMale(dto.isMale());
        return authorMapper.entityToRsDto(authorRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) throws LibraryException {
        authorRepository.findById(id).orElseThrow(() -> new LibraryException(LibraryError.AUTHOR_NOT_FOUND));
        authorRepository.deleteById(id);
    }
}
