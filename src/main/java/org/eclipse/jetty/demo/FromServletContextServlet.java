package org.eclipse.jetty.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.LowResourceMonitor;

@WebServlet("/servletcontext")
public class FromServletContextServlet extends AbstractLowResourceDumpServlet
{
    private LowResourceMonitor monitor;

    @Override
    public void init() throws ServletException
    {
        monitor = (LowResourceMonitor)getServletContext().getAttribute(LowResourceMonitor.class.getName());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        dump(response.getOutputStream(), monitor);
    }
}
