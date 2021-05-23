package etc.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CodingTest3 {

  /*
  X -> major
  Y -> minor
  Z -> patch

  1.아규먼트는 nullㅣ면 안됨. null이면 IllegalArgumentException던질거고 version must not be null!
  메시지랑 함께 던짐
  2. version argument는 정규표현식(\d+(\.d+){-,2+(-SNAPSHOT)?.)이랑 매칭되어야 함.
  아니면 IllegalArgumentException던질거고 version must match major.minor.patch!

  3. version format은 X, X.Y, X.Y.Z랑 매칭되어야함. 그리고 (-SNAPSHOT)이 붙거나 안붙거나.
  X일땐 Y와 Z가 0이어야 하고, X.Y일땐 Z가 0이어야 함

  4. version 생성자가 정확할땐, 익셉션 안던져
  5. version은 isShapshot()을 사용해 스냅샷여부를 바르게 인식해야 함. (-SNAPSHOT)으로 끝날때!
  6. version비교는 null이 들어왔을때 other는 null이 아니어야 한다는 IllegalArgumentException발생
  스냅샷은 스냅샷 아닌버전보다 낮음(1.0.0>1.0.0-SNAPSHOT)
  x,x같으면 y비교...
   */
  private static class Version implements Comparable<Version> {

    Version(String version) {
      if ("".equals(version)) {
        throw new IllegalArgumentException(errorVersionMustNotBeNull);
      }
    }

    boolean isSnapshot() {
      return false;
    }

    @Override
    public int compareTo(Version o) {
      return 0;
    }
  }

  static final String errorVersionMustNotBeNull = "'version' must not be null!";
  static final String errorOtherMustNotBeNull = "'other' must not be null!";
  static final String errorVersionMustMatchPattern = "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void test_errorVersionMustNotBeNull() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage(errorVersionMustNotBeNull);

    new Version(null);
  }

  @Test
  public void test_errorVersionMustMatchPattern() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage(errorVersionMustMatchPattern);

    new Version("3.8.0-snapshot");
  }

  @Test
  public void test_versionName() {
    new Version("3.0.0");
    new Version("3.8.0");
    new Version("3.8.1");
    new Version("3.0.0-SNAPSHOT");
    new Version("3.8.0-SNAPSHOT");
    new Version("3.8.1-SNAPSHOT");
  }

  @Test
  public void test_isSnapshot() {
    assertThat(new Version("3.8.0-SNAPSHOT").isSnapshot()).isTrue();
    assertThat(new Version("3.8.0").isSnapshot()).isFalse();
  }

  @Test
  public void test_cannotCompareWithNull() {
    Version version = new Version("3.8.0-SNAPSHOT");

    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage(errorOtherMustNotBeNull);

    version.compareTo(null);
  }

  @Test
  public void test_compare() {
    assertThat(new Version("3.8.0").compareTo(new Version("3.8.0"))).isEqualTo(0);
    assertThat(new Version("3.8.0").compareTo(new Version("4.8.0"))).isEqualTo(-1);
    assertThat(new Version("3.8.0").compareTo(new Version("3.9.0"))).isEqualTo(-1);
    assertThat(new Version("3.8.0").compareTo(new Version("3.8.1"))).isEqualTo(-1);
    assertThat(new Version("3.8.0-SNAPSHOT").compareTo(new Version("3.8.0"))).isEqualTo(-1);
  }

  @Test
  public void test_versionNameWith3parts() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage(errorVersionMustMatchPattern);

    new Version("3.8.0.1");
  }

}