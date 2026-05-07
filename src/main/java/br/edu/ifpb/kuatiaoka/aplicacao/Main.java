package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.Aluno;
import br.edu.ifpb.kuatiaoka.modelo.Livro;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorBiblioteca sistema = new GerenciadorBiblioteca();
        Scanner leitor = new Scanner(System.in);
        
        // Criei um aluno e um livro de teste aqui so pra gente ver se agr funciona
        Aluno aluno = new Aluno("Joao Silva", "20241001");
        Livro livro = new Livro("Java: Como Programar", "Pearson", 2024, "ISBN-12345");
        
        // Colocando eles pra dentro do sistema
        sistema.registrarPessoa(aluno);
        sistema.cadastrarNovoItem(livro);

        int opcao = 0;

        // Esse loop segura o menu aberto ate a gente digitar 4 pra sair
        while (opcao != 4) {
            System.out.println("\n===== SISTEMA DA BIBLIOTECA =====");
            System.out.println("1. Listar tudo");
            System.out.println("2. Pegar emprestado");
            System.out.println("3. Devolver");
            System.out.println("4. Sair");
            System.out.print("O que quer fazer? ");
            
            opcao = leitor.nextInt();

            // Fiz com if/else pra ficar mais simples de entender
            if (opcao == 1) {
                sistema.mostrarTudo();
            } 
            else if (opcao == 2) {
                sistema.fazerEmprestimo(aluno, livro);
            } 
            else if (opcao == 3) {
                sistema.devolverItem(aluno, livro);
            } 
            else if (opcao == 4) {
                System.out.println("Fechando o programa...");
            } 
            else {
                System.out.println("Opcao errada, tenta de novo!");
            }
        }
        
        leitor.close();
    }
}