package ru.development.library.model.dto.request;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Setter
@Getter
@EqualsAndHashCode
public class AuthorRqDTO {

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    private boolean male;


}
