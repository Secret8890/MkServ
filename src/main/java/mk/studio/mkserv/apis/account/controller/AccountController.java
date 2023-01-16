package mk.studio.mkserv.apis.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.studio.mkserv.apis.account.domain.Account;
import mk.studio.mkserv.apis.account.dto.AccountDto;
import mk.studio.mkserv.apis.account.repository.AccountRepository;
import mk.studio.mkserv.apis.redis.service.RedisService;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/account")
@Slf4j
@CrossOrigin(maxAge = 3600)
public class AccountController {
    private final AccountRepository accountRepository;
    //private final JwtTokenProvider jwtTokenProvider; todo JWT 를 제대로 사용하기위해 추후 주석 비활성화
    private final RedisService redisService;

    @PostMapping("/register")
    public void register(@RequestBody AccountDto.Create account) {

        log.info(account.toString());
        //회원가입
        accountRepository.save(Account.builder()
                .email(account.getEmail())
                .password(account.getPassword())
                .name(account.getName())
                .build()
        );
    }

    @PostMapping("/login")
    public AccountDto.Response login(@RequestBody AccountDto.Login login) throws AuthenticationException {

        String now = LocalDateTime.now().toString();
        // 로그인
        Account account = accountRepository.findByEmailAndPassword(login.getEmail(), login.getPassword()).orElseThrow(AuthenticationException::new);
        AccountDto.Response response = new AccountDto.Response();
        response.setName(account.getName());
        response.setEmail(account.getEmail());
        response.setRefreshToken(now);
        redisService.setValues(account.getId(), now);
        return response;
    }
}
