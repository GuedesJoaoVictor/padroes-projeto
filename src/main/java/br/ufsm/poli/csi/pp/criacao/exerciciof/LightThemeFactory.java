package br.ufsm.poli.csi.pp.criacao.exerciciof;

public class LightThemeFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Menu createMenu() {
        return new LightMenu();
    }

    @Override
    public TextBox createTextBox() {
        return new LightTextbox();
    }
}
