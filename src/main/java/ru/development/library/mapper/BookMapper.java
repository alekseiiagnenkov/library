package ru.development.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.development.library.model.Book;
import ru.development.library.model.dto.request.BookRqDTO;
import ru.development.library.model.dto.response.BookRsDTO;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {OffsetDateTime.class, AuthorMapper.class, Collectors.class})
public abstract class BookMapper {

    @Autowired
    protected AuthorMapper authorMapper;

    @Mapping(target = "createDate", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "authorList", expression =
            "java(dto.getAuthorList().stream()" +
                    ".map(authorMapper::dtoToEntity)" +
                    ".collect(Collectors.toList()))")
    public abstract Book dtoToEntity(BookRqDTO dto);

    public abstract BookRsDTO entityToRsDto(Book entity);

    public abstract BookRqDTO entityToRqDto(Book entity);


}
