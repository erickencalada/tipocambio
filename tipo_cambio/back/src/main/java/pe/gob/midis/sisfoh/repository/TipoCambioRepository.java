package pe.gob.midis.sisfoh.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.midis.sisfoh.model.entity.TipoCambio;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, BigDecimal> {

}
