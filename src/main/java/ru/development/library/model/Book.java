package ru.development.library.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid", strategy = "uuid")
    @Size(max = 32)
    @Column(name = "book_id", unique = true, columnDefinition = "varchar(32)")
    private String id;

    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @Column(name = "create_date")
    private OffsetDateTime createDate;

    @ManyToMany(mappedBy = "bookList", cascade = CascadeType.ALL)
    private List<Author> authorList = new ArrayList<>();

    public List<Author> getAuthorList() {
        return List.copyOf(authorList);
    }
}