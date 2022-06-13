package ru.development.library.model.dto.response;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookRsDTO {

    @NotNull
    private String name;

}
