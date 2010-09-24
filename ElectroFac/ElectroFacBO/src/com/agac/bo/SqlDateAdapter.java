package com.agac.bo;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Carlos Aguirre 13 Feb 2010
 */
public class SqlDateAdapter extends XmlAdapter<String, Date> {

    DateFormat df = DateFormat.getDateTimeInstance();

    @Override
    public Date unmarshal(String v) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(v));
        return new Date(c.getTimeInMillis());
    }

    @Override
    public String marshal(Date v) throws Exception {
        System.out.println(v.toString());
        Calendar fecha = Calendar.getInstance();
        fecha.setTimeInMillis(v.getTime());

        String s = Integer.toString(fecha.get(Calendar.YEAR)) + "-";
        String tmp = Integer.toString(fecha.get(Calendar.MONTH)+1);
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
        s += Integer.toString(fecha.get(Calendar.MILLISECOND)).substring(0, 1);
        return s;
    }
}
