package com.satc.satcloja.health;

import com.satc.satcloja.enums.Status;
import com.satc.satcloja.model.Produto;
import com.satc.satcloja.repository.ClienteRepository;
import com.satc.satcloja.repository.ProdutoRepository;
import com.satc.satcloja.repository.ServicoRepository;
import com.satc.satcloja.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.satc.satcloja.services.ProdutoService;

import java.util.List;

@RestController
public class HealthCheckController {

    @Autowired
    public ProdutoRepository produtoRepository;

    @Autowired
    public ServicoRepository servicoRepository;

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/health")
    public String healthCheck() {
        return "OK!";
    }
}
