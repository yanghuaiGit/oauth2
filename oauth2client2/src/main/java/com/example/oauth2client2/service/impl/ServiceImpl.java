package com.example.oauth2client2.service.impl;


import com.example.oauth2client2.model.Content;
import com.example.oauth2client2.model.OAuth2Token;
import com.example.oauth2client2.model.ResultBean;
import com.example.oauth2client2.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author lucky_yh
 * 2019/7/8 20:14
 */

@Service
public class ServiceImpl implements OauthService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResultBean getContents(String accessToken) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + accessToken);
        String endpoint = "http://localhost:8083/api/contents";
        URI uri = UriComponentsBuilder.fromUriString(endpoint).build("");

        try {
            RequestEntity<Void> request = RequestEntity.get(uri)
                    .header("Authorization", "Bearer " + accessToken)
                    .build();

            ParameterizedTypeReference<ResultBean<List<Content>>> ptr =
                    new ParameterizedTypeReference<ResultBean<List<Content>>>() {
                    };
            ResponseEntity<ResultBean<List<Content>>> userInfo = restTemplate.exchange(request, ptr);

            if (userInfo.getStatusCode().is2xxSuccessful()) {
                return userInfo.getBody();
            } else {
                throw new RuntimeException("it was not possible to retrieve user profile");
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            throw new RuntimeException("it was not possible to retrieve user profile");
        }
    }

    @Override
    public OAuth2Token getToken(String authorizationCode) {
        String authBase64 = encodeCredentials("client",
                "secret");

        RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(
                getBody(authorizationCode),
                getHeader(authBase64), HttpMethod.POST,
                URI.create("http://localhost:8082/oauth/token"));

        ResponseEntity<OAuth2Token> responseEntity = restTemplate.exchange(
                requestEntity, OAuth2Token.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }

        throw new RuntimeException("error trying to retrieve access token");
    }

    @Override
    public String getAuthorizationEndpoint(String id) {
        String endpoint = "http://localhost:8082/oauth/authorize";

        Map<String, String> authParameters = new HashMap<>();
        authParameters.put("client_id", "client");
        authParameters.put("response_type", "code");
        authParameters.put("state", id);
        authParameters.put("redirect_uri",
                getEncodedUrl("http://localhost:9001/callback"));
        // authParameters.put("scope", getEncodedUrl("app"));

        return buildUrl(endpoint, authParameters);
    }

    public String encodeCredentials(String username, String password) {
        String credentials = username + ":" + password;
        String encoded = new String(Base64.getEncoder().encode(
                credentials.getBytes()));

        return encoded;
    }

    private String getEncodedUrl(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public MultiValueMap<String, String> getBody(String authorizationCode) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "authorization_code");
//        formData.add("scope", "read_userinfo");
        formData.add("code", authorizationCode);
        formData.add("redirect_uri", "http://localhost:9001/callback");
        return formData;
    }

    public HttpHeaders getHeader(String clientAuthentication) {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Basic " + clientAuthentication);
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");

        return httpHeaders;
    }

    private String buildUrl(String endpoint, Map<String, String> parameters) {
        List<String> paramList = new ArrayList<>(parameters.size());

        parameters.forEach((name, value) -> {
            paramList.add(name + "=" + value);
        });

        return endpoint + "?" + paramList.stream()
                .reduce((a, b) -> a + "&" + b).get();
    }

}
