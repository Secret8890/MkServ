package mk.studio.mkserv.apis.code.repository;

import mk.studio.mkserv.apis.code.domain.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code,String> {

}
