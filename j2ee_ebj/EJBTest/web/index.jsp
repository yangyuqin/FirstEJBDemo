<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 16-3-28
  Time: 下午4:22
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.naming.InitialContext"%>
<%@page import="com.ejb.HelloWorld"%>
<%@page import="javax.naming.NamingException"%>
<%@ page import="java.util.Hashtable" %>
<%@ page import="javax.naming.Context" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试页</title>
</head>
<body>
         Hello World!!!!!

<%
    final String appName = "";
    final String moduleName = "EJBTest_war_exploded";
    final String distinctName = "";
    final String beanName = "HelloWorldEJB";
    final String viewClassName = HelloWorld.class.getName();
    final String namespace = "ejb:" + appName + "/" + moduleName
            + "/" + distinctName + "/" + beanName + "!" + viewClassName;
    System.out.println(namespace);

    try {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        HelloWorld helloWorld = (HelloWorld) context.lookup(namespace);
        System.out.println(helloWorld);
        String s = helloWorld.sayHello("yangyuqin");
        System.out.println(s);

    }catch (NamingException e) {
        e.printStackTrace();
    }
%>
</body>
</html>