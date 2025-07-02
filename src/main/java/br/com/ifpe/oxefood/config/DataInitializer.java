package br.com.ifpe.oxefood.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.produto.CategoriaProdutoRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initCategorias(CategoriaProdutoRepository categoriaProdutoRepository) {
        return args -> {

            if (categoriaProdutoRepository.count() == 0) {

                categoriaProdutoRepository.save(CategoriaProduto.builder()
                        .chaveEmpresa("ifpe")
                        .descricao("Bebidas")
                        .build());

                categoriaProdutoRepository.save(CategoriaProduto.builder()
                        .chaveEmpresa("ifpe")
                        .descricao("Lanches")
                        .build());

            } else {
                System.out.println("[Init] Categorias já existentes. Nenhum dado adicionado.");
            }
        };
    }
}
