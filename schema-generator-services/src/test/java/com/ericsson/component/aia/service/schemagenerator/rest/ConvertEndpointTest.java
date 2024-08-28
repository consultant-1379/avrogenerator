package com.ericsson.component.aia.service.schemagenerator.rest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ConvertEndpointTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() throws Exception {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(ConvertEndpoint.class)
                .addClass(ConvertForm.class)
                .addAsWebInfResource(new File("src/main/resources/META-INF/beans.xml"), "beans.xml");
    }

    @Test
    @RunAsClient
    public void test_sends_file(@ArquillianResource URL baseUrl) {
        final MultipartFormDataOutput form = new MultipartFormDataOutput();
        form.addFormData("xmlSchema", "abc".getBytes(), MediaType.APPLICATION_OCTET_STREAM_TYPE);

        final Response response = ClientBuilder.newClient().target(baseUrl + "convert/").request(MediaType.TEXT_PLAIN).post(Entity.entity(form, MediaType.MULTIPART_FORM_DATA_TYPE));
        assertEquals(200, response.getStatus());
        
    }

}