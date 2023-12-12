/*
package com.tsswebapps.pixproxy.service;

import com.tsswebapps.pixproxy.entidades.Organizacao;
import com.tsswebapps.pixproxy.repository.OrganizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

  private final OrganizacaoRepository organizacaoRepository;
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Organizacao organizacao = organizacaoRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

    Set<GrantedAuthority> authorities = new HashSet<>();
    organizacao.getRoles().forEach(role -> {
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
    });

    return User.withUsername(organizacao.getEmail())
        .password(organizacao.getPassword())
        .authorities(authorities)
        .accountExpired(false)
        .accountLocked(false)
        .credentialsExpired(false)
        .disabled(organizacao.getDisabled())
        .build();
  }
}
*/
