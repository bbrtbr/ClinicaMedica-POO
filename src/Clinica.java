
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Consulta;
import Classes.Medico;
import Classes.Paciente;

public class Clinica {

        Scanner scanner = new Scanner(System.in);
        private List<Paciente> pacientes;
        private List<Medico> medicos;
        private List<Consulta> consultas;

        public Clinica() {
                this.pacientes = new ArrayList<>();
                this.medicos = new ArrayList<>();
                this.consultas = new ArrayList<>();
        }

        public void inicio() {
                Paciente paciente = new Paciente("a", "a", "a", null, "a", "a", 0);
                Medico medico = new Medico(null, null, null, null, "b", "b", 0, null);
                medicos.add(medico);
                pacientes.add(paciente);
        }

        public void adicionarPaciente() {
                System.out.println("Informe o nome completo: ");
                String name = scanner.nextLine();
                System.out.println("Informe o CPF");
                String cpf = scanner.nextLine();
                System.out.println("Informe o endereço");
                String endereco = scanner.nextLine();
                System.out.println("Informe o telefone");
                String telefone = scanner.nextLine();
                System.out.println("Informe o email");
                String email = scanner.nextLine();
                System.out.println("Informe uma senha para o usuário");
                String senha = scanner.nextLine();
                Paciente paciente = new Paciente(name, cpf, endereco, telefone, email, senha, 0);
                if (paciente != null && !pacientes.contains(paciente)) {
                        pacientes.add(paciente);
                        System.out.println("Médico cadastrado.");
                } else {
                        System.out.println("Problema ao cadastrar paciente.");
                }
        }

        public void adicionarMedico() {
                System.out.println("Informe o nome completo: ");
                String name = scanner.nextLine();
                System.out.println("Informe o CPF");
                String cpf = scanner.nextLine();
                System.out.println("Informe o endereço");
                String endereco = scanner.nextLine();
                System.out.println("Informe o telefone");
                String telefone = scanner.nextLine();
                System.out.println("Informe o email");
                String email = scanner.nextLine();
                System.out.println("Informe uma senha para o usuário");
                String senha = scanner.nextLine();
                System.out.println("Digite o salário do médico");
                double salario = scanner.nextDouble();
                System.out.println("Especializaçã do médico");
                String especializacao = scanner.nextLine();
                Medico medico = new Medico(name, cpf, endereco, telefone, email, senha, salario, especializacao);
                if (!medicos.contains(medico)) {
                        medicos.add(medico);
                        System.out.println("Médico cadastrado.");
                } else {
                        System.out.println("Problema ao cadastrar paciente.");
                }
        }

        public void criarConsulta(Medico medico, Paciente paciente) throws Exception {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Informe a data: ");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date utilDate = (Date) sdf.parse(scanner.next());

                System.out.println("Informe o valor: ");
                Double valor = scanner.nextDouble();
                scanner.close();
                Consulta consulta = new Consulta(medico, paciente, utilDate, valor);
                try {
                        consulta.getPaciente().verificarSaldo(consulta.getValor());
                        consulta.add(consulta);
                } catch (Exception e) {
                        System.out.println(e);
                }
        }

        public void exibirConsultas() {
                System.out.println("Consultas agendadas:");
                for (Consulta consulta : consultas) {
                        consulta.exibirInformacoes();
                }
        }
        public void exibirConsultasPaciente(Paciente paciente){
                System.out.println("Consultas agendedas do paciente: "+ paciente.getName());
                for (Consulta consulta : consultas) {
                        if(paciente.equals(consulta.getPaciente())){
                                System.out.println("Data da consulta: "+consulta.getData());
                                System.out.println("Médico responsável: "+consulta.getMedico());
                        }
                }
        }

        public void exibirPacientes() {
                System.out.println("Pacientes cadastrados:");
                for (Paciente paciente : pacientes) {
                        paciente.exibirInformacoes();
                }
        }

        public void exibirPacientePorCPF() {
                System.out.println("Informe o CPF do paciente:");
                String cpfProcurado = scanner.nextLine();

                for (Paciente paciente : pacientes) {
                        if (paciente.getCpf().equals(cpfProcurado)) {
                                System.out.println("Informações do paciente com CPF " + cpfProcurado + ":");
                                paciente.exibirInformacoes();
                                return;
                        }
                }

                System.out.println("Paciente com CPF " + cpfProcurado + " não encontrado.");
        }

        public Paciente autenticarPaciente(String nome, String senha) {

                for (Paciente paciente : this.pacientes) {
                        if (paciente.getName().equals(nome) && paciente.getSenha().equals(senha)) {
                                return paciente;
                        }
                }
                return null;
        }

        public Medico autenticarMedico(String nome, String senha) {
                for (Medico medico : this.medicos) {
                        if (medico.getName().equals(nome) && medico.getSenha().equals(senha)) {
                                return medico;
                        }
                }
                return null;
        }

}
