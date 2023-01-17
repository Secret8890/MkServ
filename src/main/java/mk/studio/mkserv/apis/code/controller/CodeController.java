package mk.studio.mkserv.apis.code.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import mk.studio.mkserv.apis.code.dto.CodeDto;
import mk.studio.mkserv.apis.code.service.CodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/apis/code")
public class CodeController {
    private final CodeService codeService;
    @Operation(summary = "코드 생성 요청", description = "시크릿 키등 중요정보를 데이터베이스에 저장하거나, 프론트와 공통적으로 사용해야 할 코드들을 저장.", tags = { "Code Controller" })
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = CodeDto.Create.class)))
    @PostMapping
    public ResponseEntity<String> createCodeAPI(@RequestBody CodeDto.Create create) {
        return codeService.createCode(create);
    }
}
