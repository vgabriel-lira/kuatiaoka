package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.Aluno;
import br.edu.ifpb.kuatiaoka.modelo.Livro;
import br.edu.ifpb.kuatiaoka.modelo.Revista;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorBiblioteca sistema = new GerenciadorBiblioteca();
        Scanner leitor = new Scanner(System.in);
        
        // criando um aluno (nome e matricula)
        Aluno aluno = new Aluno("Joao Silva", "20241001");
        
        // criando um livro com os mesmos campos q tem no pdf do prof
        // ordem: titulo, editora, isbn, autor, ano, edicao, genero, paginas, sinopse
        Livro livro = new Livro(
            "Java: Como Programar", 
            "Pearson", 
            "978-123", 
            "Deitel", 
            2024, 
            10, 
            "Educativo", 
            900, 
            "Um livro ensinando sobre Java"
        );
        
        // Colocando os dados no sistema pra gente testar
        sistema.registrarPessoa(aluno);
        sistema.cadastrarNovoItem(livro);

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n===== TESTE DA BIBLIOTECA =====");
            System.out.println("1. Listar tudo");
            System.out.println("2. Pegar emprestado");
            System.out.println("3. Devolver");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            
            opcao = leitor.nextInt();

            if (opcao == 1) {
                sistema.mostrarTudo();
            } 
            else if (opcao == 2) {
                // aqui o metodo fazer emprestimo q ta no gerenciador
                sistema.fazerEmprestimo(aluno, livro);
            } 
            else if (opcao == 3) {
                sistema.devolverItem(aluno, livro);
            } 
            else if (opcao == 4) {
                System.out.println("Saindo...");
            } 
            else {
                System.out.println("Opcao invalida!");
            }
        }
        leitor.close();
    }
}