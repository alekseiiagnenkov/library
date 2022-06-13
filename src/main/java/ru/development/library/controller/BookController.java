package ru.development.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.development.library.exceptions.LibraryException;
import ru.development.library.model.dto.request.BookRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;
import ru.development.library.model.dto.response.BookRsDTO;
import ru.development.library.servise.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    BookRsDTO get(@PathVariable("id") Long id) throws LibraryException {
        return bookService.get(id);
    }

    @GetMapping
    List<BookRsDTO> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}/authors")
    List<AuthorRsDTO> getAllAuthors(@PathVariable("id") Long id) throws LibraryException {
        return bookService.getAllAuthors(id);
    }

    @PostMapping("/create")
    BookRsDTO create(@RequestBody BookRqDTO dto) throws LibraryException {
        return bookService.create(dto);
    }

    @PutMapping("/update/{id}")
    BookRsDTO update(@PathVariable("id") Long id, @RequestBody BookRqDTO dto) throws LibraryException {
        return bookService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id) throws LibraryException {
        bookService.delete(id);
    }

}
