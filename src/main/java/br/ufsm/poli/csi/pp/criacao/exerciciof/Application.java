package br.ufsm.poli.csi.pp.criacao.exerciciof;

public class Application implements GUIComponent {

    private GUIFactory guiFactory;
    private Menu menu1;
    private Menu menu2;
    private TextBox textBox1;
    private Button button1;
    private Button button2;

    public Application(GUIFactory guiFactory) {
        this.guiFactory = guiFactory;
        init();
    }

    private void init() {
        menu1 = guiFactory.createMenu();
        menu2 = guiFactory.createMenu();
        textBox1 = guiFactory.createTextBox();
        button1 = guiFactory.createButton();
        button2 = guiFactory.createButton();
    }

    @Override
    public void render() {
        menu1.render();
        menu2.render();
        textBox1.render();
        button1.render();
        button2.render();
    }

    public static void main(String[] args) {
        // here we have our application with one of the themes from application.properties.
//        new Application(new DarkThemeFactory());
//        new Application(new LightThemeFactory());
    }

}
