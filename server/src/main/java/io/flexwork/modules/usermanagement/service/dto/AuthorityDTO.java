package io.flexwork.modules.usermanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDTO {

    private String name;

    private String descriptiveName;

    public AuthorityDTO(String name) {
        this(name, name);
    }
}
