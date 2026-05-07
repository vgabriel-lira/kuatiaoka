package br.edu.ifpb.kuatiaoka.servico;

import br.edu.ifpb.kuatiaoka.modelo.Item;
import br.edu.ifpb.kuatiaoka.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorBiblioteca {
    // Nossas listas que funcionam como o "banco de dados" do programa
    private List<Item> prateleira = new ArrayList<>();
    private List<Usuario> galera = new ArrayList<>();

    // Método pra adicionar um livro ou revista no sistema
    public void cadastrarNovoItem(Item qualItem) {
        prateleira.add(qualItem);
        System.out.println("Pronto! '" + qualItem.getTitulo() + "' foi guardado na prateleira.");
    }

    // Método pra registrar os alunos e professores
    public void registrarPessoa(Usuario quem) {
        galera.add(quem);
        System.out.println("Pronto! " + quem.getNome() + " agora pode pegar livros.");
    }

    // Método simples só pra gente ver o que tem na biblioteca
    public void mostrarTudo() {
        System.out.println("\n--- O que temos hoje ---");
        for (Item i : prateleira) {
            String situacao = i.isEmprestado() ? "[Indisponível]" : "[Livre]";
            System.out.println("- " + i.getTitulo() + " " + situacao);
        }
    }
}