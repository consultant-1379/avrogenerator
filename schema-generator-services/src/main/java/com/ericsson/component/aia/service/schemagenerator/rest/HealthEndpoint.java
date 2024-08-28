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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * This class defines the REST endpoints for checking application health.
 *
 */
@Path("/health")
public class HealthEndpoint {

    /**
     * Endpoint to be called just to make sure application is up
     * @return String with default message
     */
    @GET
    @Produces("text/plain")
    public String doGet() {
        return "Schema Generator is up";
    }

}