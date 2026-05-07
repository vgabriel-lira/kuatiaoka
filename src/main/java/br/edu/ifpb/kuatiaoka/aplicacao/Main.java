package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.Aluno;
import br.edu.ifpb.kuatiaoka.modelo.Livro;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando o sistema e o leitor do teclado
        GerenciadorBiblioteca sistema = new GerenciadorBiblioteca();
        Scanner leitor = new Scanner(System.in);
        
        // aqui cadastrar um livro e um aluno de teste para não abrir vazio
        Aluno alunoTeste = new Aluno("Seu Nome", "202401");
        Livro livroTeste = new Livro("Java para Iniciantes", "Editora IFPB", 2024, "978-123");
        
        sistema.registrarPessoa(alunoTeste);
        sistema.cadastrarNovoItem(livroTeste);

        int escolha = 0;

        // O loop que segura o programa aberto até escolher sair
        while (escolha != 3) {
            System.out.println("\n--- SISTEMA BIBLIOTECA KUATIAOKA ---");
            System.out.println("1. Olhar prateleira");
            System.out.println("2. Pegar livro emprestado (Teste)");
            System.out.println("3. Sair do programa");
            System.out.print("O que deseja fazer? ");
            
            escolha = leitor.nextInt();
            leitor.nextLine(); // Limpa o enter que sobra no teclado

            if (escolha == 1) {
                sistema.mostrarTudo();
            } 
            else if (escolha == 2) {
                // Aqui a gente testa a lógica que ta no Gerenciador
                sistema.fazerEmprestimo(alunoTeste, livroTeste);
            } 
            else if (escolha == 3) {
                System.out.println("Valeu! Encerrando o sistema...");
            } 
            else {
                System.out.println("Opção inválida, tenta de novo!");
            }
        }
        
        leitor.close(); // Fecha o teclado pra economizar memória
    }
}