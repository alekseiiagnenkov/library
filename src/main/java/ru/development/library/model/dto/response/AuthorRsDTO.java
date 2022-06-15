package ru.development.library.model.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class AuthorRsDTO {

    private String id;

    private String firstName;

    private String lastName;

}
