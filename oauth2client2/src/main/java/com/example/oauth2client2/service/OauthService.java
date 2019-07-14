package com.example.oauth2client2.service;

import com.example.oauth2client2.model.OAuth2Token;
import com.example.oauth2client2.model.ResultBean;

public interface OauthService {
    ResultBean getContents(String accessToken);

    OAuth2Token getToken(String authorizationCode);

    String getAuthorizationEndpoint(String id);
}
