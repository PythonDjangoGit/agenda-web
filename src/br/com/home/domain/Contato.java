package br.com.home.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class Contato implements Serializable {

    private Integer id;
    private String nome;
    private String endereco;
    private String email;
    private Calendar dataNascimento;

    public Contato() {
    }

    public Contato(Integer id, String nome, String endereco, String email, Calendar dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
