package desarrolloservidor.empresa.seguridad;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private UserEntity user;
	private Collection<GrantedAuthority> authorities;

	public UserDetailsImpl(UserEntity user) {
		this.user = user;
		authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("READ"));
		if ("ADMIN".equals(user.getRole())) {
			authorities.add(new SimpleGrantedAuthority("WRITE"));
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	public String getRole() {
		return user.getRole();
	}

}
