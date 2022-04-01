// Generated with g9.

package pe.gob.midis.sisfoh.model.dto;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class TipoCambioDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4703286444019590385L;

	/** Primary key. */
    protected static final String PK = "idTipoCambio";

    @Column(name="IDTIPOCAMBIO", precision=38)
    private BigDecimal idTipoCambio;
    @Column(name="MONTO", precision=38)
    private BigDecimal monto;
    @Column(name="MONTOTIPO", precision=38)
    private BigDecimal montoTipo;
    @Column(name="MONEDAORIGEN", precision=38)
    private BigDecimal monedaOrigen;
    @Column(name="MONEDADESTINO", precision=38)
    private BigDecimal monedaDestino;
    @Column(name="TIPOCAMBIO", precision=38)
    private BigDecimal tipoCambio;

    public TipoCambioDto() {
    }

    public TipoCambioDto(BigDecimal idTipoCambio, BigDecimal monto, BigDecimal montoTipo, BigDecimal monedaOrigen, BigDecimal monedaDestino, BigDecimal tipoCambio) {
        this.idTipoCambio = idTipoCambio;
        this.monto = monto;
        this.montoTipo = montoTipo;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoCambio = tipoCambio;
    }

    public BigDecimal getIdTipoCambio() {
        return idTipoCambio;
    }

    public void setIdTipoCambio(BigDecimal idTipoCambio) {
        this.idTipoCambio = idTipoCambio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoTipo() {
        return montoTipo;
    }

    public void setMontoTipo(BigDecimal montoTipo) {
        this.montoTipo = montoTipo;
    }

    public BigDecimal getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(BigDecimal monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public BigDecimal getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(BigDecimal monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCambioDto that = (TipoCambioDto) o;
        return idTipoCambio.equals(that.idTipoCambio) && monto.equals(that.monto) && montoTipo.equals(that.montoTipo) && monedaOrigen.equals(that.monedaOrigen) && monedaDestino.equals(that.monedaDestino) && tipoCambio.equals(that.tipoCambio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoCambio, monto, montoTipo, monedaOrigen, monedaDestino, tipoCambio);
    }

    @Override
    public String toString() {
        return "TipoCambioDto{" +
                "idTipoCambio=" + idTipoCambio +
                ", monto=" + monto +
                ", montoTipo=" + montoTipo +
                ", monedaOrigen=" + monedaOrigen +
                ", monedaDestino=" + monedaDestino +
                ", tipoCambio=" + tipoCambio +
                '}';
    }
}
