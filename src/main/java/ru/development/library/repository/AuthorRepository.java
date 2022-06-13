package ru.development.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.development.library.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getAuthorByFirstNameAndLastName(String firstName, String lastName);

    Author getAllById(Long id);
}
