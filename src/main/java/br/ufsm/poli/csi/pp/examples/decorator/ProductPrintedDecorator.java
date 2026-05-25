package br.ufsm.poli.csi.pp.examples.decorator;

public class ProductPrintedDecorator extends ProductDecorator {

    public ProductPrintedDecorator(ProductProtocol product) {
        super(product);
    }

    @Override
    public String getName() {
        return super.getName() + " - Printed";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 10;
    }
}
