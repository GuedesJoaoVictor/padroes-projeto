package br.ufsm.poli.csi.pp.examples.decorator;

public class ProductDecorator implements ProductProtocol {

    private final ProductProtocol product;

    public ProductDecorator(ProductProtocol product) {
        this.product = product;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }
}
