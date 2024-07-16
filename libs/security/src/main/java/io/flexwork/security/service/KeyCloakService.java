package io.flexwork.security.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.flexwork.security.domain.Tenant;
import io.flexwork.security.domain.User;
import java.util.HashMap;
import lombok.SneakyThrows;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
public class KeyCloakService {

    private static Logger log = LoggerFactory.getLogger(KeyCloakService.class);

    private SpringTemplateEngine templateEngine;

    private ObjectMapper om = new ObjectMapper();

    private Keycloak keycloak;

    public KeyCloakService(Keycloak keycloak, SpringTemplateEngine templateEngine) {
        this.keycloak = keycloak;
        this.templateEngine = templateEngine;
    }

    public void saveUser(User user) {}

    @SneakyThrows
    public void createNewRealmForNewTenant(Tenant tenant) {
        log.info("Creating new realm {} for new tenant {}", tenant.getRealm(), tenant.getName());

        Context templateContext = new Context();
        templateContext.setVariables(
                new HashMap<>() {
                    {
                        put("realm_id", tenant.getRealm());
                        put("realm_name", tenant.getRealm());
                    }
                });
        String keycloadRealConfig =
                templateEngine.process("templates/flexwork-realm.json", templateContext);
        RealmRepresentation realmRepresentation =
                om.readValue(keycloadRealConfig, RealmRepresentation.class);

        keycloak.realms().create(realmRepresentation);
    }
}
