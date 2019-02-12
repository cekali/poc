package com.geospiza.poc;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        return ThreadLocalStorage.getTenantName();
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}
