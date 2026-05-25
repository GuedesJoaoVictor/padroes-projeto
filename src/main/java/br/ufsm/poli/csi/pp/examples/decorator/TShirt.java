package br.ufsm.poli.csi.pp.examples.decorator;

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
