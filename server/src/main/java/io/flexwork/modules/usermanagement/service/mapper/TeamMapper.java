package io.flexwork.modules.usermanagement.service.mapper;

import io.flexwork.modules.usermanagement.domain.Organization;
import io.flexwork.modules.usermanagement.domain.Team;
import io.flexwork.modules.usermanagement.service.dto.TeamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(target = "organizationId", source = "organization.id")
    TeamDTO teamToTeamDTO(Team team);

    @Mapping(
            target = "organization",
            expression = "java(ofOrganization(teamDTO.getOrganizationId()))")
    Team teamDTOToTeam(TeamDTO teamDTO);

    default Organization ofOrganization(Long organizationId) {
        return (organizationId == null) ? null : Organization.builder().id(organizationId).build();
    }
}
