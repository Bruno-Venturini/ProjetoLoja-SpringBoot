package com.satc.satcloja.repository;

import com.satc.satcloja.interfaces.CustomQuerydslPredicateExecutor;
import com.satc.satcloja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, CustomQuerydslPredicateExecutor<Produto> {

}
