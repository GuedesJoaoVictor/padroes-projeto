package br.ufsm.poli.csi.pp.examples.decorator;

/**
 * Concrete Product
 * Here we have a concrete product that implements the ProductProtocol interface
 * @author gue10
 * */
public class TShirt implements ProductProtocol {

    @Override
    public String getName() {
        return "T-Shirt";
    }

    @Override
    public double getPrice() {
        return 49.90;
    }

}
