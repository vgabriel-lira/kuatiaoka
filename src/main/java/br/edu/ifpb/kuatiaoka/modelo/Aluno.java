package br.edu.ifpb.kuatiaoka.modelo;

public class Aluno extends Usuario {
    public Aluno(String nome, String matricula) {
        super(nome, matricula, 3); // tu segue essa logica aqui dos comentarios nos outros, aqui é o limite dos itens
    }

    @Override
    public int getPrazoParaItem(Item item) {
        return 7; // os 7 dias
    }

    @Override
    public double getValorMultaDiaria() {
        return 2.0; // 2 reais por dia 
    }
}