package com.iagl.newvlille.asyncTask;

import java.io.IOException;

import org.xml.sax.SAXException;

import android.os.AsyncTask;

import com.iagl.newvlille.data.Station;
import com.iagl.newvlille.data.StationDetail;
import com.iagl.newvlille.parser.StationDetailXMLParser;

public class UpdatePlacesVelos extends AsyncTask<Station, Integer, StationDetail>{

    @Override
    protected StationDetail doInBackground(Station... s) {
    	if(s.length==1){
    		Station station = s[0];
	        StationDetailXMLParser parser = new StationDetailXMLParser("http://vlille.fr/stations/xml-station.aspx?borne="+station.getId());
	        StationDetail detail=null;
	        
	        try {
	            detail=parser.parse();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (SAXException e) {
	            e.printStackTrace();
	        }
	        return detail;
    	}
    	else return null;

    }

}

