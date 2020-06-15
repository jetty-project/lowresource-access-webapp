package org.eclipse.jetty.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.LowResourceMonitor;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

@WebServlet("/baserequest")
public class FromBaseRequestServlet extends AbstractLowResourceDumpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Server server = Request.getBaseRequest(request).getHttpChannel().getServer();

        LowResourceMonitor monitor = server.getBean(LowResourceMonitor.class);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        dump(response.getOutputStream(), monitor);
    }
}
