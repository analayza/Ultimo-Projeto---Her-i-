package Model;

import Interfaces.IFerramenta;

public class Heroi extends NomeHeroi implements IFerramenta {

    private final IFerramenta ferramenta;
    float nivelDeForca;
    float nivelDeVida;

    public Heroi(IFerramenta ferramenta) {
        this.ferramenta = ferramenta;
        this.nivelDeForca = 100;
        this.nivelDeVida = 100;
    }

    public float getNivelDeForca() {
        return nivelDeForca;
    }

    public void setNivelDeForca(float nivelDeForca) {
        this.nivelDeForca = nivelDeForca;
    }

    public float getNivelDeVida() {
        return nivelDeVida;
    }

    public void setNivelDeVida(float nivelDeVida) {
        this.nivelDeVida = nivelDeVida;
    }

    @Override
    public void usarFerramenta() {
        this.ferramenta.usarFerramenta();
    }
}
