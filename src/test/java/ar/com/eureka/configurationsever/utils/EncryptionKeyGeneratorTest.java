package ar.com.eureka.configurationsever.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;


public class EncryptionKeyGeneratorTest {

  @Test
  public void generateAESKeyWhenGenerate() throws NoSuchAlgorithmException {
    EncryptionKeyGenerator generator =  new EncryptionKeyGenerator();
    SecretKey key = generator.generate();
    assertThat(key, IsNull.notNullValue());
  }

  private class EncryptionKeyGenerator {

    public SecretKey generate() throws NoSuchAlgorithmException {
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(256);
      return keyGen.generateKey();
    }
  }
}
