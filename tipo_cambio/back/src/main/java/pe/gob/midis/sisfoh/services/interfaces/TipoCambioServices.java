package pe.gob.midis.sisfoh.services.interfaces;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.midis.sisfoh.model.dto.Response;
import pe.gob.midis.sisfoh.model.dto.TipoCambioDto;
import pe.gob.midis.sisfoh.util.Validador;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoCambioServices {

	Mono<TipoCambioDto> getById(BigDecimal id);

	Flux<List<TipoCambioDto>> getList();

	Mono<Response> post(TipoCambioDto tipoCambioDto);

	Mono<Response> put(TipoCambioDto tipoCambioDto);

	Mono<Response> delete(BigDecimal id);

}
