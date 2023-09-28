package sistema.essenseg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sistema.essenseg.model.Usuario;
import sistema.essenseg.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Usuario usuario = repository.findByUsuario(username);

       if(usuario == null){
           throw new UsernameNotFoundException("Usuário não encontrado");
       }

        return new CustomUserDetails(usuario);
    }
}
