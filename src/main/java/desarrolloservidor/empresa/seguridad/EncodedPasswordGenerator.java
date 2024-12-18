package desarrolloservidor.empresa.seguridad;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodedPasswordGenerator {

	public static void main(String[] args) {

		String hashedPassword = generate();
		if (hashedPassword != null) {
			System.out.println("Contraseña hasheada: " + hashedPassword);
		} else {
			System.out.println("Ocurrió un problema inesperado");
		}

	}

	private static String generate() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = null;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Introduce una contraseña: ");
			password = sc.next();
		} catch (Exception e) {
			return null;
		}

		String hashedPassword = encoder.encode(password);

		return encoder.matches(password, hashedPassword) ? hashedPassword : null;
	}

}
