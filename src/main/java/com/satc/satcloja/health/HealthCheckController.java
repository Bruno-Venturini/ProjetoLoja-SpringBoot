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

        Produto produto = new Produto("Disponivel 1", "Disp 1");
        Produto produto2 = new Produto("Disponivel 2", "Disp 2");
        Produto produto3 = new Produto("Alugado 1", "Alugado 1");

        produto.setStatus(Status.DISPONIVEL);
        produto.setValorUnitario(1.00);
        produto2.setStatus(Status.DISPONIVEL);
        produto2.setValorUnitario(1.00);
        produto3.setStatus(Status.ALUGADO);
        produto3.setValorUnitario(1.00);

        produtoRepository.save(produto);
        produtoRepository.save(produto2);
        produtoRepository.save(produto3);

        return "Comando executado";
    }

    @GetMapping("/teste-produtos-alugados")
    public String testeProdutosAlugados() {
        List<Produto> produtosAlugados = produtoService.findProdutosAlugados();

        return produtosAlugados.toString();
    }
}
