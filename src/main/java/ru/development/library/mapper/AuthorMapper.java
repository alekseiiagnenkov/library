package ru.development.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.development.library.model.Author;
import ru.development.library.model.dto.request.AuthorRqDTO;
import ru.development.library.model.dto.response.AuthorRsDTO;

import java.time.OffsetDateTime;

@Mapper(componentModel = "spring", imports = {OffsetDateTime.class})
public interface AuthorMapper {

    @Mapping(target = "createDate", expression = "java(OffsetDateTime.now())")
    Author dtoToEntity(AuthorRqDTO dto);

    AuthorRsDTO entityToRsDto(Author entity);

    AuthorRqDTO entityToRqDto(Author entity);

}
