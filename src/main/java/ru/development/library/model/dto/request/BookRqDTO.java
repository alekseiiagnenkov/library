package ru.development.library.model.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class BookRqDTO {

    @Setter
    @NotNull
    private String name;

    @NotNull
    private List<AuthorRqDTO> authorList;

    public List<AuthorRqDTO> getAuthorList() {
        return List.copyOf(authorList);
    }
}
