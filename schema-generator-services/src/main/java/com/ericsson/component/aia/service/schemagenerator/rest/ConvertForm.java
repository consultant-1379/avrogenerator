package com.ericsson.component.aia.service.schemagenerator.rest;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

/**
 * Defines the parameters to be passed as a form to the /convert endpoint
 *
 */
public class ConvertForm {

    private byte[] xmlSchema;

    public String getXmlSchemaAsString() {
        return new String(xmlSchema);
    }

    public byte[] getXmlSchema() {
        return xmlSchema;
    }

    @FormParam("xmlSchema")
    @PartType("application/octet-stream")
    public void setXmlSchema(final byte[] xmlSchema) {
        this.xmlSchema = xmlSchema;
    }

}
