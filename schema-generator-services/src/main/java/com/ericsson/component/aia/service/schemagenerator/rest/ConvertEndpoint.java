/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2018
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 */
package com.ericsson.component.aia.service.schemagenerator.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

/**
 * This class defines the REST endpoints for the schema conversion feature.
 *
 */
@Path("/convert")
public class ConvertEndpoint {

    /**
     * Convert schema endpoint
     * @return Json Response with converted schema
     * @param requestParameters Parameters that were passed as form
     */
    @POST
    @Path("/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String convert(@MultipartForm final ConvertForm requestParameters) {
        return requestParameters.getXmlSchemaAsString();
    }

}