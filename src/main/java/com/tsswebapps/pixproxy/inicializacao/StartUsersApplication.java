package com.tsswebapps.pixproxy.inicializacao;

import com.tsswebapps.pixproxy.entidades.Organizacao;
import com.tsswebapps.pixproxy.repository.OrganizacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartUsersApplication implements CommandLineRunner {
    private final OrganizacaoRepository repository;

    public StartUsersApplication(OrganizacaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Organizacao tssWebApps = Organizacao.builder()
                .nome("TSS Web Apps")
                .cnpjCpf("123456789")
                .email("tss.webapps@gmail.com")
                .password("123456")
                .telefone("11999999999")
                .build();
        System.out.println(tssWebApps);
        this.repository.save(tssWebApps);
    }
}
