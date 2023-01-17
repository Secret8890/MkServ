package mk.studio.mkserv.apis.code.domain;


import lombok.Getter;
import lombok.Setter;
import mk.studio.mkserv.apis.code.dto.CodeDto;
import mk.studio.mkserv.apis.code.dto.CodeDtoMapper;
import mk.studio.mkserv.common.base.NonIdBaseEntity;
import mk.studio.mkserv.common.interface_entity.EntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Code extends NonIdBaseEntity implements EntityBase {

    @Id
    @Column(nullable = false, unique = true)
    private String keyCode;

    private String secretKey;



    @Override
    public CodeDto.Response toResponse() {
        return CodeDtoMapper.INSTANCE.toResponse(this);
    }
}
