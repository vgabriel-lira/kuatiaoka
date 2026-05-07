package br.edu.ifpb.kuatiaoka.servico;

import br.edu.ifpb.kuatiaoka.modelo.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorBiblioteca {
    
    private List<Item> prateleira = new ArrayList<>();
    private List<Usuario> galera = new ArrayList<>();
<<<<<<< HEAD

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
=======
    
    // ========== MÉTODOS DE CADASTRO ==========
    
    public void cadastrarNovoItem(Item item) {
        this.prateleira.add(item);
    }
    
    public void registrarPessoa(Usuario usuario) {
        this.galera.add(usuario);
    }
    
    // ========== MÉTODOS DE LISTAGEM ==========
    
    public void listarUsuarios() {
        System.out.println("\n--- LISTA DE USUÁRIOS CADASTRADOS ---");
        
        if (galera.isEmpty()) {
            System.out.println("Nenhum usuário no sistema.");
        } else {
            for (Usuario u : galera) {
                String tipo = (u instanceof Aluno) ? "Aluno" : "Professor";
                System.out.println("- " + u.getNome() + " [" + tipo + "] | Matrícula: " + u.getMatricula());
            }
        }
    }
    
    public void mostrarTudo() {
        System.out.println("\n--- LISTAGEM DO ACERVO ---");
        
        for (Item i : prateleira) {
            System.out.println(i.toString() + " [" + i.getStatus() + "]");
        }
    }
    
    // ========== MÉTODOS DE BUSCA ==========
    
    public Usuario buscarPorMatricula(String mat) {
        for (Usuario u : galera) {
            if (u.getMatricula().equals(mat)) {
                return u;
            }
        }
        return null;
    }
    
    public Item buscarPorTitulo(String titulo) {
        for (Item i : prateleira) {
            if (i.getTitulo().equalsIgnoreCase(titulo)) {
                return i;
            }
        }
        return null;
    }
    
    public void buscarPorEditora(String editora) {
        System.out.println("\nResultados para editora: " + editora);
        
        boolean encontrou = false;
        for (Item i : prateleira) {
            if (i.getEditora().equalsIgnoreCase(editora)) {
                System.out.println("- " + i.getTitulo() + " [" + i.getStatus() + "]");
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhum item encontrado.");
        }
    }
    
    // ========== MÉTODOS DE OPERAÇÃO ==========
    
    public void fazerEmprestimo(Usuario user, Item item) {
        // Validações
        if (user == null || item == null) {
            System.out.println("Erro: Usuario ou Item nao encontrado.");
            return;
        }
        
        if (!item.getStatus().equals("DISPONIVEL")) {
            System.out.println("Erro: Item indisponivel (" + item.getStatus() + ").");
            return;
        }
        
        if (user.getSaldoMulta() > 0) {
            System.out.println("Erro: Usuario possui multas pendentes (R$ " + user.getSaldoMulta() + ").");
            return;
        }
        
        // Realizar empréstimo
        item.setStatus("EMPRESTADO");
        user.setLivrosAtuais(user.getLivrosAtuais() + 1);
        
        int dias = user.getPrazoParaItem(item);
        item.setDataDevolucaoPrevista(LocalDate.now().plusDays(dias));
        item.adicionarAoHistorico(LocalDate.now() + " - Emprestado para: " + user.getNome());
        
        System.out.println("Emprestimo realizado! Devolucao ate: " + item.getDataDevolucaoPrevista());
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
    }
    
    public void devolverItem(Usuario user, Item item) {
<<<<<<< HEAD
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
=======
        if (item == null || !item.getStatus().equals("EMPRESTADO")) {
            System.out.println("Erro: Este item nao consta como emprestado.");
            return;
        }
        
        LocalDate hoje = LocalDate.now();
        
        // Verificar atraso e aplicar multa
        if (hoje.isAfter(item.getDataDevolucaoPrevista())) {
            long diasAtraso = ChronoUnit.DAYS.between(item.getDataDevolucaoPrevista(), hoje);
            double valorMulta = diasAtraso * user.getValorMultaDiaria();
            
            user.setSaldoMulta(user.getSaldoMulta() + valorMulta);
            user.setStatusMulta("PENDENTE");
            
            System.out.println("Atraso de " + diasAtraso + " dias! Multa aplicada: R$ " + valorMulta);
        }
        
        // Realizar devolução
        item.setStatus("DISPONIVEL");
        user.setLivrosAtuais(user.getLivrosAtuais() - 1);
        item.adicionarAoHistorico(hoje + " - Devolvido por: " + user.getNome());
        
        System.out.println("Item devolvido com sucesso!");
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
    }
}