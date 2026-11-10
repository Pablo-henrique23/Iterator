package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CadastroPacientes implements Iterable<Paciente> {
    private final List<Paciente> pacientes = new ArrayList<>();

    public void adicionar(Paciente paciente) {
        pacientes.add(Objects.requireNonNull(paciente));
    }

    @Override
    public Iterator<Paciente> iterator() {
        return new IteradorPacientes(pacientes);
    }
}
