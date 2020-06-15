package org.eclipse.jetty.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.LowResourceMonitor;
import org.eclipse.jetty.server.Server;

@WebServlet("/requestattribute/connection")
public class FromRequestAttributeConnectionServlet extends AbstractLowResourceDumpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpConnection connection = (HttpConnection)request.getAttribute(HttpConnection.class.getName());
        Server server = connection.getServer();

        LowResourceMonitor monitor = server.getBean(LowResourceMonitor.class);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        dump(response.getOutputStream(), monitor);
    }
}
