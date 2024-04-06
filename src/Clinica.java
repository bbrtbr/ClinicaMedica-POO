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
                Paciente paciente = new Paciente("a", "a", "a", null, "a", "a", 50000);
                Medico medico = new Medico("b", "b", null, null, "b", "b", 0, null);
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
                scanner.nextLine(); // Consumir a nova linha
                System.out.println("Especialização do médico");
                String especializacao = scanner.nextLine();
                Medico medico = new Medico(name, cpf, endereco, telefone, email, senha, salario, especializacao);
                if (!medicos.contains(medico)) {
                        medicos.add(medico);
                        System.out.println("Médico cadastrado.");
                } else {
                        System.out.println("Problema ao cadastrar médico.");
                }
        }

        public void criarConsulta() {
                Scanner scanner = new Scanner(System.in);
                Medico medicoConsulta = null;
                Paciente pacienteConsulta = null;
                System.out.println("Informe o CPF do paciente: ");
                String cpfPaciente = scanner.nextLine();
                System.out.println("Informe o CPF do médico: ");
                String cpfMedico = scanner.nextLine();
                for (Paciente paciente : pacientes) {
                        if (paciente.getCpf().equals(cpfPaciente)) {
                                pacienteConsulta = paciente;
                                break;
                        } else {
                                System.out.println("Paciente não encontrado");
                                break;
                        }
                }
                for (Medico medico : medicos) {
                        if (medico.getCpf().equals(cpfMedico)) {
                                medicoConsulta = medico;
                                break;
                        } else {
                                System.out.println("Médico não encontrado");
                                break;
                        }
                }

                System.out.println("Informe o valor: ");
                Double valor = 0.0;

                valor = scanner.nextDouble();

                Consulta consulta = new Consulta(medicoConsulta, pacienteConsulta, valor);

                if (consulta.getPaciente().verificarSaldo(consulta.getValor())) {
                        consultas.add(consulta);
                        System.out.println("Ok");
                } else {
                        System.out.println("Saldo insuficiente");
                }

        }

        public void exibirConsultas() {
                System.out.println("Consultas agendadas:");
                for (Consulta consulta : consultas) {
                        consulta.exibirInformacoes();
                }
        }

        public void exibirConsultasPaciente(Paciente paciente) {
                System.out.println("Consultas agendedas do paciente: " + paciente.getName());
                for (Consulta consulta : consultas) {
                        if (paciente.equals(consulta.getPaciente())) {

                                System.out.println("Médico responsável: " + consulta.getMedico());
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

        public Paciente autenticarPaciente(String email, String senha) {
                for (Paciente paciente : this.pacientes) {

                        if (paciente.getEmail().equals(email) && paciente.getSenha().equals(senha)) {
                                return paciente;
                        }
                }
                return null;
        }

        public Medico autenticarMedico(String email, String senha) {
                for (Medico medico : this.medicos) {

                        if (medico.getEmail().equals(email) && medico.getSenha().equals(senha)) {
                                return medico;
                        }
                }
                return null;
        }

}
