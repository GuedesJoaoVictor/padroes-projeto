package br.ufsm.poli.csi.pp.examples.decorator;

public class Main {

    public static void main(String[] args) {
        TShirt tShirt = new TShirt();
        System.out.println(tShirt.getName());
        System.out.println(tShirt.getPrice());

        ProductPrintedDecorator tshirtPrinted = new ProductPrintedDecorator(tShirt);
        System.out.println(tshirtPrinted.getName());
        System.out.println(tshirtPrinted.getPrice());


        ProductPrintedDecorator tshirtPrintedFrontAndBack = new ProductPrintedDecorator(tshirtPrinted);
        System.out.println(tshirtPrintedFrontAndBack.getName());
        System.out.println(tshirtPrintedFrontAndBack.getPrice());
    }

}
