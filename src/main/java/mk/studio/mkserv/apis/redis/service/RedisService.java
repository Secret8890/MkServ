package mk.studio.mkserv.apis.redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

// RedisSerivce
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    // 키-벨류 설정
    public void setValues(Long id, String token){
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set(id.toString(), token, Duration.ofMinutes(3));  // 3분 뒤 메모리에서 삭제된다.
    }

    // 키값으로 벨류 가져오기
    public String getValues(Long id){
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        return values.get(id.toString());
    }

    // 키-벨류 삭제
    public void delValues(Long id) {
        redisTemplate.delete(id.toString());
    }
}