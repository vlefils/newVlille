package com.iagl.newvlille.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.iagl.newvlille.data.Station;

public class StationGeneralHandler extends DefaultHandler{

    //This is the list which shall be populated while parsing the XML.
    private ArrayList<Station> stationList = new ArrayList<Station>();

    public void startDocument() throws SAXException
    {
        //System.out.println("start of the document   : ");
    }
 
    public void endDocument() throws SAXException
    {
        //System.out.println("end of the document document     : ");
    }
 
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {

        //If this is start of 'user' element then prepare a new User instance
        if ("marker".equals(qName))
        {
            //New User instance
            Station station = new Station(attributes.getValue("id"),attributes.getValue("lat"),attributes.getValue("lng"),attributes.getValue("name"));
            this.stationList.add(station);
        }
    }
 
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
    }
 
    /**
     * This will be called everytime parser encounter a value node
     * */
    public void characters(char[] ch, int start, int length) throws SAXException
    {

    }
 

    //Accessor for userList object
    public ArrayList<Station> getStations()
    {
        return stationList;
    }
	
}
