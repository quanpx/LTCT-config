package com.example.demo.module.system_management.service;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;

public interface SystemManagementService {

    AccountRoleDTO getRoleByEmail(String email);

    AccountRoleDTO getRoleByAccountId(String id);

    ThemeDTO getTheme(ThemeRequest themeRequest);
}
