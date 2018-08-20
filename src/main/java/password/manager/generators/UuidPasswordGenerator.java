package password.manager.generators;

import java.util.UUID;

class UuidPasswordGenerator implements PasswordGenerator {

    @Override
    public String generate(int length) {

        StringBuilder sb = new StringBuilder(UUID.randomUUID().toString());
        while (sb.length() <= length) {
            sb.append(UUID.randomUUID().toString());
        }
        return sb.toString().substring(0, length);
    }

    @Override
    public GeneratorType getType() {
        return GeneratorType.UUID;
    }
}
