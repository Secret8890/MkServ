package mk.studio.mkserv.apis.account.repository;

import mk.studio.mkserv.apis.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // 이메일과 패스워드로 계정정보 찾기.
    Optional<Account> findByEmailAndPassword(String email, String password);


}
