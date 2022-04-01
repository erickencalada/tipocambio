package pe.gob.midis.sisfoh.security.service;

import java.io.IOException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import pe.gob.midis.sisfoh.security.dto.UsuarioSeguridadDto;
import pe.gob.midis.sisfoh.util.Validador;


@Service
public class SisfohComunService {

	private final static Logger logger = LoggerFactory.getLogger(SisfohComunService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	
	 
	public UsuarioSeguridadDto getUsuarioSeguridadDto(String urlS, String usernameS, String contrasenaS, Long idSistemaS) throws Validador {
		 logger.info("-INI- getUsuarioSeguridadDto");
		 logger.info("restTemplate: "+restTemplate);
		 UsuarioSeguridadDto userResponse = null;
		 
		 try {
			 UsuarioSeguridadDto userRequest = new UsuarioSeguridadDto( usernameS,  contrasenaS,  idSistemaS);
			 
			 if(restTemplate == null) {
				 restTemplate = new RestTemplate();
			 }
			 
			 userResponse = restTemplate.postForObject(urlS, userRequest, UsuarioSeguridadDto.class);
			 logger.info(userResponse.toString());	
		}  catch (RestClientException  e) {
			  throw new Validador("El Servicio usuario seguridad midis no esta disponible: "+e.getCause()+"");
		}
		 
		 
	     return  userResponse;
	     
	    }
	 
	 
	 
	 
	    @Bean
		public RestTemplate restTemplate() {
		    return new RestTemplate();
		}
	    
}
























