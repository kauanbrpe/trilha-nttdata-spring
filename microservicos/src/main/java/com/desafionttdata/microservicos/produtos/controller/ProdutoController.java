package com.desafionttdata.microservicos.produtos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafionttdata.microservicos.produtos.model.Produto;
import com.desafionttdata.microservicos.produtos.repository.ProdutoRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Produto> listarTodos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
       Produto existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
       existente.setNome(produto.getNome());
       existente.setPreco(produto.getPreco());
       return repository.save(existente); 
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
