package br.edu.ifpb.kuatiaoka.servico;

import br.edu.ifpb.kuatiaoka.modelo.Item;
import br.edu.ifpb.kuatiaoka.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorBiblioteca {
    // aqui as listas que funcionam como o "banco de dados" 
    private List<Item> prateleira = new ArrayList<>();
    private List<Usuario> galera = new ArrayList<>();

    // Método pra adicionar um livro no sistema
    public void cadastrarNovoItem(Item qualItem) {
        prateleira.add(qualItem);
        System.out.println("Pronto! '" + qualItem.getTitulo() + "' foi guardado na prateleira.");
    }

    // Método pra registrar alunos e professores
    public void registrarPessoa(Usuario quem) {
        galera.add(quem);
        System.out.println("Pronto! " + quem.getNome() + " agora pode pegar livros.");
    }

    // Método simples pra mostrar o que tem no acervo e se está livre
    public void mostrarTudo() {
        System.out.println("\n--- O QUE TEMOS HOJE ---");
        for (Item i : prateleira) {
            // Se o item estiver emprestado, mostra indisponível, senão mostra livre
            String situacao = i.isEmprestado() ? "[Indisponível]" : "[Livre]";
            System.out.println("- " + i.getTitulo() + " " + situacao);
        }
    }

    // aqui é a lógica do empréstimo
    public void fazerEmprestimo(Usuario user, Item item) {
        
        // Primeiro checa se o livro já não está com outra pessoa
        if (item.isEmprestado()) {
            System.out.println("Putz, o livro '" + item.getTitulo() + "' ja esta com alguem.");
        } 
        
        // Dps checa se o usuário (aluno ou prof) já atingiu o limite dele
        else if (user.getLivrosAtuais() >= user.getMaxLivros()) {
            System.out.println("Opa, " + user.getNome() + " ja atingiu o limite de " + user.getMaxLivros() + " livros.");
        } 
        
        // dps se passou pelos testes a gente confirma o empréstimo
        else {
            // aqui muda o status do livro para ocupado
            item.setEstaEmprestado(true);
            
            // aqui atualiza quantos livros o usuário ta segurando agr
            int totalNovo = user.getLivrosAtuais() + 1;
            user.setLivrosAtuais(totalNovo);
            
            System.out.println("Sucesso! Emprestimo de '" + item.getTitulo() + "' realizado para " + user.getNome());
        }
    }
}