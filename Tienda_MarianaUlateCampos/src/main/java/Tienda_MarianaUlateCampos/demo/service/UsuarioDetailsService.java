package Tienda_MarianaUlateCampos.demo.service;

import org.springframework.security.core.userdetails.*;

public interface UsuarioDetailsService {
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException;
}
