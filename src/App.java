import java.util.Scanner;

import Classes.Medico;
import Classes.Paciente;

public class App {
    Scanner scanner = new Scanner(System.in);
    static Clinica clinica = new Clinica();

    public static void main(String[] args) throws Exception {
        clinica.inicio();
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo a Clinica, você deseja autenticar como:\n1 - Cliente\n2 - Funcionário");
        opcao = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o seu email: ");
        String email = scanner.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = scanner.nextLine();
        switch (opcao) {
            case 1:
                Paciente pacienteAutenticado = clinica.autenticarPaciente(email, senha);
                if (pacienteAutenticado != null) {
                    System.out.println("Paciente autenticado com sucesso!");
                    menuCliente(pacienteAutenticado);
                } else {
                    System.out.println("Email ou senha incorretos. Tente novamente.");
                }
                break;
            case 2:
                Medico medicoAutenticado = clinica.autenticarMedico(email, senha);
                if (medicoAutenticado != null) {
                    System.out.println("Medico autenticado com sucesso!");
                    menuFuncionario();

                } else {
                    System.out.println("Email ou senha incorretos. Tente novamente.");
                }
                break;
            default:
                break;
        }

        scanner.close();
    }

    public static void menuCliente(Paciente paciente) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Ver meus dados");
            System.out.println("2. Ver minhas consultas");
            System.out.println("3. Ver meu saldo");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    paciente.exibirInformacoes();
                    break;

                case 2:
                    clinica.exibirConsultasPaciente(paciente);
                    break;

                case 3:
                    System.out.println("Meu saldo: " + paciente.getSaldo());
                    break;

                case 0:

                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void menuFuncionario() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Exibir Pacientes");
            System.out.println("3. Consultar Paciente");
            System.out.println("4. Exibir Consultas");
            System.out.println("5. Criar consulta");
            System.out.println("6. Adicionar Médico");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    clinica.adicionarPaciente();
                    break;

                case 2:
                    clinica.exibirPacientes();
                    break;

                case 3:
                    clinica.exibirPacientePorCPF();
                    break;

                case 4:
                    clinica.exibirConsultas();
                    break;
                case 5:
                    clinica.criarConsulta();
                    break;
                case 6:
                    clinica.adicionarMedico();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

    }

}
