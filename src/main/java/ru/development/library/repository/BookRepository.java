package ru.development.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.development.library.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBooksByName(String name);

    @Query("select b from Book as b where b.name like %?1%")
    List<Book> getBooksByFragmentName(String fragment);

}
