package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IteratorHospitalarTest {

    @Test
    void percorrePacientesNaOrdemDeCadastro() {
        CadastroPacientes cadastro = new CadastroPacientes();
        cadastro.adicionar(new Paciente("Ana", 101));
        cadastro.adicionar(new Paciente("Paulo", 102));
        List<String> nomes = new ArrayList<>();
        for (Paciente paciente : cadastro) {
            nomes.add(paciente.getNome());
        }
        assertEquals(List.of("Ana", "Paulo"), nomes);
    }

    @Test
    void hasNextAcompanhaProgresso() {
        CadastroPacientes cadastro = new CadastroPacientes();
        cadastro.adicionar(new Paciente("Ana", 101));
        Iterator<Paciente> it = cadastro.iterator();
        assertTrue(it.hasNext());
        assertEquals("Ana", it.next().getNome());
        assertFalse(it.hasNext());
    }

    @Test
    void nextAposFinalLancaExcecao() {
        Iterator<Paciente> it = new CadastroPacientes().iterator();
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void iteracaoVaziaNaoRetornaElementos() {
        int quantidade = 0;
        for (Paciente paciente : new CadastroPacientes()) {
            quantidade++;
        }
        assertEquals(0, quantidade);
    }

    @Test
    void doisIteradoresTemIndicesIndependentes() {
        CadastroPacientes cadastro = new CadastroPacientes();
        cadastro.adicionar(new Paciente("Ana", 101));
        cadastro.adicionar(new Paciente("Paulo", 102));
        Iterator<Paciente> primeiro = cadastro.iterator();
        Iterator<Paciente> segundo = cadastro.iterator();
        assertEquals("Ana", primeiro.next().getNome());
        assertEquals("Paulo", primeiro.next().getNome());
        assertEquals("Ana", segundo.next().getNome());
    }

    @Test
    void iteradorMantemCopiaDaListaNoMomentoDaCriacao() {
        CadastroPacientes cadastro = new CadastroPacientes();
        cadastro.adicionar(new Paciente("Ana", 101));
        Iterator<Paciente> original = cadastro.iterator();
        cadastro.adicionar(new Paciente("Paulo", 102));
        assertEquals("Ana", original.next().getNome());
        assertFalse(original.hasNext());
        assertEquals(2, contar(cadastro.iterator()));
    }

    @Test
    void cadastroRejeitaPacienteNulo() {
        CadastroPacientes cadastro = new CadastroPacientes();
        assertThrows(NullPointerException.class, () -> cadastro.adicionar(null));
    }

    @Test
    void pacienteExigeDadosValidos() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("", 101));
        assertThrows(IllegalArgumentException.class, () -> new Paciente("Ana", -1));
        assertEquals(202, new Paciente("Ana", 202).getNumeroQuarto());
    }

    private int contar(Iterator<Paciente> iterador) {
        int resultado = 0;
        while (iterador.hasNext()) {
            iterador.next();
            resultado++;
        }
        return resultado;
    }
}
