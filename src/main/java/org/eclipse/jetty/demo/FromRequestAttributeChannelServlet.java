package org.eclipse.jetty.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.LowResourceMonitor;
import org.eclipse.jetty.server.Server;

@WebServlet("/requestattribute/channel")
public class FromRequestAttributeChannelServlet extends AbstractLowResourceDumpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpChannel channel = (HttpChannel)request.getAttribute(HttpChannel.class.getName());
        Server server = channel.getServer();

        LowResourceMonitor monitor = server.getBean(LowResourceMonitor.class);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        dump(response.getOutputStream(), monitor);
    }
}
