package via.pro3.mainserver.Auth;

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
  // TEST
  public static void main(String[] args) {
    try {
      String password = "securePassword123";
      String hashedPassword = hash(password);
      String check = hash(password);
      System.out.println("Hashed Password: " + hashedPassword);

      boolean isValid = validate(check, hashedPassword);
      System.out.println("Password is valid: " + isValid);

      boolean isInvalid = validate(hashedPassword, "wrongPassword");
      System.out.println("Password is valid: " + isInvalid);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
