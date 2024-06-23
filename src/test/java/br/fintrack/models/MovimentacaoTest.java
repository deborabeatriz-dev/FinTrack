package br.fintrack.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovimentacaoTest {

    private Movimentacao movimentacao;
    private User mockUser;

    @BeforeEach
    public void setUp() {
        mockUser = mock(User.class);
        movimentacao = new Movimentacao();
        movimentacao.setMovimentacaoId((short) 1);
        movimentacao.setDataMovimentacao(new Date());
        movimentacao.setValor(100.0f);
        movimentacao.setIdUsuario((short) 1);
        movimentacao.setUsuario(mockUser);
        movimentacao.setStatus("completed");
    }

    @Test
    public void testGetMovimentacaoId() {
        assertEquals((short) 1, movimentacao.getMovimentacaoId());
    }

    @Test
    public void testSetMovimentacaoId() {
        movimentacao.setMovimentacaoId((short) 2);
        assertEquals((short) 2, movimentacao.getMovimentacaoId());
    }

    @Test
    public void testGetDataMovimentacao() {
        Date date = new Date();
        movimentacao.setDataMovimentacao(date);
        assertEquals(date, movimentacao.getDataMovimentacao());
    }

    @Test
    public void testSetDataMovimentacao() {
        Date date = new Date();
        movimentacao.setDataMovimentacao(date);
        assertEquals(date, movimentacao.getDataMovimentacao());
    }

    @Test
    public void testGetValor() {
        assertEquals(100.0f, movimentacao.getValor());
    }

    @Test
    public void testSetValor() {
        movimentacao.setValor(200.0f);
        assertEquals(200.0f, movimentacao.getValor());
    }

    @Test
    public void testGetStatus() {
        assertEquals("completed", movimentacao.getStatus());
    }

    @Test
    public void testSetStatus() {
        movimentacao.setStatus("pending");
        assertEquals("pending", movimentacao.getStatus());
    }

    @Test
    public void testGetUsuario() {
        assertEquals(mockUser, movimentacao.getUsuario());
    }

    @Test
    public void testSetUsuario() {
        User anotherUser = mock(User.class);
        movimentacao.setUsuario(anotherUser);
        assertEquals(anotherUser, movimentacao.getUsuario());
    }

    @Test
    public void testGetIdUsuario() {
        assertEquals((short) 1, movimentacao.getIdUsuario());
    }

    @Test
    public void testSetIdUsuario() {
        movimentacao.setIdUsuario((short) 2);
        assertEquals((short) 2, movimentacao.getIdUsuario());
    }
}
