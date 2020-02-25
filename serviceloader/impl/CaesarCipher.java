package serviceloader.impl;

import serviceloader.Cipher;

public class CaesarCipher implements Cipher {
    @Override
    public byte[] encrypt(byte[] src, byte[] key) {
        byte[] result = new byte[src.length];
        for (int i = 0; i < src.length; i++) {
            result[i] = (byte)(src[i] + key[0]);
        }
        return result;
    }

    @Override
    public byte[] decrypt(byte[] src, byte[] key) {
        return encrypt(src, new byte[]{(byte) -key[0]});
    }

    @Override
    public int strengh() {
        return 1;
    }
}
