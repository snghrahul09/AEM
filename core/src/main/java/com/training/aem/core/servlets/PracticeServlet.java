package com.training.aem.core.servlets;

import com.day.cq.commons.jcr.JcrUtil;
import com.training.aem.core.services.jobs.SendEmailNotificationJob;
import com.training.aem.core.utils.ThridPartyApiCallUtility;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(service = Servlet.class,
        property = {
            "sling.servlet.paths="+"/bin/demo",
            "sling.servlet.methods="+ HttpConstants.METHOD_GET
        }
)
public class PracticeServlet extends SlingSafeMethodsServlet {

    @Reference
    JobManager jobManager;
    @Override
    protected void doGet( SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Session session = resourceResolver.adaptTo(Session.class);

//        Map<String, Object> jobProperties = new HashMap<>();
//        jobProperties.put("customParam", "value");
//        jobManager.addJob("my/job/topic", jobProperties);



//        try {
//            Node node = JcrUtils.getOrCreateByPath("/content/training-project/xyz","nt:unstructured",session);
//            response.getWriter().write(node.getName());
//        } catch (RepositoryException e) {
//            throw new RuntimeException(e);
//        }



//        String result = ThridPartyApiCallUtility.callThirdPartyApi("GET","https://dummyjson.com/products");
//        response.getWriter().write(result);
//        String newNodePath = "/content/training-project";
//        Resource resource = resourceResolver.getResource(newNodePath);
//        Node node = resource.adaptTo(Node.class);
//        if(node != null){
//            try {
//                Node newNode = node.addNode("ABCnfhfhgf","nt:unstructured");
//                newNode.setProperty("new node has been created","activate");
//                response.getWriter().write("page is created");
//                resourceResolver.commit();
//            } catch (RepositoryException e) {
//                throw new RuntimeException(e);
//            }finally {
//                if(resourceResolver != null && resourceResolver.isLive()){
//                    resourceResolver.close();
//                }
//            }
//        }

    }
}




