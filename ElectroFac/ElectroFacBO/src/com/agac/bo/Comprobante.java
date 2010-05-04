package com.agac.bo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.agac.libraries.NumberToLetterConverter;
import javax.persistence.Column;

/**
 *
 * @author Carlos Aguirre 12 Feb 2010
 */
@XmlRootElement(name = "Comprobante", namespace = "http://www.sat.gob.mx/cfd/2")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Comprobante implements Serializable {

    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        Long oldId = this.Id;
        this.Id = Id;
        propertyChangeSupport.firePropertyChange("Id", oldId, Id);
    }
    @XmlElement(name = "Emisor", required = true)
    @ManyToOne
    private Emisor emisor;
    @XmlElement(name = "Receptor", required = true)
    @ManyToOne
    private Receptor receptor;
    @XmlElementWrapper(name = "Conceptos")
    @XmlElement(name = "Concepto")
    @OneToMany
    private List<Concepto> conceptos;
    @XmlElement(name = "Impuestos", required = true)
    @Transient
    private Impuesto impuesto;
    @XmlAttribute(required = true)
    private String version = "2.0";
    @XmlAttribute
    private String serie;
    @XmlAttribute(required = true)
    private int folio;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    private Date fecha = new Date(System.currentTimeMillis());
    @XmlAttribute(required = true)
    private String sello;
    @XmlAttribute(required = true)
    private int noAprobacion;
    @XmlAttribute(required = true)
    private int anoAprobacion;
    @XmlAttribute(required = true)
    private String formaDePago;
    @XmlAttribute(required = true)
    private String noCertificado;
    @XmlAttribute
    private String certificado;
    @XmlAttribute
    private String condicionesDePago;
    @XmlAttribute(required = true)
    private BigDecimal subTotal = new BigDecimal(0);
    @XmlAttribute
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private BigDecimal descuento;
    @XmlAttribute
    private String motivoDescuento;
    @XmlAttribute(required = true)
    private BigDecimal total = new BigDecimal(0);
    @XmlAttribute
    private String metodoDePago;
    @XmlAttribute(required = true)
    private String tipoDeComprobante;
    @XmlTransient
    @Column(length=1000)
    private String cantidadConLetra = "";
    @XmlTransient
    @Transient
    private Double IVA;
    @XmlTransient
    @Column(length=10000)
    private String cadenaOriginal;

    public String getCadenaOriginal() {
        return cadenaOriginal;
    }

    public void setCadenaOriginal(String cadenaOriginal) {
        this.cadenaOriginal = cadenaOriginal;
        propertyChangeSupport.firePropertyChange("cadenaOriginal", null, cadenaOriginal);
    }

    public String getCantidadConLetra() {
        return cantidadConLetra;
    }
    public void setCantidadConLetra(BigDecimal cantidad) {
        this.cantidadConLetra = NumberToLetterConverter.convertNumberToLetter(cantidad.toString());         
    }

    public Double getIVA() {
        Double IV = 0.0;
        if (this.getImpuesto() != null) {
            for (int i = 0; i < this.getImpuesto().getRetenciones().size(); i++) {
                if (this.getImpuesto().getRetenciones().get(i).getImpuesto().equals("I.V.A.")) {
                    IV += this.getImpuesto().getRetenciones().get(i).getImporte().doubleValue();
                }
            }
            for (int i = 0; i < this.getImpuesto().getTraslados().size(); i++) {
                if (this.getImpuesto().getTraslados().get(i).getImpuesto().equals("I.V.A.")) {
                    IV += this.getImpuesto().getTraslados().get(i).getImporte().doubleValue();
                }
            }
        }
        return IV;
    }

    public void setIVA(Double IVA) {
        this.IVA = IVA;
    }

    public Impuesto getImpuesto() {
        if (impuesto == null) {
            impuesto = new Impuesto();
        }
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public List<Concepto> getConceptos() {
        if (conceptos == null) {
            conceptos = new ArrayList<Concepto>();
        }
        return conceptos;
    }

    public void setConceptos(List<Concepto> conceptos) {
        List<Concepto> oldConceptos = this.conceptos;
        this.conceptos = conceptos;
        propertyChangeSupport.firePropertyChange("conceptos", oldConceptos, conceptos);
    }

    public Receptor getReceptor() {
        if (receptor == null) {
            receptor = new Receptor();
        }
        return receptor;
    }

    public void setReceptor(Receptor receptor) {
        Receptor oldReceptor = this.receptor;
        this.receptor = receptor;
        propertyChangeSupport.firePropertyChange("receptor", oldReceptor, receptor);
    }

    public Emisor getEmisor() {
        if (emisor == null) {
            emisor = new Emisor();
        }
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        Emisor oldEmisor = this.emisor;
        this.emisor = emisor;
        propertyChangeSupport.firePropertyChange("emisor", oldEmisor, emisor);
    }

    public int getAnoAprobacion() {
        return anoAprobacion;
    }

    public void setAnoAprobacion(int anoAprobacion) {
        this.anoAprobacion = anoAprobacion;
        propertyChangeSupport.firePropertyChange("anoAprobacion", null, anoAprobacion);
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
        propertyChangeSupport.firePropertyChange("certificado", null, certificado);
    }

    public String getCondicionesDePago() {
        return condicionesDePago;
    }

    public void setCondicionesDePago(String condicionesDePago) {
        this.condicionesDePago = condicionesDePago;
        propertyChangeSupport.firePropertyChange("condicionesDePago", null, condicionesDePago);
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
        propertyChangeSupport.firePropertyChange("descuento", null, descuento);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
        propertyChangeSupport.firePropertyChange("fecha", null, fecha);
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
        propertyChangeSupport.firePropertyChange("formaDePago", null, formaDePago);
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
        propertyChangeSupport.firePropertyChange("metodoDePago", null, metodoDePago);
    }

    public String getMotivoDescuento() {
        return motivoDescuento;
    }

    public void setMotivoDescuento(String motivoDescuento) {
        this.motivoDescuento = motivoDescuento;
        propertyChangeSupport.firePropertyChange("motivoDescuento", null, motivoDescuento);
    }

    public int getNoAprobacion() {
        return noAprobacion;
    }

    public void setNoAprobacion(int noAprobacion) {
        this.noAprobacion = noAprobacion;
        propertyChangeSupport.firePropertyChange("noAprobacion", null, noAprobacion);
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
        propertyChangeSupport.firePropertyChange("noCertificado", null, noCertificado);
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
        propertyChangeSupport.firePropertyChange("sello", null, sello);
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
        propertyChangeSupport.firePropertyChange("serie", null, serie);
    }

    public BigDecimal getSubTotal() {        
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
        propertyChangeSupport.firePropertyChange("subTotal", null, subTotal);
    }

    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
        propertyChangeSupport.firePropertyChange("tipoDeComprobante", null, tipoDeComprobante);
    }

    public BigDecimal getTotal() {        
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
        this.setCantidadConLetra(total);
        propertyChangeSupport.firePropertyChange("total", null, total);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
        propertyChangeSupport.firePropertyChange("version", null, version);
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
        propertyChangeSupport.firePropertyChange("folio", null, folio);
    }

    public void addConcepto(Concepto concepto) {
        getConceptos().add(concepto);
        propertyChangeSupport.firePropertyChange("concepto", null, concepto);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
        for (Concepto c : getConceptos()) {
            c.addPropertyChangeListener(listener);
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
        for (Concepto c : getConceptos()) {
            c.removePropertyChangeListener(listener);
        }
    }
    @XmlTransient
    @Transient
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comprobante other = (Comprobante) obj;
        if (this.Id != other.Id && (this.Id == null || !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.Id != null ? this.Id.hashCode() : 0);
        return hash;
    }

    public BigDecimal calcularSubTotal(){
        BigDecimal sub = new BigDecimal("0.0");
        for (Concepto c : getConceptos()) {
            sub = sub.add(c.getImporte());
        }
        return sub;
    }

    public BigDecimal calcularImpuestos(){
        BigDecimal tot = new BigDecimal("0");
        if(impuesto != null){
            for(Traslado t : impuesto.getTraslados()){
                tot = tot.add(t.getImporte());
            }
            for(Retencion r : impuesto.getRetenciones()){
                tot = tot.add(r.getImporte());
            }
        }
        return tot;
    }

    public BigDecimal calcularTotal(){
        return calcularSubTotal().add(calcularImpuestos());
    }
}
