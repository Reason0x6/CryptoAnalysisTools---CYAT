public class Mono{

    private char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };

    private char[] ch;
    private String s;
 
    public Mono(String x){
        this.s = x;
        ch = x.toCharArray();
    }
 
    public void doDecryption(String key)
    {
        ch = key.toCharArray();
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    break;
                }
            }
        }
        System.out.println("Decrypted message: " + (new String(p1)));
    }
 
   
}
