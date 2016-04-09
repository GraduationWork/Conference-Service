package com.conference.core.mail;

import java.io.File;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Main {

	public static void main(String[] args) throws Exception {
		Source xsltSource = new StreamSource(new File("/workspace/University/projects/conference-service/conference-service/invitation.xslt"));
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xsltSource);
		transformer.setParameter("name", "Aliaksandr Kassirau");
		Source xmlSource = new StreamSource(new File("/workspace/University/projects/conference-service/conference-service/null.xml"));
//		transformer.transform(xmlSource, new StreamResult(new File("output.html")));

		StringWriter writer = new StringWriter();
		transformer.transform(xmlSource, new StreamResult(writer));
		writer.toString();
	}

}
