package com.tsswebapps.pixproxy.repository;

import com.tsswebapps.pixproxy.entidades.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {
    Optional<Organizacao> findByEmail(String email);
}
