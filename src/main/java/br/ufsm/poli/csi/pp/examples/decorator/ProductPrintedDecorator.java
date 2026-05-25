package br.ufsm.poli.csi.pp.examples.decorator;

/**
 * The printed product decorator, inherits from ProductDecorator
 * @author gue10
 * */
public class ProductPrintedDecorator extends ProductDecorator {

    /**
     * @param product the product that will be decorated
     * */
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
