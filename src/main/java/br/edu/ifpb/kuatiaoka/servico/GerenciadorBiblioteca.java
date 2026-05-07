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

    // Método solicitado pelo menu de usuários do Main
    public void listarUsuarios() {
        System.out.println("\n--- USUÁRIOS CADASTRADOS ---");
        for (Usuario u : galera) {
            String tipo = (u instanceof Aluno) ? "Aluno" : "Professor";
            System.out.println("- " + u.getNome() + " [" + tipo + "] | Mat: " + u.getMatricula());
        }
    }

    public void fazerEmprestimo(Usuario user, Item item) {
        if (user == null || item == null || !item.getStatus().equals("DISPONIVEL")) return;
        item.setStatus("EMPRESTADO");
        int dias = user.getPrazoParaItem(item);
        item.setDataDevolucaoPrevista(LocalDate.now().plusDays(dias));
        item.adicionarAoHistorico(LocalDate.now() + " - Emprestado para: " + user.getNome());
    }

    public void devolverItem(Usuario user, Item item) {
        if (item == null || !item.getStatus().equals("EMPRESTADO")) return;
        item.setStatus("DISPONIVEL");
        item.adicionarAoHistorico(LocalDate.now() + " - Devolvido por: " + user.getNome());
    }

    public Usuario buscarPorMatricula(String mat) {
        for (Usuario u : galera) if (u.getMatricula().equals(mat)) return u;
        return null;
    }

    public Item buscarPorTitulo(String t) {
        for (Item i : prateleira) if (i.getTitulo().equalsIgnoreCase(t)) return i;
        return null;
    }

    public void mostrarTudo() {
        for (Item i : prateleira) System.out.println(i.toString() + " [" + i.getStatus() + "]");
    }
    
    public void buscarPorEditora(String ed) {
        for (Item i : prateleira) if (i.getEditora().equalsIgnoreCase(ed)) System.out.println("- " + i.getTitulo());
    }
}