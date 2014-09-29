package com.iagl.newvlille.parser;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.iagl.newvlille.data.Station;
import com.iagl.newvlille.handler.StationGeneralHandler;

/**
 * Created by lefils on 22/09/14.
 */
public class StationListXMLParser {

    XMLReader myReader;
    String url;
    StationGeneralHandler handler;

    public StationListXMLParser(String url){

            System.setProperty("org.xml.sax.driver","org.xmlpull.v1.sax2.Driver");
        try {
            myReader = XMLReaderFactory.createXMLReader();
            handler = new StationGeneralHandler();
            myReader.setContentHandler(handler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
            this.url=url;


    }

    public List<Station> parse() throws IOException, SAXException {
        InputSource is = new InputSource(new URL(url).openStream());
        is.setEncoding("ISO-8859-1");
        myReader.parse(is);
        return handler.getStations();
    }
}
