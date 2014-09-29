package com.iagl.newvlille.handler;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.iagl.newvlille.data.StationDetail;

public class StationDetailHandler extends DefaultHandler{

    private StationDetail detail;
    private Stack<String> stack;

    public void startDocument() throws SAXException
    {
    	detail= new StationDetail();
    	stack = new Stack<String>();
        //System.out.println("start of the document   : ");
    }
 
    public void endDocument() throws SAXException
    {
        //System.out.println("end of the document document     : ");
    }
 
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
    	stack.add(qName);
        //If this is start of 'user' element then prepare a new User instance
    	
    }
 
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
    	stack.pop();
    }
 
    /**
     * This will be called everytime parser encounter a value node
     * */
    public void characters(char[] ch, int start, int length) throws SAXException
    {
    	if ("bikes".equals(stack.peek())){
    		detail.setBikes(Integer.parseInt(new String(ch)));
    	}
    	else if ("attachs".equals(stack.peek())){
    		detail.setAttachs(Integer.parseInt(new String(ch)));
    	}
    	else if ("adress".equals(stack.peek())){
    		detail.setAddress(new String(ch));
    	}
    	else if ("paiement".equals(stack.peek())){
    		detail.setPaiement(new String(ch));
    	}
    	else if ("lastupd".equals(stack.peek())){
    		detail.setLastupd(new String(ch));
    	}
    }
 

    //Accessor for userList object
    public StationDetail getDetails()
    {
        return detail;
    }
	
}
