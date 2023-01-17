package mk.studio.mkserv.apis.code.dto;

import mk.studio.mkserv.apis.code.domain.Code;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CodeDtoMapper {

    CodeDtoMapper INSTANCE = Mappers.getMapper(CodeDtoMapper.class);
    Code create(CodeDto.Create create);

    CodeDto.Response toResponse(Code code);
}
