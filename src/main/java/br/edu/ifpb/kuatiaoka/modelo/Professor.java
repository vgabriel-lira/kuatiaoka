package br.edu.ifpb.kuatiaoka.modelo;

public class Professor extends Usuario {

    public Professor(String nome, String matricula) {
        // limite de 5 no super pq é professor
        super(nome, matricula, 5);
    }
}