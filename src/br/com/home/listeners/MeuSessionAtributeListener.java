package br.com.home.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MeuSessionAtributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("[ATRIBUTO ADICIONADO...]");
        System.out.printf("%s = %s", "httpSessionBindingEvent.getName()", httpSessionBindingEvent.getName());
        System.out.printf("%s = %s", "httpSessionBindingEvent.getValue()", httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("[ATRIBUTO REMOVIDO...]");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("[ATRIBUTO REPOSTO...]");
    }
}
