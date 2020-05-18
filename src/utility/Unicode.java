package encryptdecrypt.utility;

public class Unicode implements Encrypalg{
    public String encode (String in, int shift)
    {
        int length = in.length();
        int i = 0;
        char[] myArray = in.toCharArray();
        for(i=0; i<length; i++)
        {
            myArray[i] = (char)(myArray[i]+shift);
        }
        String hell = new String(myArray);
        return hell;
    }

    public String decode (String in, int shift)
    {
        int length = in.length();
        int i = 0;
        char[] myArray = in.toCharArray();
        for(i=0; i<length; i++)
        {
            myArray[i] = (char)(myArray[i]-shift);
        }
        String hell = new String(myArray);
        return hell;
    }
}
