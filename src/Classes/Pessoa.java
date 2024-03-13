package Classes;

import Interface.Informacoes;

abstract class Pessoa implements Informacoes {
    private String name, cpf, endereço, telefone, email, senha;
    Double saldo;

    public Pessoa(String name, String cpf, String endereço, String telefone, String email, String senha) {
        this.name = name;
        this.cpf = cpf;
        this.endereço = endereço;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + name);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereço);
        System.out.println("Telefone: " + telefone);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) obj;
            return cpf.equals(pessoa.cpf);
        }
        return false;
    }
}
