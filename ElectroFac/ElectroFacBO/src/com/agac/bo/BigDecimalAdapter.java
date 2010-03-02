/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.bo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Carlos Aguirre 3 de Marzo 2010
 */
public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal>{

    @Override
    public BigDecimal unmarshal(String v) throws Exception {
        return new BigDecimal(v);
    }

    @Override
    public String marshal(BigDecimal v) throws Exception {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(6);
        df.setMinimumFractionDigits(6);
        df.setGroupingUsed(false);
        return df.format(v.doubleValue());
    }


}
