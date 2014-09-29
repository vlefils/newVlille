package com.iagl.newvlille.asyncTask;

import android.os.AsyncTask;

import com.iagl.newvlille.data.Station;
import com.iagl.newvlille.parser.StationListXMLParser;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateStationList extends AsyncTask<String, Integer, List<Station>>{

    @Override
    protected List<Station> doInBackground(String... s) {
        StationListXMLParser parser = new StationListXMLParser("http://vlille.fr/stations/xml-stations.aspx");
        List<Station> stations=new ArrayList<Station>();
        try {
            stations=parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return stations;
    }

}

