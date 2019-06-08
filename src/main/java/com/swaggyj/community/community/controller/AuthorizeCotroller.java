package com.swaggyj.community.community.controller;

import com.swaggyj.community.community.dto.AccessTokenDTO;
import com.swaggyj.community.community.dto.GithubUser;
import com.swaggyj.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeCotroller {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("39b225767a8f2f1e4362");
        accessTokenDTO.setClient_secret("b9d862a38236d0d2e21f179fd98b10f0dd984c6e");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url("http://localhost:8888/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
