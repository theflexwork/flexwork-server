package io.flexwork.security.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fw_authority_resource_permissions")
@Data
public class AuthorityResourcePermission {

    @EmbeddedId private AuthorityResourcePermissionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("authorityName")
    private Authority authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "resourceId")
    private Resource resource;

    @Column(name = "permission", nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Permission permission;
}
