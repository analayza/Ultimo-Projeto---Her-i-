package Model;

import Interfaces.IBolsa;

import java.util.HashMap;

public class Bolsa implements IBolsa {

    HashMap<Integer, Object> bolsa = new HashMap<>();


    @Override
    public void put(Integer i, Object v) {
        bolsa.put(i,v);
    }

    @Override
    public void remove(Integer i) {
        bolsa.remove(i);
    }

    @Override
    public Object utilizarItem(Integer i) {
        return bolsa.get(i);
    }

    @Override
    public int tamanho() {
        return bolsa.size();
    }

    @Override
    public String toString() {
        return "Bolsa" + bolsa;
    }
}
