import enums.TipoPlano;
import models.*;
import services.AcademiaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AcademiaService service = new AcademiaService();

        int opcao;

        do {
            System.out.println("\n===== GYM MANAGEMENT SYSTEM =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Editar aluno");
            System.out.println("3 - Excluir aluno");
            System.out.println("4 - Listar alunos");
            System.out.println("5 - Buscar aluno por CPF");
            System.out.println("6 - Registrar pagamento");
            System.out.println("7 - Verificar inadimplentes");
            System.out.println("8 - Cadastrar treino");
            System.out.println("9 - Histórico de pagamentos");
            System.out.println("10 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    Plano plano = escolherPlano(scanner, service);

                    Aluno aluno = new Aluno(nome, cpf, idade, plano);
                    service.cadastrarAluno(aluno);
                    break;

                case 2:
                    System.out.print("CPF do aluno: ");
                    String cpfEditar = scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Nova idade: ");
                    int novaIdade = scanner.nextInt();
                    scanner.nextLine();

                    Plano novoPlano = escolherPlano(scanner, service);

                    service.editarAluno(cpfEditar, novoNome, novaIdade, novoPlano);
                    break;

                case 3:
                    System.out.print("CPF do aluno: ");
                    String cpfExcluir = scanner.nextLine();
                    service.excluirAluno(cpfExcluir);
                    break;

                case 4:
                    service.listarAlunos();
                    break;

                case 5:
                    System.out.print("CPF do aluno: ");
                    String cpfBuscar = scanner.nextLine();

                    Aluno alunoEncontrado = service.buscarAlunoPorCpf(cpfBuscar);

                    if (alunoEncontrado != null) {
                        System.out.println(alunoEncontrado);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("CPF do aluno: ");
                    String cpfPagamento = scanner.nextLine();
                    service.registrarPagamento(cpfPagamento);
                    break;

                case 7:
                    service.verificarInadimplentes();
                    break;

                case 8:
                    System.out.print("CPF do aluno: ");
                    String cpfTreino = scanner.nextLine();

                    System.out.print("Nome do treino: ");
                    String nomeTreino = scanner.nextLine();

                    Treino treino = new Treino(nomeTreino);

                    System.out.print("Quantos exercícios deseja cadastrar? ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < quantidade; i++) {
                        System.out.print("Nome do exercício: ");
                        String nomeExercicio = scanner.nextLine();

                        System.out.print("Séries e repetições, exemplo 4x10: ");
                        String series = scanner.nextLine();

                        treino.adicionarExercicio(new Exercicio(nomeExercicio, series));
                    }

                    service.cadastrarTreino(cpfTreino, treino);
                    break;

                case 9:
                    System.out.print("CPF do aluno: ");
                    String cpfHistorico = scanner.nextLine();
                    service.historicoPagamentos(cpfHistorico);
                    break;

                case 10:
                    service.relatorios();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static Plano escolherPlano(Scanner scanner, AcademiaService service) {
        System.out.println("\nEscolha o plano:");
        System.out.println("1 - Bronze");
        System.out.println("2 - Prata");
        System.out.println("3 - Ouro");
        System.out.println("4 - Premium");
        System.out.print("Opção: ");

        int opcaoPlano = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoPlano) {
            case 1:
                return service.buscarPlanoPorTipo(TipoPlano.BRONZE);
            case 2:
                return service.buscarPlanoPorTipo(TipoPlano.PRATA);
            case 3:
                return service.buscarPlanoPorTipo(TipoPlano.OURO);
            case 4:
                return service.buscarPlanoPorTipo(TipoPlano.PREMIUM);
            default:
                System.out.println("Plano inválido. Plano Bronze selecionado por padrão.");
                return service.buscarPlanoPorTipo(TipoPlano.BRONZE);
        }
    }
}