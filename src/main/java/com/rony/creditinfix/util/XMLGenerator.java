package com.rony.creditinfix.util;

import com.rony.creditinfix.models.report.CompanyInfoReportGenerateDTO;
import lombok.experimental.UtilityClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@UtilityClass
public class XMLGenerator {
    public String generateXML(CompanyInfoReportGenerateDTO report) throws Exception {
        JAXBContext context = JAXBContext.newInstance(CompanyInfoReportGenerateDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // Set property to include XML Schema instance namespace declaration
        marshaller.setProperty("jaxb.schemaLocation", "http://www.w3.org/2001/XMLSchema-instance");
        // Set property to include XML Schema namespace declaration
        marshaller.setProperty("jaxb.noNamespaceSchemaLocation", "http://www.w3.org/2001/XMLSchema");

        StringWriter writer = new StringWriter();
        marshaller.marshal(report, writer);
        return writer.toString();
    }
}
