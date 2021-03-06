package es.crimarde.core.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
 
@PropertySource("classpath:application.properties")
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
 
	
	@Value("${crimarde.dam.security.realm.name}")
    private String REALM;
	
    @Override
    public void commence(final HttpServletRequest request, 
            final HttpServletResponse response, 
            final AuthenticationException authException) throws IOException, ServletException {
        //Authentication failed, send error response.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
         
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status ".concat(HttpStatus.UNAUTHORIZED.toString())
        		.concat(" ")
        		.concat(HttpStatus.UNAUTHORIZED.getReasonPhrase()).concat(" : ")
        		.concat(authException.getMessage()));
    }
     
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(REALM);
        super.afterPropertiesSet();
    }
}
