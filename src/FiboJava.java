import java.math.BigInteger;

public class FiboJava {
  private static BigInteger fibo(int x) {
    BigInteger a = BigInteger.ZERO;
    BigInteger b = BigInteger.ONE;
    BigInteger c = BigInteger.ZERO;
    for (int i = 0; i < x; i++) {
      c = a.add(b);
      a = b;
      b = c;
    }
    return a;
  }

  public static void main(String args[]) {
    System.out.println(fibo(1000));
  }
}