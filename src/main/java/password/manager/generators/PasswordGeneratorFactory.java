package password.manager.generators;

import static password.manager.generators.GeneratorType.UUID;

class PasswordGeneratorFactory {

    PasswordGenerator getGenerator(GeneratorType type) {

        if (type == UUID) {
            return new UuidPasswordGenerator();
        }

        throw new PasswordGeneratorException("No such generator");
    }
}
