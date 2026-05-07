package br.edu.ifpb.kuatiaoka.modelo;

public class Aluno extends Usuario {

    public Aluno(String nome, String matricula) {
        // No "super" do Usuario, passamos o nome, matricula e o limite fixo de 3
        super(nome, matricula, 3);
    }
}