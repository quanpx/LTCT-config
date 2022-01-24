package com.example.demo.config.theme;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.system_management.service.SystemManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(1)
public class ThemeFilter extends OncePerRequestFilter {

    @Autowired
    private Map<String, SystemManagementService> sysManagementServiceMap;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private ThemeConfig themeConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        SystemManagementService systemManagementService = sysManagementServiceMap
                .get(moduleConfig.getSysManagementTeam());

        ThemeRequest themeRequest = new ThemeRequest();
        themeRequest.setUserId(4);
        ThemeDTO themeDTO = systemManagementService.getTheme(themeRequest);

        themeConfig.setFontSize(themeDTO.getFontSize());
        themeConfig.setLanguage(themeDTO.getLanguage());
        themeConfig.setTheme(themeDTO.getTheme());

        filterChain.doFilter(request, response);

    }

}
