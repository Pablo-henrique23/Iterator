package org.example;

public class Paciente {
    private final String nome;
    private final int numeroQuarto;

    public Paciente(String nome, int numeroQuarto) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatorio");
        }
        if (numeroQuarto <= 0) {
            throw new IllegalArgumentException("Numero do quarto invalido");
        }
        this.nome = nome;
        this.numeroQuarto = numeroQuarto;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }
}
