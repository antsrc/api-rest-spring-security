package desarrolloservidor.empresa.seguridad;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserEntity> userOpt = userRepository.findById(username);

		if (userOpt.isPresent()) {
			return new UserDetailsImpl(userOpt.get());
		}

		throw new UsernameNotFoundException("Usuario no encontrado");
	}

}
