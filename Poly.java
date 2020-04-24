import java.util.*;
public class Poly{
    private String ciphertext, key, final_key, plaintext;
    Poly(String x, String y){
        this.ciphertext = x;
        this.key = y;
        this.final_key = "";
        this.plaintext = "";
    }

    public void decrypt(){
        ArrayList<ArrayList<Character>> vignere = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++) {
            ArrayList<Character> row_vignere = new ArrayList<>();
            for (int j = 0; j < 26; j++)
                row_vignere.add(alphabet.charAt((i + j) % 26));
            vignere.add(row_vignere);
        }
        
        for (int i = 0, j = 0; i < ciphertext.length(); i++) {
            if (ciphertext.charAt(i) >= 'a' && ciphertext.charAt(i) <= 'z')
                final_key += key.charAt((j++) % key.length());
            else
                final_key += ciphertext.charAt(i);
        }
        for (int i = 0; i < ciphertext.length(); i++) {
            if (ciphertext.charAt(i) >= 'a' && ciphertext.charAt(i) <= 'z')
                plaintext += alphabet.charAt(vignere.get(alphabet.indexOf(final_key.charAt(i))).indexOf(ciphertext.charAt(i)));
            else
                plaintext += ciphertext.charAt(i);
        }
        
        System.out.println("Polyalphabetic Cipher [Decryption]");
        System.out.println("Cipher Text : " + ciphertext);
        System.out.println("Key         : " + key);
        System.out.println("Plain Text  : " + plaintext);
    }

    public void getSplit(int kLength){
        String no_space = ciphertext.replaceAll("\\s+", "");
        String[] texts = new String[kLength];
        for(int i = 0; i <kLength; i++){
           texts[i] = "";
        }
        for(int i = 0; i < no_space.length(); i++){
            texts[i%kLength] += no_space.charAt(i);
        }
        for(int i = 0; i <kLength; i++){
            System.out.println(texts[i].toString() + "\n");
        }
        
    }
    
}
