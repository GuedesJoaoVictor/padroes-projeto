package br.ufsm.poli.csi.pp.teste.factorymethod;

public class WindowDialog implements Dialog {

    @Override
    public void render() {
    }

    @Override
    public Button createButton() {
        return new WindowButton();
    }
}
