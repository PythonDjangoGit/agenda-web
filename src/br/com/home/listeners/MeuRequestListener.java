package br.com.home.listeners;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public class MeuRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("[REQUEST FINALIZANDO...]");
    }

    private void imprimaTudoDoRequest(ServletRequest servletRequest) throws IOException, ServletException {
        Map<String, String[]> parametros = servletRequest.getParameterMap();
        System.out.printf("[REQUEST INICIALIZANDO...]\n");
        System.out.println("Todos os parametros:");
        for (String parametro : parametros.keySet()) {
            System.out.printf("%s = %s\n", parametro, parametros.get(parametro));
        }
        System.out.printf("%s = %s\n", "servletRequest.getCharacterEncoding()", servletRequest.getCharacterEncoding());
        System.out.printf("%s = %s\n", "servletRequest.getContentLength()", servletRequest.getContentLength());
        System.out.printf("%s = %s\n", "servletRequest.getContentType()", servletRequest.getContentType());

        System.out.printf("%s = %s\n", "servletRequest.getLocalAddr()", servletRequest.getLocalAddr());
        System.out.printf("%s = %s\n", "servletRequest.getLocalName()", servletRequest.getLocalName());
        System.out.printf("%s = %s\n", "servletRequest.getLocalPort()", servletRequest.getLocalPort());

        System.out.printf("%s = %s\n", "servletRequest.getProtocol()", servletRequest.getProtocol());

        System.out.printf("%s = %s\n", "servletRequest.getRemoteAddr()", servletRequest.getRemoteAddr());
        System.out.printf("%s = %s\n", "servletRequest.getRemoteHost()", servletRequest.getRemoteHost());
        System.out.printf("%s = %s\n", "servletRequest.getRemotePort()", servletRequest.getRemotePort());

        System.out.printf("%s = %s\n", "servletRequest.getScheme()", servletRequest.getScheme());

        System.out.printf("%s = %s\n", "servletRequest.getServerName()", servletRequest.getServerName());
        System.out.printf("%s = %s\n", "servletRequest.getServerPort()", servletRequest.getServerPort());
        System.out.printf("%s = %s\n", "servletRequest.isSecure()", String.valueOf(servletRequest.isSecure()));
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("Dados do request:");
        System.out.printf("%s = %s\n", "request.getRequestURI()", request.getRequestURI());
        System.out.printf("%s = %s\n", "request.getRequestURL()", request.getRequestURL().toString());
        System.out.printf("%s = %s\n", "request.getMethod()", request.getMethod());

        System.out.printf("%s = %s\n", "request.getPathInfo()", request.getPathInfo());
        System.out.printf("%s = %s\n", "request.getPathTranslated()", request.getPathTranslated());
        System.out.printf("%s = %s\n", "request.getQueryString()", request.getQueryString());
        System.out.printf("%s = %s\n", "request.getRemoteUser()", request.getRemoteUser());
        System.out.printf("%s = %s\n", "request.getContextPath()", request.getContextPath());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        try {

            imprimaTudoDoRequest(servletRequestEvent.getServletRequest());
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
