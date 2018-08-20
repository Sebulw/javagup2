package password.manager.generators;

interface PasswordGenerator {

    String generate(int length);
    GeneratorType getType();
}
