package com.example.oauth2client1.controller;

import com.example.oauth2client1.dto.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author lucky_yh
 * 2019/7/8 9:19
 */


@RestController
public class ClientController {

    @RequestMapping("/client1")
    public ResultBean client1() {
        return new ResultBean(1000, "normal", Collections.singletonList("ceshi"));
    }
}
