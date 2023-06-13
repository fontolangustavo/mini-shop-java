package br.com.iteris.itc.minishop.controller;

import br.com.iteris.itc.minishop.service.MiniShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MiniShopController {

    private final MiniShopService service;

    @GetMapping("/")
    public ResponseEntity<String> foo(){
        return  ResponseEntity.ok(service.foo());
    }
}
