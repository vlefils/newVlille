package com.iagl.newvlille.parser;

import java.io.IOException;
import java.net.URL;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.iagl.newvlille.data.StationDetail;
import com.iagl.newvlille.handler.StationDetailHandler;

/**
 * Created by lefils on 22/09/14.
 */
public class StationDetailXMLParser {

    XMLReader myReader;
    String url;
    StationDetailHandler handler;

    public StationDetailXMLParser(String url){

            System.setProperty("org.xml.sax.driver","org.xmlpull.v1.sax2.Driver");
        try {
            myReader = XMLReaderFactory.createXMLReader();
            handler = new StationDetailHandler();
            myReader.setContentHandler(handler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
            this.url=url;


    }

    public StationDetail parse() throws IOException, SAXException {
        InputSource is = new InputSource(new URL(url).openStream());
        is.setEncoding("ISO-8859-1");
        myReader.parse(is);
        return handler.getDetails();
    }
}
