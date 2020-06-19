package com.am.telegram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(value="/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("it works", HttpStatus.OK);
    }

}
