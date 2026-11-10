package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IteradorPacientes implements Iterator<Paciente> {
    private final List<Paciente> pacientes;
    private int indice = 0;

    public IteradorPacientes(List<Paciente> pacientes) {
        this.pacientes = List.copyOf(pacientes);
    }

    @Override
    public boolean hasNext() {
        return indice < pacientes.size();
    }

    @Override
    public Paciente next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Nao existem mais pacientes");
        }
        return pacientes.get(indice++);
    }
}
