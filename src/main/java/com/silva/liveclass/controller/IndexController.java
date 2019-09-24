package com.silva.liveclass.controller;

import com.silva.liveclass.service.EncryptionDemo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    public String index(){
        return "forward:/index.html";
    }
}
