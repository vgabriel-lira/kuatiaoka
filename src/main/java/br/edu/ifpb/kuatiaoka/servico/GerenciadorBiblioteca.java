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
    public void registrarPessoa(Usuario u) { this.galera.add(u); }

    public void listarUsuarios() {
        System.out.println("\n--- USUÁRIOS NO SISTEMA ---");
        for (Usuario u : galera) {
            String tipo = (u instanceof Aluno) ? "Aluno" : "Professor";
            System.out.println("- " + u.getNome() + " [" + tipo + "] | Matrícula: " + u.getMatricula());
        }
    }

    public void fazerEmprestimo(Usuario u, Item i) {
        if (u == null || i == null) {
            System.out.println("[!] Erro: Utilizador ou Item não encontrado.");
            return;
        }
        if (!i.getStatus().equals("DISPONIVEL")) {
            System.out.println("[!] Item já se encontra emprestado.");
            return;
        }
        i.setStatus("EMPRESTADO");
        int dias = u.getPrazoParaItem(i);
        i.setDataDevolucaoPrevista(LocalDate.now().plusDays(dias));
        i.adicionarAoHistorico(LocalDate.now() + " - Emprestado a: " + u.getNome());
        System.out.println("Sucesso! Devolução prevista: " + i.getDataDevolucaoPrevista());
    }

    public void devolverItem(Usuario u, Item i) {
        if (i == null || !i.getStatus().equals("EMPRESTADO")) {
            System.out.println("[!] Erro na devolução.");
            return;
        }
        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(i.getDataDevolucaoPrevista())) {
            long dias = ChronoUnit.DAYS.between(i.getDataDevolucaoPrevista(), hoje);
            System.out.println("Atraso de " + dias + " dias. Multa: R$ " + (dias * 2.0));
        }
        i.setStatus("DISPONIVEL");
        i.adicionarAoHistorico(hoje + " - Devolvido por: " + (u != null ? u.getNome() : "Desconhecido"));
        System.out.println("Devolução concluída.");
    }

    public Usuario buscarPorMatricula(String m) {
        for (Usuario u : galera) if (u.getMatricula().equals(m)) return u;
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