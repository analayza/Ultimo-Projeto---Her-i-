package Model;

import Interfaces.IFerramenta;

public class Escudo implements IFerramenta {
    @Override
    public void usarFerramenta() {
        System.out.println("Investiu com o escudo no capitalista safado");
    }
}
