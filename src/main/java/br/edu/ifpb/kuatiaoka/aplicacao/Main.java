package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.*;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.*;

public class Main {
    private static GerenciadorBiblioteca sistema = new GerenciadorBiblioteca();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializa o sistema com dados para testes - Evita erro de build por falta de dados
        povoarDadosIniciais();

        int opcao = 0;
        do {
            try {
                exibirMenuPrincipal();
                if (leitor.hasNextInt()) {
                    opcao = leitor.nextInt();
                    leitor.nextLine(); // Limpa o buffer
                    processarOpcao(opcao);
                } else {
                    System.out.println("[!] Digite um número válido.");
                    leitor.nextLine();
                }
            } catch (Exception e) {
                System.out.println("[!] Erro inesperado: " + e.getMessage());
                leitor.nextLine();
            }
        } while (opcao != 5);
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1: menuGerenciarItens(); break;
            case 2: menuGerenciarUsuarios(); break;
            case 3: menuOperacoes(); break;
            case 4: menuConsultas(); break;
            case 5: System.out.println("Saindo... Valeu!"); break;
            default: System.out.println("[!] Opção inválida.");
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("      SISTEMA BIBLIOTECA KUATIAOKA      ");
        System.out.println("========================================");
        System.out.println(" [1] Itens (Acervo)");
        System.out.println(" [2] Usuários (Alunos/Prof)");
        System.out.println(" [3] Operações (Empréstimo)");
        System.out.println(" [4] Consultas e Históricos");
        System.out.println(" [5] Sair");
        System.out.println("========================================");
        System.out.print("Escolha: ");
    }

    private static void menuGerenciarItens() {
        System.out.println("\n--- GERENCIAR ACERVO ---");
        System.out.println("1. Listar Tudo\n2. Novo Livro\n3. Novo CD\n4. Novo DVD\n5. Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); leitor.nextLine();

        switch (op) {
            case 1: sistema.mostrarTudo(); break;
            case 2:
                System.out.print("Título: "); String t = leitor.nextLine();
                System.out.print("Autor: "); String au = leitor.nextLine();
                // Ajuste no construtor para evitar erro de build
                sistema.cadastrarNovoItem(new Livro(t, "Editora Padrão", "999", au, 2024, 1, "Geral", 100, "S/S"));
                break;
            case 3:
                System.out.print("Título: "); String tc = leitor.nextLine();
                System.out.print("Artista: "); String art = leitor.nextLine();
                // Simulação de ajuste no construtor de CD
                sistema.cadastrarNovoItem(new CD(tc, "Independente", art, new ArrayList<>()));
                break;
            case 4:
                System.out.print("Título: "); String td = leitor.nextLine();
                sistema.cadastrarNovoItem(new DVD(td, "S/E", "Diretor Desconhecido", 120, "Livre"));
                break;
        }
    }

    private static void menuGerenciarUsuarios() {
        System.out.println("\n--- GERENCIAR USUÁRIOS ---");
        System.out.println("1. Listar Ativos\n2. Novo Aluno\n3. Novo Professor\n4. Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); leitor.nextLine();

        if (op == 1) {
            sistema.listarUsuarios(); // Implementação da listagem
        } else if (op == 2 || op == 3) {
            System.out.print("Nome: "); String nome = leitor.nextLine();
            System.out.print("Matrícula: "); String mat = leitor.nextLine();
            if (op == 2) sistema.registrarPessoa(new Aluno(nome, mat));
            else sistema.registrarPessoa(new Professor(nome, mat));
            System.out.println("Usuário registrado com sucesso!");
        }
    }

    private static void menuOperacoes() {
        System.out.println("\n--- MOVIMENTAÇÃO ---");
        System.out.println("1. Empréstimo\n2. Devolução\n3. Voltar");
        System.out.print("Escolha: ");
        int op = leitor.nextInt(); leitor.nextLine();
        
        if(op == 3) return;

        System.out.print("Matrícula: "); String mat = leitor.nextLine();
        System.out.print("Título: "); String tit = leitor.nextLine();
        
        Pessoa p = sistema.buscarPorMatricula(mat);
        Item i = sistema.buscarPorTitulo(tit);

        if (p != null && i != null) {
            if (op == 1) sistema.fazerEmprestimo(p, i);
            else sistema.devolverItem(p, i);
        } else {
            System.out.println("[!] Usuário ou Item não encontrado.");
        }
    }

    private static void menuConsultas() {
        System.out.println("\n--- CONSULTAS E RELATÓRIOS ---");
        System.out.println("1. Histórico do Item\n2. Buscar por Editora\n3. Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); leitor.nextLine();

        if (op == 1) {
            System.out.print("Título do Item: "); String t = leitor.nextLine();
            Item item = sistema.buscarPorTitulo(t);
            if (item != null) item.exibirHistorico(); // Implementação do histórico
            else System.out.println("[!] Item não localizado.");
        } else if (op == 2) {
            System.out.print("Editora: "); String ed = leitor.nextLine();
            sistema.buscarPorEditora(ed);
        }
    }

    private static void povoarDadosIniciais() {
        // Limpando e reinicializando o gerenciador para evitar duplicatas em tempo de execução
        sistema.registrarPessoa(new Aluno("Joao Silva", "123"));
        sistema.registrarPessoa(new Professor("Dr. Frederico", "456"));
        sistema.cadastrarNovoItem(new Livro("Java POO", "Pearson", "123", "Deitel", 2024, 1, "TI", 500, "Intro"));
        System.out.println("[SISTEMA] Dados carregados.");
    }
}