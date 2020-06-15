# LowResourceMonitor access in Servlet

This project demonstrates several different ways to access the LowResourceMonitor from a Servlet.

## To compile

``` shell
$ mvn clean install
```

The `webapps/demo.war` now exists and makes this project a valid `${jetty.base}` directory.

## To run in standalone mode

``` shell
$ cd /path/to/code/lowresource-access-webapp
$ java -jar /path/to/jetty-home/start.jar 
```

This now executes a new Jetty instance using the configuration in [`start.ini`](start.ini) and
the webapps in [`webapps/`](webapps/) directory

## The exposed resource endpoints

The following URLs are present (but don't show much response data).

* `http://localhost:8080/demo/baserequest` - this is the [`FromBaseRequestServlet`](src/main/java/org/eclipse/jetty/demo/FromBaseRequestServlet.java) technique
* `http://localhsot:8080/demo/requestattribute/channel` - this is the [`FromRequestAttributeChannelServlet`](src/main/java/org/eclipse/jetty/demo/FromRequestAttributeChannelServlet.java) technique
* `http://localhsot:8080/demo/requestattribute/connection` - this is the [`FromRequestAttributeConnectionServlet`](src/main/java/org/eclipse/jetty/demo/FromRequestAttributeConnectionServlet.java) technique
* `http://localhsot:8080/demo/servletcontext` - this is the [`FromServletContextServlet`](src/main/java/org/eclipse/jetty/demo/FromServletContextServlet.java) technique.

## Notes

The ability to access the `LowResourceMonitor` requires some holes to be punched into the `WebAppClassLoader` to allow
the Servlet to see the `LowResourceMonitor` class.

See [`webapps/demo.xml`](webapps/demo.xml) for examples of this configuration.