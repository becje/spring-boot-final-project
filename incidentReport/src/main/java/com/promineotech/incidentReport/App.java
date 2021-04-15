package com.promineotech.incidentReport;

//import java.security.Key;
//import java.util.Base64;
//
//import javax.print.attribute.standard.MediaSize.JIS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.crypto.bcrypt.BCrypt;

@ComponentScan("com.promineotech.incidentReport")
@SpringBootApplication
public class App 
{
//	public static void JWTStuff() {
//		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//		String jwt = Jwts.builder()
//						.claim("role", "ADMIN")
//						.setSubject("INCIDENT REPORT")
//						.signWith(key)
//						.compact();
//		
//		System.out.println("Here is a JWT: ");
//		System.out.println( jwt );
//		
//		String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
//		System.out.println("Here is a server key which has been Base64 encoded: ");
//		System.out.println(encodedKey);
//		
//		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
//		System.out.println( Jwts.parser().setSigningKey( decodedKey ).parseClaimsJws( jwt ).getBody().getSubject().equals( "PROMINEO TECH JWT" ) );
//	}
//	public static void userAuthenticationStuff() {
//		String password = "springishere";
//		System.out.println("Hash of the password '" + password + "' using system-generated salt:");
//		String salt = BCrypt.gensalt();
//		
//		String hash = BCrypt.hashpw(password, salt);
//		System.out.println(hash);
//		System.out.println(BCrypt.checkpw(password, hash));
//	}
	
  public static void main( String[] args )
  {
      SpringApplication.run(App.class, args);
  }
}