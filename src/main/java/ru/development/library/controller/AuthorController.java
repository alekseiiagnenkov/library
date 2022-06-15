package ru.development.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.development.library.exception.LibraryException;
import ru.development.library.model.dto.request.AuthorRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;
import ru.development.library.model.dto.response.BookRsDTO;
import ru.development.library.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    AuthorRsDTO get(@PathVariable("id") String id) throws LibraryException {
        return authorService.get(id);
    }

    @GetMapping
    List<AuthorRsDTO> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}/books")
    List<BookRsDTO> getAllBooks(@PathVariable("id") String id) throws LibraryException {
        return authorService.getAllBooks(id);
    }

    @PostMapping("/create")
    String create(@RequestBody AuthorRqDTO dto) throws LibraryException {
        return authorService.create(dto);
    }

    @PutMapping("/update/{id}")
    AuthorRsDTO update(@PathVariable("id") String id, @RequestBody AuthorRqDTO dto) throws LibraryException {
        return authorService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") String id) throws LibraryException {
        authorService.delete(id);
    }
}
