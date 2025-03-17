package org.example.configmapping.mapping.core;

import org.springframework.stereotype.Service;

@Service
public class BankConfigurationService {
    public String getCurrentBankId() {
        return "defaultBank";
    }
}
