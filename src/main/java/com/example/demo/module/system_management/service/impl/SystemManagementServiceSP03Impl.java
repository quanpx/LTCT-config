package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.system_management.bean.sp03.SP03ThemeConfigBean;
import com.example.demo.module.system_management.proxies.SystemManagementSP03WebServiceProxy;
import com.example.demo.module.system_management.service.SystemManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Service("sp03-sys-management")
@Slf4j
public class SystemManagementServiceSP03Impl implements SystemManagementService {

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private SystemManagementSP03WebServiceProxy webServiceProxy;

    @Override
    public AccountRoleDTO getRoleByEmail(String email) {
        return null;
    }

    @Override
    public AccountRoleDTO getRoleByAccountId(String id) {
        if (id == null) return AccountRoleDTO.GUEST_ROLE;

        HashMap<String, Object> params = new HashMap<>();
        params.put("id", Integer.parseInt(id));

        try {
            // ResponseEntity<Map<String, Object>> res = this.webServiceProxy.getRole(params);
            // if (res == null || !res.getStatusCode().is2xxSuccessful())
            //     return AccountRoleDTO.GUEST_ROLE;

            // Map<String, Object> data = res.getBody();
            // if (data == null) return AccountRoleDTO.GUEST_ROLE;

            // if ((int) data.get("role") == 1) return AccountRoleDTO.USER_ROLE;
        } catch (Exception ignore) {
            return AccountRoleDTO.GUEST_ROLE;
        }
        return AccountRoleDTO.GUEST_ROLE;
    }

    @Override
    public ThemeDTO getTheme(ThemeRequest themeRequest) {
        try {
            SP03ThemeConfigBean configBean = this.webServiceProxy.getConfig(themeRequest);
            ThemeDTO themeDTO = new ThemeDTO();
            themeDTO.setFontSize(configBean.getFontSize());
            themeDTO.setLanguage(configBean.getLanguage());
            themeDTO.setTheme(configBean.getTheme());
            themeDTO.setUserId(configBean.getUserId());
            return themeDTO;
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return null;
        }

    }
}
