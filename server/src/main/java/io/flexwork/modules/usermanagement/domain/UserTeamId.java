package io.flexwork.modules.usermanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

@Embeddable
@Data
public class UserTeamId implements Serializable {

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "team_id", nullable = false)
    private Long teamId;

    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;
}
