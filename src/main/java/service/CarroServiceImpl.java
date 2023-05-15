package service;

import model.Carro;

public class CarroServiceImpl implements CarroService {

    @Override
    public void acelerar(Carro carro, int velocidadeAMais) {
        int velocidadeFinal = Math.min(carro.getVelocidadeAtual() + velocidadeAMais, carro.getVelocidadeMaxima());
        if (carro.isLigado()) carro.setVelocidadeAtual(velocidadeFinal);
    }

    @Override
    public void frear(Carro carro, int velocidadeAMenos) {
        int velocidadeFinal = Math.max(carro.getVelocidadeAtual() - velocidadeAMenos, 0);
        if (carro.isLigado()) carro.setVelocidadeAtual(velocidadeFinal);
    }

    @Override
    public void ligar(Carro carro) {
        carro.setLigado(true);
    }

    @Override
    public void desligar(Carro carro) {
        if (carro.getVelocidadeAtual() == 0) carro.setLigado(false);
    }

    @Override
    public String estadoAtual(Carro carro) {
        return carro.isLigado() ? "Ligado" : "Desligado";
    }
}
