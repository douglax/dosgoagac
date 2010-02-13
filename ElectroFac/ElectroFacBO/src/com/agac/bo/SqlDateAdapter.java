package com.agac.bo;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Carlos Aguirre 13 Feb 2010
 */
public class SqlDateAdapter extends XmlAdapter<String, Date>{

    DateFormat df = DateFormat.getDateTimeInstance();
    @Override
    public Date unmarshal(String v) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(v));
        return new Date(c.getTimeInMillis());
    }

    @Override
    public String marshal(Date v) throws Exception {
        return df.format(v);
    }

}
