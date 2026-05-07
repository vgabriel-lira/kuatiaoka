package br.edu.ifpb.kuatiaoka.modelo;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public abstract class Item {
    
    // ========== ATRIBUTOS ==========
    private String titulo;
    private String editora;
    private String status = "DISPONIVEL";
    private LocalDate dataDevolucaoPrevista;
    private List<String> historico = new ArrayList<>();
<<<<<<< HEAD

    public Item(String titulo, String editora) {
        this.titulo = titulo;
        this.editora = editora;
    }

    public void exibirHistorico() {
        System.out.println("\n--- HISTÓRICO DE: " + titulo.toUpperCase() + " ---");
        if (historico.isEmpty()) {
            System.out.println("Nenhum registro de movimentação.");
        } else {
            for (String registro : historico) {
                System.out.println(registro);
            }
        }
    }

    public void adicionarAoHistorico(String entrada) {
        this.historico.add(entrada);
    }

    // getters e setters
    public String getTitulo() { return titulo; }
    public String getEditora() { return editora; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public void setDataDevolucaoPrevista(LocalDate d) { this.dataDevolucaoPrevista = d; }
=======
    
    // ========== CONSTRUTOR ==========
    public Item(String titulo, String editora) {
        this.titulo = titulo;
        this.editora = editora;
    }
    
    // ========== MÉTODOS DE HISTÓRICO ==========
    
    public void exibirHistorico() {
        System.out.println("\n--- HISTÓRICO DE: " + titulo.toUpperCase() + " ---");
        
        if (historico.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
        } else {
            for (String registro : historico) {
                System.out.println(registro);
            }
        }
    }
    
    public void adicionarAoHistorico(String entrada) {
        this.historico.add(entrada);
    }
    
    // ========== GETTERS E SETTERS ==========
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getEditora() {
        return editora;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }
    
    public void setDataDevolucaoPrevista(LocalDate data) {
        this.dataDevolucaoPrevista = data;
    }
}
>>>>>>> 37c5103112737dc272dfa1a8d94db60f6e12891a
}