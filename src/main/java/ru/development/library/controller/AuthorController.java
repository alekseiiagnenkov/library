package ru.development.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.development.library.exceptions.LibraryException;
import ru.development.library.model.dto.request.AuthorRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;
import ru.development.library.model.dto.response.BookRsDTO;
import ru.development.library.servise.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    AuthorRsDTO get(@PathVariable("id") Long id) throws LibraryException {
        return authorService.get(id);
    }

    @GetMapping
    List<AuthorRsDTO> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}/books")
    List<BookRsDTO> getAllBooks(@PathVariable("id") Long id) throws LibraryException {
        return authorService.getAllBooks(id);
    }

    @PostMapping("/create")
    AuthorRsDTO create(@RequestBody AuthorRqDTO dto) throws LibraryException {
        return authorService.create(dto);
    }

    @PutMapping("/update/{id}")
    AuthorRsDTO update(@PathVariable("id") Long id, @RequestBody AuthorRqDTO dto) throws LibraryException {
        return authorService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id) throws LibraryException {
        authorService.delete(id);
    }
}
