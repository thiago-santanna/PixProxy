package com.tsswebapps.pixproxy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PixController {

    @GetMapping("${api.prefix}/${api.version}/status")
    public String status() {
        return "OK";
    }
}
