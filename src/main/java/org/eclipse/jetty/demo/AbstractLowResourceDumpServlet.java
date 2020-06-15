package org.eclipse.jetty.demo;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.server.LowResourceMonitor;

public class AbstractLowResourceDumpServlet extends HttpServlet
{
    protected void dump(ServletOutputStream out, LowResourceMonitor monitor) throws IOException
    {
        Set<LowResourceMonitor.LowResourceCheck> checks = monitor.getLowResourceChecks();
        out.println("LowResourceChecks: ");
        for (LowResourceMonitor.LowResourceCheck check : checks)
        {
            out.println(String.format("   (%s) %s%n", check.getClass().getName(), check));
        }
    }
}
