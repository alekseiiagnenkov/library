package ru.development.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.development.library.exception.AuthorNotFoundException;
import ru.development.library.exception.DuplicateAuthorException;
import ru.development.library.exception.LibraryException;
import ru.development.library.mapper.AuthorMapper;
import ru.development.library.mapper.BookMapper;
import ru.development.library.model.Author;
import ru.development.library.model.dto.request.AuthorRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;
import ru.development.library.model.dto.response.BookRsDTO;
import ru.development.library.repository.AuthorRepository;
import ru.development.library.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    private final BookMapper bookMapper;

    @Override
    public List<BookRsDTO> getAllBooks(String id) throws LibraryException {
        Author entity = authorRepository.findById(id)
                .orElseThrow(AuthorNotFoundException::new);
        return entity.getBookList().stream()
                .map(bookMapper::entityToRsDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorRsDTO get(String id) throws LibraryException {
        return authorMapper.entityToRsDto(authorRepository.findById(id)
                .orElseThrow(AuthorNotFoundException::new));
    }

    @Override
    public List<AuthorRsDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::entityToRsDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String create(AuthorRqDTO dto) throws LibraryException {
        if (authorRepository.getAuthorByFirstNameAndLastName(dto.getFirstName(), dto.getLastName()) != null) {
            throw new DuplicateAuthorException();
        }
        Author entity = authorMapper.dtoToEntity(dto);
        return authorRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public AuthorRsDTO update(String id, AuthorRqDTO dto) throws LibraryException {
        Author entity = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        entity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null)
            entity.setLastName(dto.getLastName());
        entity.setMale(dto.isMale());
        return authorMapper.entityToRsDto(authorRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(String id) throws LibraryException {
        authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        authorRepository.deleteById(id);
    }
}
