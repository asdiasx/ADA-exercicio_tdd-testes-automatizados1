package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarroServiceImplTest {

    private Carro carroTeste;
    private CarroServiceImpl carroService;

    @Before
    public void setup() {
        carroTeste = new Carro("Azul", "Fiat", "Uno", 2015, 150);
        carroService = new CarroServiceImpl();
    }


    @Test
    public void devePoderLigarQuandoDesligado() {
        carroTeste.setLigado(false);

        carroService.ligar(carroTeste);

        assertTrue(carroTeste.isLigado());
    }

    @Test
    public void devePoderMostrarEstadoAtualQuandoDesligado() {
        carroTeste.setLigado(false);

        String estado = carroService.estadoAtual(carroTeste);

        assertEquals("Desligado", estado);
    }

    @Test
    public void devePoderDesligarQuandoLigado() {
        carroTeste.setLigado(true);

        carroService.desligar(carroTeste);

        assertFalse(carroTeste.isLigado());
    }

    @Test
    public void devePoderAcelerarQuandoLigado() {
        carroTeste.setLigado(true);
        carroTeste.setVelocidadeAtual(100);

        carroService.acelerar(carroTeste, 11);

        assertEquals(111, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void devePoderFrearQuandoLigado() {
        carroTeste.setLigado(true);
        carroTeste.setVelocidadeAtual(100);

        carroService.frear(carroTeste, 10);

        assertEquals(90, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void devePoderMostrarEstadoAtualQuandoLigado() {
        carroTeste.setLigado(true);

        String estado = carroService.estadoAtual(carroTeste);

        assertEquals("Ligado", estado);
    }

    @Test
    public void somenteAceleraQuandoLigado() {
        carroTeste.setLigado(false);
        carroTeste.setVelocidadeAtual(100);

        carroService.acelerar(carroTeste, 10);

        assertEquals(100, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void somenteFreiaQuandoLigado() {
        carroTeste.setLigado(false);
        carroTeste.setVelocidadeAtual(100);

        carroService.frear(carroTeste, 10);

        assertEquals(100, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void somenteDesligaQuandoParado() {
        carroTeste.setLigado(true);
        carroTeste.setVelocidadeAtual(100);

        carroService.desligar(carroTeste);

        assertTrue(carroTeste.isLigado());
    }

    @Test
    public void naoExisteVelocidadeNegativa() {
        carroTeste.setLigado(true);
        carroTeste.setVelocidadeAtual(10);

        carroService.frear(carroTeste, 11);

        assertEquals(0, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void naoUltrapassaVelocidadeMaxima() {
        carroTeste.setLigado(true);
        carroTeste.setVelocidadeAtual(150);

        carroService.acelerar(carroTeste, 1);

        assertEquals(150, carroTeste.getVelocidadeAtual());
    }

///////// TESTES VINDOS DO REPOSITÓRIO ///////

    @Test
    public void deveAcelerarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carroTeste = new Carro("Azul", "Fiat", "Uno", 2015, 150);
        carroService.ligar(carroTeste);

        // When
        carroService.acelerar(carroTeste, 10);

        // Then
        // Assertivas
        // O Junit busca por Asserts no método para validar que o teste passou
        Assert.assertEquals(10, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        // Dado
        Carro carro =
                new Carro("vermelho", "marca", "modelo", 1990, 100);

        // Quando
        carroService.ligar(carro);

        // Então
        Assert.assertTrue(carro.isLigado());
    }

    @Test
    public void velocidadeNaoDeveSerMenorQueZero() {
        // O Junit busca por Assets no método para validar que o teste passou

        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);
        carroService.ligar(celtinha); // velocidade zero

        // Quando:
        carroService.frear(celtinha, 10);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamenteEAcelerarCorretamente() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);

        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 10);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(10, celtinha.getVelocidadeAtual());
    }

}
