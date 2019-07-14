package com.example.oauth2client2.controller;

import com.example.oauth2client2.model.OAuth2Token;
import com.example.oauth2client2.model.ResultBean;
import com.example.oauth2client2.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author lucky_yh
 * 2019/7/8 20:11
 */

@RestController
public class ClientController {

    @Autowired
    private OauthService oauthService;

    @Autowired
    private RedisTemplate<String, OAuth2Token> redisTemplate;

    @RequestMapping("/client2")
    public void client(HttpServletResponse response, @RequestParam(required = false) String id) throws IOException {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        OAuth2Token token = redisTemplate.opsForValue().get(id);
        if (token == null) {
            //跳转之后 会再跳转到callback
            response.sendRedirect(oauthService.getAuthorizationEndpoint(id));
        }

//        return oauthService.getContents(token.getAccessToken());
    }

    @GetMapping("/callback")
    public ResultBean callback(@RequestParam String code, @RequestParam String state) {

        OAuth2Token token = oauthService.getToken(code);
        //resttemplate请求resource获取资源
        redisTemplate.opsForValue().set(state, token);
        return oauthService.getContents(token.getAccessToken());
    }
}
