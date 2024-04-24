package com.training.aem.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,configurationPolicy = ConfigurationPolicy.REQUIRE,
        property = {
        "sling.servlet.paths=" + "/bin/demopathbased",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET
        }
)
public class RunModeBasedServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Inside RunModeBasedServlet");
    }

    @ObjectClassDefinition(name = "RunMode Based Servlet Configuration", description = "Configuration for RunModeBasedServlet")
    public @interface RunModeSpecificConfiguration{
        @AttributeDefinition(name = "Run Modes", description = "Run modes for which this servlet is active")
        String[] sling_servlet_runmodes() default {"author"};
    }
}
