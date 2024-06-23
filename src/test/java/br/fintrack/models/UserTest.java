package br.fintrack.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId((short) 1);
        user.setEmail("test@example.com");
        user.setNome("Test User");
        user.setDataNascimento(new Date());
        user.setSenha("password");
    }

    @Test
    public void testGetId() {
        assertEquals((short) 1, user.getId());
    }

    @Test
    public void testSetId() {
        user.setId((short) 2);
        assertEquals((short) 2, user.getId());
    }

    @Test
    public void testGetEmail() {
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("new@example.com");
        assertEquals("new@example.com", user.getEmail());
    }

    @Test
    public void testGetNome() {
        assertEquals("Test User", user.getNome());
    }

    @Test
    public void testSetNome() {
        user.setNome("New User");
        assertEquals("New User", user.getNome());
    }

    @Test
    public void testGetDataNascimento() {
        Date newDate = new Date();
        user.setDataNascimento(newDate);
        assertEquals(newDate, user.getDataNascimento());
    }

    @Test
    public void testSetDataNascimento() {
        Date newDate = new Date();
        user.setDataNascimento(newDate);
        assertEquals(newDate, user.getDataNascimento());
    }

    @Test
    public void testGetSenha() {
        assertEquals("password", user.getSenha());
    }

    @Test
    public void testSetSenha() {
        user.setSenha("newpassword");
        assertEquals("newpassword", user.getSenha());
    }

    @Test
    public void testEquals() {
        User anotherUser = new User((short) 1, "test@example.com", "Test User", user.getDataNascimento());
        anotherUser.setSenha("password");
        assertTrue(user.equals(anotherUser));
    }

    @Test
    public void testNotEquals() {
        User anotherUser = new User((short) 2, "different@example.com", "Different User", user.getDataNascimento());
        anotherUser.setSenha("differentpassword");
        assertFalse(user.equals(anotherUser));
    }

    @Test
    public void testHashCode() {
        User anotherUser = new User((short) 1, "test@example.com", "Test User", user.getDataNascimento());
        anotherUser.setSenha("password");
        assertEquals(user.hashCode(), anotherUser.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "User{idUsuario=1, email='test@example.com', nome='Test User', dataNascimento=" + user.getDataNascimento() + ", senha=password}";
        assertEquals(expectedString, user.toString());
    }
}
