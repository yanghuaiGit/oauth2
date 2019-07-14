package com.example.server2.controller;

import com.example.server2.model.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lucky_yh
 * 2019/7/9 9:53
 */
@RestController
@RequestMapping("/token")
public class Endpoints {

    private final ClientDetailsService clientDetailsService;

    @Autowired
    public Endpoints(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    /**
     * 确认授权页面
     *
     * @param request
     * @param session
     * @return
     */
    @GetMapping("/confirm_access")
    public ResultBean confirm(HttpServletRequest request, HttpSession session) {
        Map<String, Object> scopeList = (Map<String, Object>) request.getAttribute("scopes");
        ClientDetails clientDetails = null;
        Object auth = session.getAttribute("authorizationRequest");
        if (auth != null) {
            AuthorizationRequest authorizationRequest = (AuthorizationRequest) auth;
            clientDetails = clientDetailsService.loadClientByClientId(authorizationRequest.getClientId());
        }
        if (clientDetails == null) {
            return new ResultBean(1000, "normal", scopeList);
        }
        return new ResultBean(1000, "normal", clientDetails);
    }


}
