package com.satc.satcloja.health;

import com.satc.satcloja.enums.FormaPagamento;
import com.satc.satcloja.model.Cliente;
import com.satc.satcloja.model.Produto;
import com.satc.satcloja.model.Servico;
import com.satc.satcloja.model.venda.ItemVenda;
import com.satc.satcloja.model.venda.Venda;
import com.satc.satcloja.repository.ClienteRepository;
import com.satc.satcloja.repository.ProdutoRepository;
import com.satc.satcloja.repository.ServicoRepository;
import com.satc.satcloja.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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

    @GetMapping("/health")
    public String healthCheck() {

        Produto produto = new Produto();

        produto = produtoRepository.findById(1L).orElse(new Produto());

        Servico servico = new Servico();

        servico = servicoRepository.findById(2L).orElse(new Servico());

        Venda venda = new Venda();
        venda.setCliente(clienteRepository.findById(5L).orElse(new Cliente()));
        venda.setDataVenda(LocalDate.now());
        venda.setFormaPagamento(FormaPagamento.A_VISTA);
        venda.setObservacao("Teste venda");

        ItemVenda itemVenda1 = new ItemVenda(produto, 1000.0, 1.0, 10.00);
        ItemVenda itemVenda2 = new ItemVenda(servico, 120.00, 1.0, 10.00);

        venda.addItemVenda(itemVenda1);
        venda.addItemVenda(itemVenda2);

        vendaRepository.save(venda);

        return "Comando executado" + venda.getId();
    }
}
