/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;



/**
 *
 * @author alex
 */


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="impuesto" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;enumeration value="IVA"/>
             *             &lt;enumeration value="IEPS"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="tasa" use="required" type="{http://www.sat.gob.mx/cfd/2}t_Importe" />
             *       &lt;attribute name="importe" use="required" type="{http://www.sat.gob.mx/cfd/2}t_Importe" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public class Traslado {

                @XmlAttribute(required = true)
                protected String impuesto;
                @XmlAttribute(required = true)
                protected BigDecimal tasa;
                @XmlAttribute(required = true)
                protected BigDecimal importe;

                /**
                 * Gets the value of the impuesto property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getImpuesto() {
                    return impuesto;
                }

                /**
                 * Sets the value of the impuesto property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setImpuesto(String value) {
                    this.impuesto = value;
                }

                /**
                 * Gets the value of the tasa property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getTasa() {
                    return tasa;
                }

                /**
                 * Sets the value of the tasa property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setTasa(BigDecimal value) {
                    this.tasa = value;
                }

                /**
                 * Gets the value of the importe property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getImporte() {
                    return importe;
                }

                /**
                 * Sets the value of the importe property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setImporte(BigDecimal value) {
                    this.importe = value;
                }

            }

