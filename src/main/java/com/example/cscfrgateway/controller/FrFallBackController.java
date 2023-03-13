package com.example.cscfrgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帆软请求集中处理
 */
@RestController
public class FrFallBackController {

    @RequestMapping("/subscriptionServiceFallBack")
    public String userServiceFallBackMethod() {
        return "Fr error." +
                " Please try again later";
    }

}
