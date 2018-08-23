package password.manager.encrypt;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EncryptionServiceTest {

    @Test
    public void testAES() {
        String textToEncrypt = "Facebook";
        String secretKey = "abcdefghijklmnop";

        String encrypted = EncryptionService.encrypt(secretKey, textToEncrypt);
        String decrypted = EncryptionService.decrypt(secretKey, encrypted);

        Assertions.assertThat(decrypted).isEqualTo(textToEncrypt);

    }

}