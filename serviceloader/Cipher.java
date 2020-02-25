package serviceloader;

public interface Cipher {
    byte[] encrypt(byte[] src, byte[] key);
    byte[] decrypt(byte[] src, byte[] key);
    int strengh();
}
