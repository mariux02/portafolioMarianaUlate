package Tienda_MarianaUlateCampos.demo.service.impl;


import Tienda_MarianaUlateCampos.demo.service.UsuarioDetailsService;
import Tienda_MarianaUlateCampos.demo.dao.UsuarioDao;
import Tienda_MarianaUlateCampos.demo.domain.Usuario;
import Tienda_MarianaUlateCampos.demo.domain.Rol;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //busca al usuario por el username en la tabla 
        Usuario usuario = usuarioDao.findByUsername(username);
        //si no está lanza una excepción
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }//final if
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        //Si está aqui es porq existe el usuario... sacamos los roles de este
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol: usuario.getRoles()) { //se sacan los roles
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }//Final for
        //se devuelve User (clase de userDetails)
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }//final del metodo loadUserByUsername
}