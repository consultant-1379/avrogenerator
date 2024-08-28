package com.ericsson.component.aia.service.schemagenerator.rest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HealthEndpointTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() throws Exception {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(HealthEndpoint.class)
                .addAsWebInfResource(new File("src/main/resources/META-INF/beans.xml"), "beans.xml");
    }

    @Test
    @RunAsClient
    public void test_application_starts_up(@ArquillianResource URL baseUrl) {
        final String responseBody = ClientBuilder.newClient().target(baseUrl + "health").request(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("Schema Generator is up", responseBody);
    }

}