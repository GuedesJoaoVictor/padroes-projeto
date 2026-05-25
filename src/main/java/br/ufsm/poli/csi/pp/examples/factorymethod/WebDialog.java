package br.ufsm.poli.csi.pp.examples.factorymethod;

public class WebDialog implements Dialog {

    @Override
    public void render() {
    }

    @Override
    public Button createButton() {
        return new HTMLButton();
    }

}
