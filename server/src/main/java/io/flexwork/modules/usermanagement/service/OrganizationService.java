package io.flexwork.modules.usermanagement.service;

import static io.flexwork.query.QueryUtils.buildSpecification;

import io.flexwork.modules.usermanagement.domain.Organization;
import io.flexwork.modules.usermanagement.repository.OrganizationRepository;
import io.flexwork.query.QueryFilter;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(Long id, Organization updatedOrganization) {
        // Find existing organization
        Organization existingOrganization =
                organizationRepository
                        .findById(id)
                        .orElseThrow(
                                () ->
                                        new EntityNotFoundException(
                                                "Organization not found with id: " + id));

        // Update organization details
        existingOrganization.setName(updatedOrganization.getName());
        existingOrganization.setLogoUrl(updatedOrganization.getLogoUrl());
        existingOrganization.setSlogan(updatedOrganization.getSlogan());
        existingOrganization.setDescription(updatedOrganization.getDescription());

        // Save updated organization
        return organizationRepository.save(existingOrganization);
    }

    public void deleteOrganization(Long id) {
        // Check if the organization exists
        Organization existingOrganization =
                organizationRepository
                        .findById(id)
                        .orElseThrow(
                                () ->
                                        new EntityNotFoundException(
                                                "Organization not found with id: " + id));

        // Delete the organization
        organizationRepository.delete(existingOrganization);
    }

    public Organization findOrganizationById(Long id) {
        return organizationRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Organization not found with id: " + id));
    }

    public Page<Organization> findOrganizations(List<QueryFilter> filters, Pageable pageable) {
        Specification<Organization> spec = buildSpecification(filters);
        return organizationRepository.findAll(spec, pageable);
    }
}
