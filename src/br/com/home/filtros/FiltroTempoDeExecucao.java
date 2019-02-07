package br.com.home.filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/sistema")
public class FiltroTempoDeExecucao implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long tempoInicial = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long tempoFinal = System.currentTimeMillis();
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        String logica = ((HttpServletRequest) servletRequest).getParameter("logica");
        System.out.println("A requisicao para " + uri + "?logica=" + logica +
                " demorou " + (tempoFinal - tempoInicial) + "ms.");
    }

    @Override
    public void destroy() {
    }
}
