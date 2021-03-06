package com.agac.anexo20;

import com.agac.bo.Comprobante;
import com.agac.bo.Concepto;
import com.agac.bo.InformacionAduanera;
import com.agac.bo.Retencion;
import com.agac.bo.Traslado;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Carlos Aguirre
 */
public class CadenaOriginal {

    /**Esta clase la utilizamos para generar la cadena original en base al anexo 20, esta cadena nos 
    servira posteriormente para generar el sello digital
     */
    private String cadena;

    public CadenaOriginal(Comprobante c) {
        super();
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        //Comprobante
        sb.append("|").append(c.getVersion().trim());
        sb.append("|").append(c.getSerie().trim());
        sb.append("|").append(Integer.toString(c.getFolio()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(c.getFecha());
        sb.append("|").append(formatFecha(calendar));
        sb.append("|").append(c.getNoAprobacion());
        sb.append("|").append(Integer.toString(c.getAnoAprobacion()));
        sb.append("|").append(c.getTipoDeComprobante().trim());
        sb.append("|").append(c.getFormaDePago().trim());
        if (c.getCondicionesDePago() != null && c.getCondicionesDePago().trim().length() > 0) {
            sb.append("|").append(c.getCondicionesDePago().trim());
        }
        sb.append("|").append(formatBigDecimal(c.getSubTotal()));
        if (c.getDescuento() != null) {
            sb.append("|").append(formatBigDecimal(c.getDescuento()));
        }
        sb.append("|").append(formatBigDecimal(c.getTotal()));
        //Emisor
        sb.append("|").append(c.getEmisor().getRfc().trim());
        sb.append("|").append(c.getEmisor().getNombre().trim());
        //Domicilio Fiscal
        sb.append("|").append(c.getEmisor().getDomicilioFiscal().getCalle().trim());
        if (c.getEmisor().getDomicilioFiscal().getNoExterior() != null
                && c.getEmisor().getDomicilioFiscal().getNoExterior().trim().length() > 0) {
            sb.append("|").append(c.getEmisor().getDomicilioFiscal().getNoExterior().trim());
        }
        if (c.getEmisor().getDomicilioFiscal().getNoInterior() != null
                && c.getEmisor().getDomicilioFiscal().getNoInterior().trim().length() > 0) {
            sb.append(c.getEmisor().getDomicilioFiscal().getNoInterior().trim());
        }
        if (c.getEmisor().getDomicilioFiscal().getColonia() != null
                && c.getEmisor().getDomicilioFiscal().getColonia().trim().length() > 0) {
            sb.append("|" + c.getEmisor().getDomicilioFiscal().getColonia().trim());
        }
        if (c.getEmisor().getDomicilioFiscal().getLocalidad() != null
                && c.getEmisor().getDomicilioFiscal().getLocalidad().trim().length() > 0) {
            sb.append("|").append(c.getEmisor().getDomicilioFiscal().getLocalidad().trim());
        }
        if (c.getEmisor().getDomicilioFiscal().getReferencia() != null
                && c.getEmisor().getDomicilioFiscal().getReferencia().trim().length() > 0) {
            sb.append("|").append(c.getEmisor().getDomicilioFiscal().getReferencia().trim());
        }
        sb.append("|").append( c.getEmisor().getDomicilioFiscal().getMunicipio().trim());
        sb.append("|").append(c.getEmisor().getDomicilioFiscal().getEstado().trim());
        sb.append("|").append(c.getEmisor().getDomicilioFiscal().getPais().trim());
        sb.append("|").append(c.getEmisor().getDomicilioFiscal().getCodigoPostal().trim());
        //Expedido en
        if (c.getEmisor().getExpedidoEn() != null) {
            if (c.getEmisor().getExpedidoEn().getCalle() != null
                    && c.getEmisor().getExpedidoEn().getCalle().trim().length() > 0) {
                sb.append("|").append(c.getEmisor().getExpedidoEn().getCalle().trim());
            }
            if (c.getEmisor().getExpedidoEn().getNoExterior() != null
                    && c.getEmisor().getExpedidoEn().getNoExterior().trim().length() > 0) {
                sb.append("|").append(c.getEmisor().getExpedidoEn().getNoExterior().trim());
            }
            if (c.getEmisor().getExpedidoEn().getNoInterior() != null
                    && c.getEmisor().getExpedidoEn().getNoInterior().trim().length() > 0) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getNoInterior().trim());
            }
            if (c.getEmisor().getExpedidoEn().getColonia() != null
                    && c.getEmisor().getExpedidoEn().getColonia().trim().length() > 0) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getColonia().trim());
            }
            if (c.getEmisor().getExpedidoEn().getLocalidad() != null
                    && c.getEmisor().getExpedidoEn().getLocalidad().trim().length() > 0) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getLocalidad().trim());
            }
            if (c.getEmisor().getExpedidoEn().getReferencia() != null
                    && c.getEmisor().getExpedidoEn().getReferencia().trim().length() > 0) {
                sb.append("|").append(c.getEmisor().getExpedidoEn().getReferencia().trim());
            }
            if (c.getEmisor().getExpedidoEn().getMunicipio() != null
                    && c.getEmisor().getExpedidoEn().getMunicipio().trim().length() > 0) {
                sb.append("|").append(c.getEmisor().getExpedidoEn().getMunicipio().trim());
            }
            if (c.getEmisor().getExpedidoEn().getEstado() != null
                    && c.getEmisor().getExpedidoEn().getEstado().trim().length() > 0) {
                sb.append("|").append(c.getEmisor().getExpedidoEn().getEstado().trim());
            }
            if (c.getEmisor().getExpedidoEn().getPais() != null
                    && c.getEmisor().getExpedidoEn().getPais().trim().length() > 0) {
                sb.append("|").append(c.getEmisor().getExpedidoEn().getPais().trim());
            }
            if (c.getEmisor().getExpedidoEn().getCodigoPostal() != null
                    && c.getEmisor().getExpedidoEn().getCodigoPostal().trim().length() > 0) {
                sb.append("|").append(c.getEmisor().getExpedidoEn().getCodigoPostal().trim());
            }
        }
        //Receptor
        sb.append("|").append(c.getReceptor().getRfc().trim());
        sb.append("|").append(c.getReceptor().getNombre().trim());
        //Domicilio
        sb.append("|").append(c.getReceptor().getDomicilio().getCalle().trim());
        if (c.getReceptor().getDomicilio().getNoExterior() != null
                && c.getReceptor().getDomicilio().getNoExterior().trim().length() > 0) {
            sb.append("|").append( c.getReceptor().getDomicilio().getNoExterior().trim());
        }
        if (c.getReceptor().getDomicilio().getNoInterior() != null
                && c.getReceptor().getDomicilio().getNoInterior().trim().length() > 0) {
            sb.append("|").append(c.getReceptor().getDomicilio().getNoInterior().trim());
        }
        if (c.getReceptor().getDomicilio().getColonia() != null
                && c.getReceptor().getDomicilio().getColonia().trim().length() > 0) {
            sb.append("|").append(c.getReceptor().getDomicilio().getColonia().trim());
        }
        if (c.getReceptor().getDomicilio().getLocalidad() != null
                && c.getReceptor().getDomicilio().getLocalidad().trim().length() > 0) {
            sb.append("|").append(c.getReceptor().getDomicilio().getLocalidad().trim());
        }
        if (c.getReceptor().getDomicilio().getReferencia() != null
                && c.getReceptor().getDomicilio().getReferencia().trim().length() > 0) {
            sb.append("|").append(c.getReceptor().getDomicilio().getReferencia().trim());
        }
        if (c.getReceptor().getDomicilio().getMunicipio() != null
                && c.getReceptor().getDomicilio().getMunicipio().trim().length() > 0) {
            sb.append("|").append(c.getReceptor().getDomicilio().getMunicipio().trim());
        }
        if (c.getReceptor().getDomicilio().getEstado() != null
                && c.getReceptor().getDomicilio().getEstado().trim().length() > 0) {
            sb.append("|").append(c.getReceptor().getDomicilio().getEstado().trim());
        }
        sb.append("|").append(c.getReceptor().getDomicilio().getPais().trim());
        if (c.getReceptor().getDomicilio().getCodigoPostal() != null
                && c.getReceptor().getDomicilio().getCodigoPostal().trim().length() > 0) {
            sb.append("|").append(c.getReceptor().getDomicilio().getCodigoPostal().trim());
        }
        //Conceptos
        List l = c.getConceptos();
        Iterator i = l.iterator();
        Concepto concepto = null;
        while (i.hasNext()) {
            concepto = (Concepto) i.next();
            sb.append("|").append(concepto.getCantidad());
            if (concepto.getUnidad().trim() != null) {
                sb.append("|").append(concepto.getUnidad().trim());
            }
            if (concepto.getNoIdentificacion() != null) {
                sb.append("|").append(concepto.getNoIdentificacion().trim());
            }
            sb.append("|").append(concepto.getDescripcion().trim());
            sb.append("|").append(formatBigDecimal(concepto.getValorUnitario()));
            sb.append("|").append(formatBigDecimal(concepto.getImporte()));
            if (concepto.getInfoAduanera() != null) {
                for (InformacionAduanera info : concepto.getInfoAduanera()) {
                    sb.append("|").append(info.getNumero().trim());
                    calendar.setTime(info.getFecha());
                    sb.append("|").append(formatFecha(calendar));
                    sb.append("|").append(info.getAduana().trim());
                }
            }
            if (concepto.getCuentaPredial() != null) {
                sb.append("|").append(concepto.getCuentaPredial().getNumero().trim());
            }
        }
        if (c.getImpuesto().getRetenciones() != null) {
            Map<String, Retencion> rets = c.getImpuesto().getRetenciones();
            for (Retencion ret : rets.values()) {
                if (!ret.getImporte().equals(new BigDecimal("0.0"))) {
                    sb.append("|").append(ret.getImpuesto());
                    sb.append("|").append(formatBigDecimal(ret.getImporte()));
                }
            }
        }
        if (c.getImpuesto().getTraslados() != null) {
            Map<String, Traslado> traslados = c.getImpuesto().getTraslados();
            for (Traslado traslado : traslados.values()) {
                if (!traslado.getImporte().equals(new BigDecimal("0.0"))) {
                    sb.append("|").append(traslado.getImpuesto());
                    sb.append("|").append(formatBigDecimal(traslado.getImporte()));
                }
            }
        }
        cadena = sb.toString() + "||";
    }

    private String formatFecha(Calendar fecha) {
        String s = Integer.toString(fecha.get(Calendar.YEAR)) + "-";
        String tmp = Integer.toString(fecha.get(Calendar.MONTH) + 1);
        if (tmp.length() == 1) {
            tmp = "0" + tmp;
        }
        s += tmp + "-";
        tmp = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        if (tmp.length() == 1) {
            tmp = "0" + tmp;
        }
        s += tmp + "T";
        tmp = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
        if (tmp.length() == 1) {
            tmp = "0" + tmp;
        }
        s += tmp + ":";
        tmp = Integer.toString(fecha.get(Calendar.MINUTE));
        if (tmp.length() == 1) {
            tmp = "0" + tmp;
        }
        s += tmp + ":";
        tmp = Integer.toString(fecha.get(Calendar.SECOND));
        if (tmp.length() == 1) {
            tmp = "0" + tmp;
        }
        s += tmp + ".";
        s += Integer.toString(fecha.get(Calendar.MILLISECOND)).substring(0, 1);
        return s;
    }

    private String formatBigDecimal(BigDecimal numero) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(6);
        df.setMinimumFractionDigits(6);
        df.setGroupingUsed(false);
        return df.format(numero.doubleValue());
    }

    @Override
    public String toString() {
        return cadena.trim();
    }
}
