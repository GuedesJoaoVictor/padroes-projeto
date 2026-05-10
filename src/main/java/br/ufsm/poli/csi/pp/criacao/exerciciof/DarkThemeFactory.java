package br.ufsm.poli.csi.pp.criacao.exerciciof;

public class DarkThemeFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Menu createMenu() {
        return new DarkMenu();
    }

    @Override
    public TextBox createTextBox() {
        return new DarkTextBox();
    }
}
