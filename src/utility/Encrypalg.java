package encryptdecrypt.utility;

public interface Encrypalg {
    String encode (String in, int shift);
    String decode (String in, int shift);
}
