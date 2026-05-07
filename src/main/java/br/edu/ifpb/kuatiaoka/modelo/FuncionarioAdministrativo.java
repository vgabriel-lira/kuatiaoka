package br.edu.ifpb.kuatiaoka.modelo;

public class FuncionarioAdministrativo extends Usuario {
    public FuncionarioAdministrativo(String nome, String matricula) {
        super(nome, matricula, 2); // Limite de 2 itens 
    }

    @Override
    public int getPrazoParaItem(Item item) {
        return 10; // 10 dias de prazo pro funcionario
    }

    @Override
    public double getValorMultaDiaria() {
        return 1.5; // Multa de 1,50
    }
}