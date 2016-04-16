package com.conference.services.common.transformers;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.Validate;

import com.conference.services.exceptions.ServiceException;

public class XsltTransformer implements ITransformer<File, String> {

	private File sourceXml;
	
	public XsltTransformer(File sourceXml) {
		Validate.notNull(sourceXml);
		this.sourceXml = sourceXml;
	}
	
	@Override
	public String transform(File xsltFile, Map<String, Object> params) {
		try {
			Source xsltSource = new StreamSource(xsltFile);
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer(xsltSource);
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				transformer.setParameter(entry.getKey(), entry.getValue());
			}
			Source xmlSource = new StreamSource(sourceXml);
			StringWriter writer = new StringWriter();
			transformer.transform(xmlSource, new StreamResult(writer));
			return writer.toString();
		} catch (Exception e) {
			throw new ServiceException("Transformation error");
		}

	}

}
