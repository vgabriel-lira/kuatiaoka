package br.edu.ifpb.kuatiaoka.servico;

import br.edu.ifpb.kuatiaoka.modelo.Item;
import br.edu.ifpb.kuatiaoka.modelo.Livro;
import br.edu.ifpb.kuatiaoka.modelo.Usuario;
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
        if (!item.getStatus().equals("DISPONIVEL")) {
            System.out.println("Erro: Item indisponivel.");
            return;
        }
        if (user.getStatusMulta().equals("PENDENTE")) {
            System.out.println("Erro: Usuario com multa pendente.");
            return;
        }
        if (user.getLivrosAtuais() >= user.getMaxLivros()) {
            System.out.println("Erro: Limite de itens atingido.");
            return;
        }

        item.setStatus("EMPRESTADO");
        user.setLivrosAtuais(user.getLivrosAtuais() + 1);
        
        // aqui pro sistema perguntar o prazo pro tipo de usuario
        int dias = user.getPrazoParaItem(item);
        item.setDataDevolucaoPrevista(LocalDate.now().plusDays(dias));

        System.out.println("Emprestimo feito! Devolver ate: " + item.getDataDevolucaoPrevista());
    }

    public void devolverItem(Usuario user, Item item) {
        if (item.getStatus().equals("EMPRESTADO")) {
            LocalDate hoje = LocalDate.now();
            LocalDate prazo = item.getDataDevolucaoPrevista();
            long diasAtraso = ChronoUnit.DAYS.between(prazo, hoje);

            if (diasAtraso > 0) {
                // e aqui pro sistema pegar o valor da multa direto do usuario tbm
                double valorMulta = diasAtraso * user.getValorMultaDiaria();
                user.setSaldoMulta(user.getSaldoMulta() + valorMulta);
                user.setStatusMulta("PENDENTE");
                System.out.println("Atraso de " + diasAtraso + " dias! Multa: R$ " + valorMulta);
            }

            item.setStatus("DISPONIVEL");
            item.setDataDevolucaoPrevista(null);
            user.setLivrosAtuais(user.getLivrosAtuais() - 1);
            System.out.println("Devolucao OK.");
        }
    }

    public void mostrarTudo() {
        for (Item i : prateleira) {
            System.out.println("Titulo: " + i.getTitulo() + " | Status: " + i.getStatus());
        }
    }
    // busca por ISBN
    public void buscarPorISBN(String isbn) {
        for (Item i : prateleira) {
            // Aqui a gente faz um cast para Livro, pois só livro tem ISBN
            if (i instanceof Livro) {
                Livro l = (Livro) i;
                if (l.getIsbn().equals(isbn)) {
                    System.out.println("Achei o livro: " + l.getTitulo());
                    return;
                }
            }
        }
        System.out.println("Item com ISBN " + isbn + " nao encontrado.");
    }

    // busca pela matricula
    public void buscarUsuario(String matricula) {
        for (Usuario u : galera) {
            if (u.getMatricula().equals(matricula)) {
                System.out.println("Usuario encontrado: " + u.getNome() + " | Multas: R$ " + u.getSaldoMulta());
                return;
            }
        }
        System.out.println("Usuario nao cadastrado.");
    }

    // filtrar os itens emprestados
    public void listarEmprestimosAtivos() {
        System.out.println("\n--- Itens Fora da Biblioteca ---");
        for (Item i : prateleira) {
            if (i.getStatus().equals("EMPRESTADO")) {
                System.out.println("Item: " + i.getTitulo() + " | Devolucao em: " + i.getDataDevolucaoPrevista());
            }
        }
    }
}