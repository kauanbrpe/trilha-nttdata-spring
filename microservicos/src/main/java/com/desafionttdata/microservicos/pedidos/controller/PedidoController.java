package com.desafionttdata.microservicos.pedidos.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.desafionttdata.microservicos.pedidos.model.Produto;

@RestController
public class PedidoController {
   
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/api/pedidos/produtos")
    public List<Produto> listarProdutos(){
        String url = "http://localhost:8080/api/produtos";
        Produto[] produtos = restTemplate.getForObject(url, Produto[].class);
        return Arrays.asList(produtos);
    }
}
