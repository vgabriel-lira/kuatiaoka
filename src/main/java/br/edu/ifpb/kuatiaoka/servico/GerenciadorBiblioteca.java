package br.edu.ifpb.kuatiaoka.servico;

import br.edu.ifpb.kuatiaoka.modelo.Item;
import br.edu.ifpb.kuatiaoka.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorBiblioteca {
    private List<Item> prateleira = new ArrayList<>();
    private List<Usuario> galera = new ArrayList<>();

    public void cadastrarNovoItem(Item item) {
        this.prateleira.add(item);
        System.out.println("Item adicionado: " + item.getTitulo());
    }

    public void registrarPessoa(Usuario usuario) {
        this.galera.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNome());
    }

    public void mostrarTudo() {
        System.out.println("\n--- Status do Acervo ---");
        for (Item i : prateleira) {
            String status = i.isEmprestado() ? "Emprestado" : "Disponivel";
            System.out.println("Titulo: " + i.getTitulo() + " | Status: " + status);
        }
    }

    public void fazerEmprestimo(Usuario user, Item item) {
        // Checa se o livro ja ta fora
        if (item.isEmprestado()) {
            System.out.println("Erro: O item ja esta emprestado.");
        } 
        // Checa o limite (3 para alunos)
        else if (user.getLivrosAtuais() >= user.getMaxLivros()) {
            System.out.println("Erro: Usuario atingiu o limite de livros.");
        } 
        else {
            // Se passar nos testes, efetiva o emprestimo
            item.setEstaEmprestado(true);
            user.setLivrosAtuais(user.getLivrosAtuais() + 1);
            System.out.println("Emprestimo realizado com sucesso!");
        }
    }

    public void devolverItem(Usuario user, Item item) {
        // aqui é pra só devolver se o item estiver realmente emprestado
        if (item.isEmprestado()) {
            item.setEstaEmprestado(false);
            user.setLivrosAtuais(user.getLivrosAtuais() - 1);
            System.out.println("Item devolvido com sucesso.");
        } else {
            System.out.println("Erro: Este item ja esta na biblioteca.");
        }
    }
}