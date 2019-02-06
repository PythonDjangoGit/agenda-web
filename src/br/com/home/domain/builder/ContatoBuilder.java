package br.com.home.domain.builder;

import br.com.home.domain.Contato;

import java.util.Calendar;

public class ContatoBuilder {

    private Contato contato;

    private ContatoBuilder() {
        this.contato = new Contato();
    }

    public static ContatoBuilder getInstance() {
        return new ContatoBuilder();
    }

    public Contato build() {
        return this.contato;
    }

    public ContatoBuilder comId(Integer id){
        this.contato.setId(id);
        return this;
    }

    public ContatoBuilder comNome(String nome) {
        this.contato.setNome(nome);
        return this;
    }

    public ContatoBuilder comEmail(String email) {
        this.contato.setEmail(email);
        return this;
    }

    public ContatoBuilder comEndereco(String endereco) {
        this.contato.setEndereco(endereco);
        return this;
    }

    public ContatoBuilder comDataNascimento(Calendar dataNascimento) {
        this.contato.setDataNascimento(dataNascimento);
        return this;
    }
}
