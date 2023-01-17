package mk.studio.mkserv.apis.account.domain;

import lombok.*;
import mk.studio.mkserv.common.base.BaseEntity;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account extends BaseEntity implements Serializable {
    @NotNull
    @ColumnDefault("true")
    private boolean isActive; //사용여부

    private String email; // 이메일

    private String name; // 이름

    private String password; // 비밀번호



}
