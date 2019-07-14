package com.example.oahth2resourse.controller;

import com.example.oahth2resourse.model.dto.ResultBean;
import com.example.oahth2resourse.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucky_yh
 * 2019/7/3 21:42
 */


@RestController
@RequestMapping("/api")
public class ResourceController {

    private final ContentService contentService;


    @Autowired
    public ResourceController(ContentService contentService) {
        this.contentService = contentService;
    }


    @GetMapping("/contents")
    public ResultBean content() {
        return new ResultBean(Integer.valueOf(HttpStatus.OK.value()), "up", contentService.queryListContent());
    }
}
