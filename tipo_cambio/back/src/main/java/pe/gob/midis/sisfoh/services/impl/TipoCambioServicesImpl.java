package pe.gob.midis.sisfoh.services.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import pe.gob.midis.sisfoh.model.dto.Response;
import pe.gob.midis.sisfoh.model.dto.TipoCambioDto;
import pe.gob.midis.sisfoh.model.entity.TipoCambio;
import pe.gob.midis.sisfoh.repository.TipoCambioRepository;
import pe.gob.midis.sisfoh.security.dto.UsuarioSeguridadDto;
import pe.gob.midis.sisfoh.security.service.SisfohComunService;
import pe.gob.midis.sisfoh.services.interfaces.TipoCambioServices;
import pe.gob.midis.sisfoh.util.FuncionesStaticas;
import pe.gob.midis.sisfoh.util.Validador;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoCambioServicesImpl implements TipoCambioServices {

	private static final Logger log = LogManager.getLogger(TipoCambioServicesImpl.class);
	@Autowired
	private TipoCambioRepository tipoCambioRepository;

	
    public static String urlUsuarioSeguridad;
    
    @Value("${midis.ws.usuario.seguridad}")
    public void setUrlUsuarioSeguridad(String urlUsuarioSeguridad) {
       this.urlUsuarioSeguridad= urlUsuarioSeguridad;
    }
	
    @Autowired
    private SisfohComunService sisfohComunServiceRest;
    
	@Override
	public Mono<TipoCambioDto> getById(BigDecimal id) {
		log.debug("-INI- getById()");
		TipoCambioDto objDto = new TipoCambioDto();
		TipoCambio obj = tipoCambioRepository.getById(id);

		if(obj == null)
			return Mono.empty();

		FuncionesStaticas.copyPropertiesObject(objDto, obj);

		return Mono.just(objDto);
	}

	@Override
	public Flux<List<TipoCambioDto>> getList() {
		log.debug("-INI- getList()");
		List<TipoCambioDto> listDto = new ArrayList<>();
		TipoCambioDto objDto = new TipoCambioDto();
		List<TipoCambio> list = tipoCambioRepository.findAll();

		if(list == null || list.size() == 0)
			return Flux.empty();

		for(TipoCambio TipoCambio : list) {
			objDto = new TipoCambioDto();
			FuncionesStaticas.copyPropertiesObject(objDto, TipoCambio);
			listDto.add(objDto);
		}

		return Flux.just(listDto);
	}
	
	@Override
	public Mono<Response> post(TipoCambioDto tipoCambioDto) {
		log.debug("-INI- post()");
		Response resp = new Response();
		TipoCambio tipoCambio = new TipoCambio();
		BeanUtils.copyProperties(tipoCambioDto, tipoCambio);

		try {
			TipoCambio save = tipoCambioRepository.save(tipoCambio);
			resp.setExito(true);
			resp.setCode("1");
			resp.setDescription("");
		} catch (Exception e) {
			resp.setExito(false);
			resp.setCode("-1");
			resp.setDescription(e.getMessage());
		}
		return Mono.just(resp);
	}

	@Override
	public Mono<Response> put(TipoCambioDto tipoCambioDto) {
		log.debug("-INI- put()");
		Response resp = new Response();
		TipoCambio tipoCambio = new TipoCambio();
		BeanUtils.copyProperties(tipoCambioDto, tipoCambio);

		try {
			TipoCambio save = tipoCambioRepository.save(tipoCambio);
			resp.setExito(true);
			resp.setCode("1");
			resp.setDescription("");
		} catch (Exception e) {
			resp.setExito(false);
			resp.setCode("-1");
			resp.setDescription(e.getMessage());
		}
		return Mono.just(resp);
	}

	@Override
	public Mono<Response> delete(BigDecimal id) {
		Response resp = new Response();
		
		try {
			tipoCambioRepository.deleteById(id);
			resp.setExito(true);
			resp.setCode("1");
			resp.setDescription("");
		} catch (Exception e) {
			resp.setExito(false);
			resp.setCode("-1");
			resp.setDescription(e.getMessage());
		}
		return Mono.just(resp);
	}

}
