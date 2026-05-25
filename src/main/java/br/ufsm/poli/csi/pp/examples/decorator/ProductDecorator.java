package br.ufsm.poli.csi.pp.examples.decorator;

/**
 * Decorator class, all anothers decorators must extend this class
 * @author gue10
 * */
public class ProductDecorator implements ProductProtocol {

    private final ProductProtocol product;

    /**
     * @param product the product that will be decorated
     * */
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
