package Model;

import Interfaces.IFerramenta;

public class Espada implements IFerramenta {
    @Override
    public void usarFerramenta() {
        System.out.println("Golpeia com o poder da militancia");
    }
}
