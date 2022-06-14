package ru.development.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.development.library.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

    Author getAuthorByFirstNameAndLastName(String firstName, String lastName);

    Author getAllById(String id);
}
