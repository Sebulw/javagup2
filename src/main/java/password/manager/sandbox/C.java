package password.manager.sandbox;

interface C extends A, B {

    default String foo() {
        return A.super.foo() + B.super.foo();
    }
}
