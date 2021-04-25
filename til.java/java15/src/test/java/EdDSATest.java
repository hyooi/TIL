import java.nio.charset.StandardCharsets;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * EdDSA 장점
 * - 기존 ECDSA보다 성능이 우수함
 * - TLS1.3에서 허용되는 서명 체계 중 하나
 */
public class EdDSATest {
  @Test
  @SneakyThrows
  @DisplayName("EdDSA")
  void EdDSA() {
    var kp = KeyPairGenerator.getInstance("Ed25519").generateKeyPair();

    var sig = Signature.getInstance("Ed25519");
    sig.initSign(kp.getPrivate());
    sig.update("test_string".getBytes(StandardCharsets.UTF_8));

    var s = sig.sign();
    System.out.println(Base64.getEncoder().encodeToString(s));

  }
}
