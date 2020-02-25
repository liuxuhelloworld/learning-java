package serviceloader.impl;

import java.util.Arrays;
import java.util.Optional;
import java.util.ServiceLoader;

import serviceloader.Cipher;

public class CaesarCipherTest {
    public static void main(String[] args) {
        ServiceLoader<Cipher> cipherLoader = ServiceLoader.load(Cipher.class);

        Optional<Cipher> cipher = cipherLoader.stream()
            .filter(e -> e.type() == CaesarCipher.class)
            .findFirst()
            .map(ServiceLoader.Provider::get);

        byte[] src = new byte[] {'a', 'b', 'c'};
        byte[] key = new byte[] {'a'};
        if (cipher.isPresent()) {
            byte[] encrypted = cipher.get().encrypt(src, key);
            System.out.println(Arrays.toString(encrypted));
        }
    }
}
