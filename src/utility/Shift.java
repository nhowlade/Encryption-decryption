package encryptdecrypt.utility;

public class Shift implements Encrypalg{
    public String encode (String in, int shift)
    {
        char a = 'a';
        char z = 'z';
        char A = 'A';
        char Z = 'Z';
        int size = 26;
        String result = "";
        char[] chars = in.toCharArray();
        for (char item: chars)
        {
            if(item>=a && item<=z)
            {
                char shiftitem = (char) (((item - a + shift ) % size ) + a );
                result+=shiftitem;
            }
            else if (item>=A && item<=Z)
            {
                char shiftitem = (char) (((item - A + shift ) % size ) + A );
                result+=shiftitem;
            }
            else {
                result+=item;
            }
        }
        return result;
    }

    public String decode (String in, int shift)
    {
        char a = 'a';
        char z = 'z';
        char A = 'A';
        char Z = 'Z';
        int size = 26;
        String result = "";
        char[] chars = in.toCharArray();
        for (char item: chars)
        {
            if(item>=a && item<=z)
            {
                int mod = ((item-a-shift)% size+size)%size;
                char shiftitem = (char) (mod + a);
                result+=(shiftitem);
            }
            else if (item>=A && item<=Z)
            {
                int mod = ((item-A-shift)% size+size)%size;
                char shiftitem = (char) (mod + A);
                result+=(shiftitem);
            }
            else {
                result+=item;
            }
        }
        return result;
    }
}
