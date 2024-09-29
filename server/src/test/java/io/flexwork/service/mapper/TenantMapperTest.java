package io.flexwork.service.mapper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.flexwork.modules.usermanagement.domain.Tenant;
import io.flexwork.modules.usermanagement.service.dto.TenantDTO;
import io.flexwork.modules.usermanagement.service.mapper.TenantMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

/** Unit tests for {@link TenantMapper}. */
public class TenantMapperTest {

    private TenantMapper tenantMapper = Mappers.getMapper(TenantMapper.class);

    @Test
    public void testTenantDtoToTenant() {
        TenantDTO tenantDTO =
                TenantDTO.builder()
                        .id(1L)
                        .name("test")
                        .description("description")
                        .logoUrl("logoUrl")
                        .domain("domain")
                        .build();

        Tenant tenant = tenantMapper.tenantDtoToTenant(tenantDTO);
        assertAll(
                () -> assertEquals(1L, tenant.getId()),
                () -> assertEquals("test", tenant.getName()),
                () -> assertEquals("logoUrl", tenant.getLogoUrl()),
                () -> assertEquals("domain", tenant.getDomain()),
                () -> assertEquals("description", tenant.getDescription()));
    }

    @Test
    public void testTenantToTenantDTO() {
        Tenant tenant =
                Tenant.builder()
                        .nameId("nameId")
                        .id(1L)
                        .name("name")
                        .domain("domain")
                        .logoUrl("logoUrl")
                        .description("description")
                        .build();
        TenantDTO tenantDTO = tenantMapper.tenantToTenantDto(tenant);
        assertAll(
                () -> assertEquals(1L, tenantDTO.getId()),
                () -> assertEquals("name", tenantDTO.getName()),
                () -> assertEquals("domain", tenantDTO.getDomain()),
                () -> assertEquals("logoUrl", tenantDTO.getLogoUrl()),
                () -> assertEquals("description", tenantDTO.getDescription()));
    }
}
