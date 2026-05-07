package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.Aluno;
import br.edu.ifpb.kuatiaoka.modelo.Livro;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorBiblioteca sistema = new GerenciadorBiblioteca();
        Scanner leitor = new Scanner(System.in);

        // dados pro teste n abrir vazio
        Aluno alunoTeste = new Aluno("Joao Silva", "20241001");
        
        Livro livroTeste = new Livro(
            "Java: Como Programar", "Pearson", "978-123", "Deitel", 
            2024, 10, "Educativo", 900, "Livro base de POO"
        );
        
        sistema.registrarPessoa(alunoTeste);
        sistema.cadastrarNovoItem(livroTeste);

        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n===== BIBLIOTECA KUATIAOKA =====");
            System.out.println("1. Listar Acervo");
            System.out.println("2. Fazer Emprestimo");
            System.out.println("3. Devolver Item");
            System.out.println("4. Ver Itens em Atraso");
            System.out.println("5. Buscar Livro (ISBN)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = leitor.nextInt();
            leitor.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    sistema.mostrarTudo();
                    break;
                case 2:
                    System.out.print("Digite a Matricula: ");
                    String mat = leitor.nextLine();
                    System.out.print("Digite o Titulo do Item: ");
                    String tit = leitor.nextLine();
                    sistema.fazerEmprestimo(sistema.buscarPorMatricula(mat), sistema.buscarItemPorTitulo(tit));
                    break;
                case 3:
                    System.out.print("Matricula: ");
                    String m = leitor.nextLine();
                    System.out.print("Titulo: ");
                    String t = leitor.nextLine();
                    sistema.devolverItem(sistema.buscarPorMatricula(m), sistema.buscarItemPorTitulo(t));
                    break;
                case 4:
                    sistema.listarItensEmAtraso();
                    break;
                case 5:
                    System.out.print("ISBN: ");
                    String isbn = leitor.nextLine();
                    sistema.buscarPorISBN(isbn);
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
        leitor.close();
    }
}