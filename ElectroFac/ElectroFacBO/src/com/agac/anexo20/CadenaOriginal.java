
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
        StringBuffer sb = new StringBuffer();
        sb.append("|");
        //Comprobante
        sb.append("|").append(c.getVersion());
        sb.append("|").append(c.getSerie());
        sb.append("|").append(c.getFolio());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(c.getFecha());
        sb.append("|" + formatFecha(calendar));
        sb.append("|" + c.getNoAprobacion());
        if (c.getFormaDePago() != null) {
            sb.append("|" + c.getFormaDePago());
        }
        //Emisor
        sb.append("|" + c.getEmisor().getRfc());
        sb.append("|" + c.getEmisor().getNombre());
        //Domicilio Fiscal
        sb.append("|" + c.getEmisor().getDomicilioFiscal().getCalle());
        if (c.getEmisor().getDomicilioFiscal().getNoExterior() != null) {
            sb.append("|" + c.getEmisor().getDomicilioFiscal().getNoExterior());
        }
        if (c.getEmisor().getDomicilioFiscal().getNoInterior() != null) {
            sb.append(c.getEmisor().getDomicilioFiscal().getNoInterior());
        }
        if (c.getEmisor().getDomicilioFiscal().getColonia() != null) {
            sb.append("|" + c.getEmisor().getDomicilioFiscal().getColonia());
        }
        if (c.getEmisor().getDomicilioFiscal().getLocalidad() != null) {
            sb.append("|" + c.getEmisor().getDomicilioFiscal().getLocalidad());
        }
        if (c.getEmisor().getDomicilioFiscal().getReferencia() != null) {
            sb.append("|" + c.getEmisor().getDomicilioFiscal().getReferencia());
        }
        sb.append("|" + c.getEmisor().getDomicilioFiscal().getMunicipio());
        sb.append("|" + c.getEmisor().getDomicilioFiscal().getEstado());
        sb.append("|" + c.getEmisor().getDomicilioFiscal().getPais());
        sb.append("|" + c.getEmisor().getDomicilioFiscal().getCodigoPostal());
        //Expedido en
        if (c.getEmisor().getExpedidoEn() != null) {
            if (c.getEmisor().getExpedidoEn().getCalle() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getCalle());
            }
            if (c.getEmisor().getExpedidoEn().getNoExterior() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getNoExterior());
            }
            if (c.getEmisor().getExpedidoEn().getNoInterior() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getNoInterior());
            }
            if (c.getEmisor().getExpedidoEn().getColonia() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getColonia());
            }
            if (c.getEmisor().getExpedidoEn().getLocalidad() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getLocalidad());
            }
            if (c.getEmisor().getExpedidoEn().getReferencia() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getReferencia());
            }
            if (c.getEmisor().getExpedidoEn().getMunicipio() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getMunicipio());
            }
            if (c.getEmisor().getExpedidoEn().getEstado() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getEstado());
            }
            if (c.getEmisor().getExpedidoEn().getPais() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getPais());
            }
            if (c.getEmisor().getExpedidoEn().getCodigoPostal() != null) {
                sb.append("|" + c.getEmisor().getExpedidoEn().getCodigoPostal());
            }
        }
        //Receptor
        sb.append("|" + c.getReceptor().getRfc());
        sb.append("|" + c.getReceptor().getNombre());
        //Domicilio
        sb.append("|" + c.getReceptor().getDomicilio().getCalle());
        if (c.getReceptor().getDomicilio().getNoExterior() != null) {
            sb.append("|" + c.getReceptor().getDomicilio().getNoExterior());
        }
        if (c.getReceptor().getDomicilio().getNoInterior() != null) {
            sb.append("|" + c.getReceptor().getDomicilio().getNoInterior());
        }
        if (c.getReceptor().getDomicilio().getColonia() != null) {
            sb.append("|" + c.getReceptor().getDomicilio().getColonia());
        }
        if (c.getReceptor().getDomicilio().getLocalidad() != null) {
            sb.append("|" + c.getReceptor().getDomicilio().getLocalidad());
        }
        if (c.getReceptor().getDomicilio().getReferencia() != null) {
            sb.append("|" + c.getReceptor().getDomicilio().getReferencia());
        }
        if (c.getReceptor().getDomicilio().getMunicipio() != null) {
            sb.append("|" + c.getReceptor().getDomicilio().getMunicipio());
        }
        if (c.getReceptor().getDomicilio().getEstado() != null) {
            sb.append("|" + c.getReceptor().getDomicilio().getEstado());
        }
        sb.append("|" + c.getReceptor().getDomicilio().getPais());
        if (c.getReceptor().getDomicilio().getCodigoPostal() != null) {
            sb.append("|" + c.getReceptor().getDomicilio().getCodigoPostal());
        }
        //Conceptos
        List l = c.getConceptos();
        Iterator i = l.iterator();
        Concepto concepto = null;
        while (i.hasNext()) {
            concepto = (Concepto) i.next();
            sb.append("|" + concepto.getCantidad());
            if (concepto.getUnidad() != null) {
                sb.append("|" + concepto.getUnidad());
            }
            sb.append("|" + concepto.getDescripcion());
            sb.append("|" + formatBigDecimal(concepto.getValorUnitario()));
            sb.append("|" + formatBigDecimal(concepto.getImporte()));
            if (concepto.getInfoAduanera() != null) {
                for (InformacionAduanera info : concepto.getInfoAduanera()) {
                    sb.append("|" + info.getNumero());
                    calendar.setTime(info.getFecha());
                    sb.append("|" + formatFecha(calendar));
                    sb.append("|" + info.getAduana());
                }
            }
            if (concepto.getCuentaPredial() != null) {
                sb.append("|" + concepto.getCuentaPredial().getNumero());
            }
        }
        if (c.getImpuesto().getRetenciones() != null) {
            List<Retencion> rets = c.getImpuesto().getRetenciones();
            for(Retencion ret : rets){
                sb.append("|" + ret.getImpuesto());
                sb.append("|" + formatBigDecimal(ret.getImporte()));
            }
        }
        if (c.getImpuesto().getTraslados() != null) {
            List<Traslado> traslados = c.getImpuesto().getTraslados();
            for(Traslado traslado : traslados){
                sb.append("|" + traslado.getImpuesto());
                sb.append("|" + formatBigDecimal(traslado.getImporte()));
            }
        }
        cadena = sb.toString() + "||";
    }

    private String formatFecha(Calendar fecha) {
        String s = Integer.toString(fecha.get(Calendar.YEAR)) + "-";
        String tmp = Integer.toString((Calendar.MONTH + 1));
        if (tmp.length() == 1) {
            tmp = "0" + tmp;
        }
        s += tmp + "-";
        s += Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) + "T";
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
        s += Integer.toString(fecha.get(Calendar.MILLISECOND));
        return s;
    }

    private String formatBigDecimal(BigDecimal numero){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(6);
        df.setMinimumFractionDigits(6);
        df.setGroupingUsed(false);
        return df.format(numero.doubleValue());
    }

    @Override
    public String toString() {
        return cadena;
    }
}
