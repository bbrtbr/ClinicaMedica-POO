package Classes;

import java.util.Scanner;


public class Medico extends Pessoa {
    double salario;
    String especializacao;

    public Medico(String name, String cpf, String endereço, String telefone, String email, String senha, double salario,
            String especializacao) {
        super(name, cpf, endereço, telefone, email, senha);
        this.salario = salario;
        this.especializacao = especializacao;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); // Chama o método da superclasse (Pessoa)
        System.out.println("Salário: " + salario);
        System.out.println("Especialização: " + especializacao);
    }

}