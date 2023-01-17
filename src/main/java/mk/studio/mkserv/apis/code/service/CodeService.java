package mk.studio.mkserv.apis.code.service;

import lombok.RequiredArgsConstructor;
import mk.studio.mkserv.apis.code.domain.Code;
import mk.studio.mkserv.apis.code.dto.CodeDto;
import mk.studio.mkserv.apis.code.dto.CodeDtoMapper;
import mk.studio.mkserv.apis.code.repository.CodeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CodeService {
    private final CodeRepository codeRepository;

    @Transactional
    public ResponseEntity<String> createCode(CodeDto.Create create) {
        Code code = CodeDtoMapper.INSTANCE.create(create);
        codeRepository.save(code);
        return ResponseEntity.ok().build();
    }
}
