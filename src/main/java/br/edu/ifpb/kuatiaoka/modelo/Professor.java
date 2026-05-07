package br.edu.ifpb.kuatiaoka.modelo;

public class Professor extends Usuario {
    public Professor(String nome, String matricula) {
        super(nome, matricula, 5); // Prof pode ter ate 5 itens 
    }

    @Override
    public int getPrazoParaItem(Item item) {
        // se for livro o prof tem 14 dias pro resto é 7
        if (item instanceof Livro) {
            return 14;
        }
        return 7;
    }

    @Override
    public double getValorMultaDiaria() {
        return 1.0; // 1 real
    }
}