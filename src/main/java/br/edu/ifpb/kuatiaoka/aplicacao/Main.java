package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.*;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.*;

public class Main {
    private static GerenciadorBiblioteca sistema = new GerenciadorBiblioteca();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializa o sistema com dados para testes
        povoarDadosIniciais();

        int opcao = 0;
        do {
            try {
                exibirMenuPrincipal();
                opcao = leitor.nextInt();
                leitor.nextLine(); // Limpa o buffer

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
                leitor.nextLine(); // Descarta a entrada inválida
                opcao = 0;
            }
        } while (opcao != 5);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("      SISTEMA BIBLIOTECA KUATIAOKA      ");
        System.out.println("========================================");
        System.out.println(" [1] Gerenciar Itens (Livro, CD, DVD...)");
        System.out.println(" [2] Gerenciar Usuários (Aluno, Prof)");
        System.out.println(" [3] Operações (Empréstimo/Devolução)");
        System.out.println(" [4] Consultas e Históricos");
        System.out.println(" [5] Sair");
        System.out.println("========================================");
        System.out.print("Escolha: ");
    }

    private static void menuGerenciarItens() {
        System.out.println("\n--- GERENCIAR ITENS (UC1) ---");
        System.out.println("1. Listar Acervo");
        System.out.println("2. Cadastrar Novo Livro");
        System.out.println("3. Cadastrar Novo CD");
        System.out.println("4. Cadastrar Novo DVD");
        System.out.println("5. Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); 
        leitor.nextLine();

        switch (op) {
            case 1:
                sistema.mostrarTudo();
                break;
            case 2:
                System.out.print("Título: "); String t = leitor.nextLine();
                System.out.print("Editora: "); String ed = leitor.nextLine();
                System.out.print("Autor: "); String au = leitor.nextLine();
                sistema.cadastrarNovoItem(new Livro(t, ed, "999", au, 2024, 1, "Geral", 100, "S/S"));
                System.out.println("Livro cadastrado!");
                break;
            case 3:
                System.out.print("Título: "); String tc = leitor.nextLine();
                System.out.print("Artista: "); String art = leitor.nextLine();
                sistema.cadastrarNovoItem(new CD(tc, "Independente", art, new ArrayList<>()));
                System.out.println("CD cadastrado!");
                break;
            case 4:
                System.out.print("Título: "); String td = leitor.nextLine();
                System.out.print("Diretor: "); String dir = leitor.nextLine();
                sistema.cadastrarNovoItem(new DVD(td, "S/E", dir, 120, "Livre"));
                System.out.println("DVD cadastrado!");
                break;
        }
    }

    private static void menuGerenciarUsuarios() {
        System.out.println("\n--- GERENCIAR USUÁRIOS (UC2) ---");
        System.out.println("1. Listar Usuários");
        System.out.println("2. Cadastrar Novo Aluno");
        System.out.println("3. Cadastrar Novo Professor");
        System.out.println("4. Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); 
        leitor.nextLine();

        if (op == 1) {
            sistema.listarUsuarios();
        } else if (op == 2 || op == 3) {
            System.out.print("Nome: "); String nome = leitor.nextLine();
            System.out.print("Matrícula: "); String mat = leitor.nextLine();
            
            if (op == 2) sistema.registrarPessoa(new Aluno(nome, mat));
            else sistema.registrarPessoa(new Professor(nome, mat));
            
            System.out.println("Usuário registrado!");
        }
    }

    private static void menuOperacoes() {
        System.out.println("\n--- OPERAÇÕES (UC3/UC4) ---");
        System.out.println("1. Empréstimo");
        System.out.println("2. Devolução");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); 
        leitor.nextLine();
        
        System.out.print("Matrícula: "); String mat = leitor.nextLine();
        System.out.print("Título do Item: "); String tit = leitor.nextLine();
        
        if (op == 1) {
            sistema.fazerEmprestimo(sistema.buscarPorMatricula(mat), sistema.buscarPorTitulo(tit));
        } else {
            sistema.devolverItem(sistema.buscarPorMatricula(mat), sistema.buscarPorTitulo(tit));
        }
    }

    private static void menuConsultas() {
        System.out.println("\n--- CONSULTAS ---");
        System.out.println("1. Ver Histórico de Item (UC6)");
        System.out.println("2. Buscar por Editora (UC5)");
        System.out.println("3. Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); 
        leitor.nextLine();

        if (op == 1) {
            System.out.print("Título: "); String t = leitor.nextLine();
            Item item = sistema.buscarPorTitulo(t);
            if (item != null) item.exibirHistorico();
            else System.out.println("Item não encontrado.");
        } else if (op == 2) {
            System.out.print("Editora: "); String ed = leitor.nextLine();
            sistema.buscarPorEditora(ed);
        }
    }

    private static void povoarDadosIniciais() {
        sistema.registrarPessoa(new Aluno("Joao Silva", "123"));
        sistema.registrarPessoa(new Professor("Dr. Frederico", "456"));
        sistema.cadastrarNovoItem(new Livro("Java POO", "Pearson", "123", "Deitel", 2024, 1, "TI", 500, "Intro"));
    }
}