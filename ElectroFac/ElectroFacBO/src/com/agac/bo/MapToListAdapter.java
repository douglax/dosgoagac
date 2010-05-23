

package com.agac.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MapToListAdapter extends XmlAdapter<ArrayList<Traslado>,Map>{

    @Override
    public Map unmarshal(ArrayList<Traslado> v) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Traslado> marshal(Map v) throws Exception {
        Collection c = v.values();
        return null;
    }
}
