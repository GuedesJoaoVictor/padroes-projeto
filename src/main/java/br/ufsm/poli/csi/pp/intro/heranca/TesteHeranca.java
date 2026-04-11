package br.ufsm.poli.csi.pp.intro.heranca;

public class TesteHeranca {

    public void print(A a) {
        System.out.println("A");
    }

    public void print(B b) {
        System.out.println("B");
    }

    public class A {

        public void print() {
            System.out.println("A");
        }

    }

    public class B extends A {
        public void print() {
            System.out.println("B");
        }
    }

    public TesteHeranca() {
        A a = new A();
        B b = new B();
        A b1 = new B();
        print(a);
        print(b);
        print(b1);
    }

    public static void main(String[] args) {
        new TesteHeranca();
    }

}
