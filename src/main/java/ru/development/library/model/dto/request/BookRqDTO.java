package ru.development.library.model.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRqDTO {

    @NotNull
    private String name;

    private List<AuthorRqDTO> authorList;

}
