package Classes;

import Interface.ProfissionalMedico;

public class Medico extends Pessoa implements ProfissionalMedico {
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

    @Override
    public void atenderPaciente(Consulta consulta) {
        
        System.out.println("Realizando atendimento médico.");
        consulta.exibirInformacoes();
        consulta.setRealizada(true);

    }
}