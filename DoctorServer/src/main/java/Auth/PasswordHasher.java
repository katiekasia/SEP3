package Auth;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordHasher
{
  public static String hash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

    byte[] salt = new byte[16];
    SecureRandom sr = new SecureRandom();
    sr.nextBytes(salt);


    PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 100000, 160);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    byte[] hash = skf.generateSecret(spec).getEncoded();


    byte[] hashBytes = new byte[36];
    System.arraycopy(salt, 0, hashBytes, 0, 16);
    System.arraycopy(hash, 0, hashBytes, 16, 20);


    return Base64.getEncoder().encodeToString(hashBytes);
  }


  public static boolean validate(String hashString, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

    byte[] hashBytes = Base64.getDecoder().decode(hashString);


    byte[] salt = new byte[16];
    System.arraycopy(hashBytes, 0, salt, 0, 16);


    PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 100000, 160);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    byte[] hash = skf.generateSecret(spec).getEncoded();


    for (int i = 0; i < 20; i++) {
      if (hashBytes[i + 16] != hash[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    String password = "password";
    String hashedPassword = PasswordHasher.hash(password);

    System.out.println(hashedPassword);
  }

}
