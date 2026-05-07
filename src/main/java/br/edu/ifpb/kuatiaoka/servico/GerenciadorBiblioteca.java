package br.edu.ifpb.kuatiaoka.servico;

import br.edu.ifpb.kuatiaoka.modelo.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorBiblioteca {
    private List<Item> prateleira = new ArrayList<>();
    private List<Usuario> galera = new ArrayList<>();

    public void cadastrarNovoItem(Item item) { this.prateleira.add(item); }
    public void registrarPessoa(Usuario usuario) { this.galera.add(usuario); }

    public void fazerEmprestimo(Usuario user, Item item) {
        if (user == null || item == null) {
            System.out.println("Erro: Usuario ou Item nao encontrado.");
            return;
        }
        if (!item.getStatus().equals("DISPONIVEL")) {
            System.out.println("Erro: Item indisponivel.");
            return;
        }
        // logica do empréstimo
        item.setStatus("EMPRESTADO");
        user.setLivrosAtuais(user.getLivrosAtuais() + 1);
        int dias = user.getPrazoParaItem(item);
        item.setDataDevolucaoPrevista(LocalDate.now().plusDays(dias));
        System.out.println("Emprestimo realizado com sucesso!");
    }

    public void devolverItem(Usuario user, Item item) {
        if (item != null && item.getStatus().equals("EMPRESTADO")) {
            item.setStatus("DISPONIVEL");
            user.setLivrosAtuais(user.getLivrosAtuais() - 1);
            System.out.println("Item devolvido!");
        }
    }

    public Usuario buscarPorMatricula(String mat) {
        for (Usuario u : galera) {
            if (u.getMatricula().equals(mat)) return u;
        }
        return null;
    }

    public Item buscarItemPorTitulo(String titulo) {
        for (Item i : prateleira) {
            if (i.getTitulo().equalsIgnoreCase(titulo)) return i;
        }
        return null;
    }

    public void buscarPorISBN(String isbn) {
        for (Item i : prateleira) {
            if (i instanceof Livro && ((Livro) i).getIsbn().equals(isbn)) {
                System.out.println("Achei: " + i.getTitulo());
                return;
            }
        }
        System.out.println("ISBN nao encontrado.");
    }

    public void listarItensEmAtraso() {
        System.out.println("Verificando atrasos...");
    }

    public void mostrarTudo() {
        for (Item i : prateleira) {
            System.out.println(i.getTitulo() + " [" + i.getStatus() + "]");
        }
    }
}