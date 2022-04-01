package pe.gob.midis.sisfoh.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pe.gob.midis.sisfoh.model.dto.Response;
import pe.gob.midis.sisfoh.model.dto.ResponseDto;
import pe.gob.midis.sisfoh.model.dto.TipoCambioDto;
import pe.gob.midis.sisfoh.services.interfaces.TipoCambioServices;
import pe.gob.midis.sisfoh.util.Validador;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin(origins = "${client.url}")
@Api("APIS de Modulo usuario")
public class TipoCambioController {

	private static final Logger logger = LoggerFactory.getLogger(TipoCambioController.class);

	@Autowired
	private TipoCambioServices tipoCambioServices;

	@GetMapping(path = "/getById/{id}")
	public Mono<TipoCambioDto> getById(@PathVariable int id){
		logger.info("-INI- getById");
		try {
			return tipoCambioServices.getById(new BigDecimal(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Mono.error(e);
		}
	}

	@GetMapping(path = "/getList")
	public Flux<List<TipoCambioDto>> getList(){
		logger.info("-INI- getList");
		try {
			return tipoCambioServices.getList();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Flux.error(e);
		}
	}

	@PostMapping(path = "/post")
	public Mono<Response> post(@RequestBody TipoCambioDto tipoCambioDto){
		logger.info("-INI- post");
		try {
			return tipoCambioServices.post(tipoCambioDto);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Mono.error(e);
		}
	}

	@PostMapping(path = "/put")
	public Mono<Response> put(@RequestBody TipoCambioDto tipoCambioDto){
		logger.info("-INI- put");
		try {
			return tipoCambioServices.put(tipoCambioDto);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Mono.error(e);
		}
	}

	@PostMapping(path = "/delete")
	public Mono<Response> delete(@PathVariable int id){
		logger.info("-INI- delete");
		try {
			return tipoCambioServices.delete(new BigDecimal(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Mono.error(e);
		}
	}

}



