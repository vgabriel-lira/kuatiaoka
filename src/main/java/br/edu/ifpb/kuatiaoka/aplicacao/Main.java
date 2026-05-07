package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.*;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.*;

public class Main {
    private static GerenciadorBiblioteca sistema = new GerenciadorBiblioteca();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
<<<<<<< HEAD
        // Mano, deixei isso aqui pra gente já começar com dados e não passar vergonha
        povoarDadosIniciais();
        
=======
        // Inicializa o sistema com dados para testes - Evita erro de build por falta de dados
        povoarDadosIniciais();

>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
        int opcao = 0;
        do {
            try {
                exibirMenuPrincipal();
<<<<<<< HEAD
                opcao = leitor.nextInt();
                leitor.nextLine(); // Limpa o buffer pra não bugar as Strings!

                switch (opcao) {
                    case 1: menuGerenciarItens(); break;
                    case 2: menuGerenciarUsuarios(); break;
                    case 3: menuOperacoes(); break;
                    case 4: menuConsultas(); break;
                    case 5: System.out.println("Saindo... Valeu!"); break;
                    default: System.out.println("[!] Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[!] Erro: Digite apenas números, parceiro.");
                leitor.nextLine(); 
                opcao = 0;
=======
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
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
            }
        } while (opcao != 5);
    }

<<<<<<< HEAD
    private static void exibirMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("       SISTEMA BIBLIOTECA KUATIAOKA     ");
        System.out.println("========================================");
        System.out.println(" [1] Gerenciar Itens");
        System.out.println(" [2] Gerenciar Usuários");
        System.out.println(" [3] Operações (Empréstimo/Devolução)");
        System.out.println(" [4] Consultas e Históricos");
        System.out.println(" [5] Sair");
        System.out.println("========================================");
        System.out.print("Escolha: ");
    }

    private static void menuGerenciarItens() {
        System.out.println("\n--- GERENCIAR ITENS ---");
        System.out.println("1. Listar Acervo\n2. Cadastrar Livro\n3. Cadastrar CD\n4. Cadastrar DVD\n5. Voltar");
        System.out.print("Escolha: ");
        int op = leitor.nextInt(); leitor.nextLine();

        if (op == 1) {
            sistema.mostrarTudo();
        } else if (op == 2) {
            // Cadastro completo de Livro
            System.out.print("Título: "); String t = leitor.nextLine();
            System.out.print("Editora: "); String ed = leitor.nextLine();
            System.out.print("Autor: "); String au = leitor.nextLine();
            System.out.print("ISBN: "); String isbn = leitor.nextLine();
            System.out.print("Ano: "); int ano = leitor.nextInt(); leitor.nextLine();
            System.out.print("Edição: "); int edic = leitor.nextInt(); leitor.nextLine();
            System.out.print("Gênero: "); String gen = leitor.nextLine();
            System.out.print("Páginas: "); int pag = leitor.nextInt(); leitor.nextLine();
            System.out.print("Sinopse: "); String sin = leitor.nextLine();
            
            sistema.cadastrarNovoItem(new Livro(t, ed, isbn, au, ano, edic, gen, pag, sin));
            System.out.println("Livro cadastrado!");

        } else if (op == 3) {
            // Cadastro completo de CD
            System.out.print("Título: "); String t = leitor.nextLine();
            System.out.print("Editora: "); String ed = leitor.nextLine();
            System.out.print("Artista: "); String art = leitor.nextLine();
            
            List<String> faixas = new ArrayList<>();
            System.out.print("Quantas faixas tem o CD? ");
            int qtd = leitor.nextInt(); leitor.nextLine();
            for(int i=1; i<=qtd; i++) {
                System.out.print("Nome da faixa " + i + ": ");
                faixas.add(leitor.nextLine());
            }
            
            sistema.cadastrarNovoItem(new CD(t, ed, art, faixas));
            System.out.println("CD cadastrado!");

        } else if (op == 4) {
            // Cadastro completo de DVD
            System.out.print("Título: "); String t = leitor.nextLine();
            System.out.print("Editora: "); String ed = leitor.nextLine();
            System.out.print("Diretor: "); String dir = leitor.nextLine();
            System.out.print("Duração (min): "); int dur = leitor.nextInt(); leitor.nextLine();
            System.out.print("Classificação: "); String cl = leitor.nextLine();
            
            sistema.cadastrarNovoItem(new DVD(t, ed, dir, dur, cl));
            System.out.println("DVD cadastrado!");
        }
    }

    private static void menuGerenciarUsuarios() {
        System.out.println("\n--- GERENCIAR USUÁRIOS ---");
        System.out.println("1. Listar Usuários\n2. Novo Aluno\n3. Novo Professor\n4. Voltar");
        System.out.print("Escolha: ");
        int op = leitor.nextInt(); leitor.nextLine();

        if (op == 1) {
            sistema.listarUsuarios();
        } else if (op == 2 || op == 3) {
            System.out.print("Nome: "); String n = leitor.nextLine();
            System.out.print("Matrícula: "); String m = leitor.nextLine();
            if (op == 2) sistema.registrarPessoa(new Aluno(n, m));
            else sistema.registrarPessoa(new Professor(n, m));
            System.out.println("Usuário registrado!");
=======
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
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
        }
    }

    private static void menuOperacoes() {
<<<<<<< HEAD
        System.out.println("\n--- EMPRÉSTIMO / DEVOLUÇÃO ---");
        System.out.print("1. Empréstimo | 2. Devolução: ");
        int op = leitor.nextInt(); leitor.nextLine();
        
        System.out.print("Matrícula do Usuário: "); String mat = leitor.nextLine();
        System.out.print("Título do Item: "); String tit = leitor.nextLine();
        
        Usuario u = sistema.buscarPorMatricula(mat);
        Item i = sistema.buscarPorTitulo(tit);
        
        if (op == 1) sistema.fazerEmprestimo(u, i);
        else sistema.devolverItem(u, i);
    }

    private static void menuConsultas() {
        System.out.println("\n--- CONSULTAS ---");
        System.out.println("1. Ver Histórico de Item\n2. Buscar por Editora\n3. Voltar");
        System.out.print("Escolha: ");
=======
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
        
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
        int op = leitor.nextInt(); leitor.nextLine();

        if (op == 1) {
            System.out.print("Título do Item: "); String t = leitor.nextLine();
<<<<<<< HEAD
            Item i = sistema.buscarPorTitulo(t);
            if (i != null) i.exibirHistorico();
            else System.out.println("Item não encontrado.");
        } else if (op == 2) {
            System.out.print("Nome da Editora: "); String ed = leitor.nextLine();
=======
            Item item = sistema.buscarPorTitulo(t);
            if (item != null) item.exibirHistorico(); // Implementação do histórico
            else System.out.println("[!] Item não localizado.");
        } else if (op == 2) {
            System.out.print("Editora: "); String ed = leitor.nextLine();
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
            sistema.buscarPorEditora(ed);
        }
    }

    private static void povoarDadosIniciais() {
<<<<<<< HEAD
        // dados pra não ficar vazio pra apresentar algo
        sistema.registrarPessoa(new Aluno("Joao Silva", "123"));
        sistema.registrarPessoa(new Professor("Prof. Fred", "456"));
        
        sistema.cadastrarNovoItem(new Livro("Java POO", "ifpb", "123", "ifpb", 20246, 1, "TI", 500, "Intro"));
        
        List<String> faixas = new ArrayList<>();
        faixas.add("Musica 1");
        sistema.cadastrarNovoItem(new CD("Album de Rock", "Sony", "Joao", faixas));
=======
        // Limpando e reinicializando o gerenciador para evitar duplicatas em tempo de execução
        sistema.registrarPessoa(new Aluno("Joao Silva", "123"));
        sistema.registrarPessoa(new Professor("Dr. Frederico", "456"));
        sistema.cadastrarNovoItem(new Livro("Java POO", "Pearson", "123", "Deitel", 2024, 1, "TI", 500, "Intro"));
        System.out.println("[SISTEMA] Dados carregados.");
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
    }
}