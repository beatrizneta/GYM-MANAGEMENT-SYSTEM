package services;

import enums.TipoPlano;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class AcademiaService {
    private List<Aluno> alunos;
    private List<Plano> planos;

    public AcademiaService() {
        alunos = new ArrayList<>();
        planos = new ArrayList<>();
        criarPlanos();
    }

    private void criarPlanos() {
        planos.add(new Plano(TipoPlano.BRONZE, 79.90, 1, "Acesso à musculação"));
        planos.add(new Plano(TipoPlano.PRATA, 119.90, 1, "Musculação + aulas coletivas"));
        planos.add(new Plano(TipoPlano.OURO, 159.90, 1, "Musculação + aulas + avaliação física"));
        planos.add(new Plano(TipoPlano.PREMIUM, 219.90, 1, "Acesso completo + personal mensal"));
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public Plano buscarPlanoPorTipo(TipoPlano tipo) {
        for (Plano plano : planos) {
            if (plano.getTipo() == tipo) {
                return plano;
            }
        }
        return null;
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public Aluno buscarAlunoPorCpf(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    public void editarAluno(String cpf, String novoNome, int novaIdade, Plano novoPlano) {
        Aluno aluno = buscarAlunoPorCpf(cpf);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        aluno.setNome(novoNome);
        aluno.setIdade(novaIdade);
        aluno.setPlano(novoPlano);

        System.out.println("Aluno editado com sucesso!");
    }

    public void excluirAluno(String cpf) {
        Aluno aluno = buscarAlunoPorCpf(cpf);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        alunos.remove(aluno);
        System.out.println("Aluno excluído com sucesso!");
    }

    public void registrarPagamento(String cpf) {
        Aluno aluno = buscarAlunoPorCpf(cpf);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        Pagamento pagamento = new Pagamento(aluno.getPlano().getValor());
        aluno.adicionarPagamento(pagamento);

        System.out.println("Pagamento registrado com sucesso!");
    }

    public void verificarInadimplentes() {
        boolean encontrou = false;

        for (Aluno aluno : alunos) {
            if (aluno.estaInadimplente()) {
                System.out.println(aluno);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum aluno inadimplente.");
        }
    }

    public void historicoPagamentos(String cpf) {
        Aluno aluno = buscarAlunoPorCpf(cpf);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (aluno.getPagamentos().isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
            return;
        }

        for (Pagamento pagamento : aluno.getPagamentos()) {
            System.out.println(pagamento);
        }
    }

    public void cadastrarTreino(String cpf, Treino treino) {
        Aluno aluno = buscarAlunoPorCpf(cpf);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        aluno.adicionarTreino(treino);
        System.out.println("Treino cadastrado com sucesso!");
    }

    public void relatorios() {
        int totalAlunos = alunos.size();
        int inadimplentes = 0;
        double receitaMensal = 0;

        for (Aluno aluno : alunos) {
            receitaMensal += aluno.getPlano().getValor();

            if (aluno.estaInadimplente()) {
                inadimplentes++;
            }
        }

        double receitaAnual = receitaMensal * 12;

        System.out.println("Quantidade de alunos: " + totalAlunos);
        System.out.println("Quantidade de inadimplentes: " + inadimplentes);
        System.out.println("Receita mensal prevista: R$ " + receitaMensal);
        System.out.println("Receita anual prevista: R$ " + receitaAnual);
    }
}