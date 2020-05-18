package encryptdecrypt;


import javafx.scene.input.KeyCode;
import java.io.*;
import java.nio.Buffer;
import java.util.*;
import encryptdecrypt.utility.*;
import kotlin.collections.ShortIterator;

import javax.swing.*;

public class Main {

    public static String readFile (String input)throws Exception
    {
        File file = new File (input);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        br.close();
        return st;
    }

    public static void createFile (String filename, String message)throws Exception
    {
        FileWriter fr = new FileWriter(filename);
        fr.write(message);
        fr.close();
    }
    public static void main(String[] args) {

        int argc = args.length;
        int key = 0;
        String fileName;
        String fromFile;
        String msg = "";
        String changedMsg = "";
        String choice = "enc";
        String algo = "";

        for (int i = 0; i < argc; i++) {
            if (args[i].equals("-mode")) {
                choice = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                msg = args[i + 1];
            } else if (args[i].equals("-in")) {
                try
                {
                    msg = readFile(args[i + 1]);
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }else if (args[i].equals("-alg")) {
                algo = (args[i + 1]);
            }
        }

        if (choice.equals("enc")) {
            if(algo.equals("shift"))
            {
                Shift shift = new Shift();
                changedMsg = shift.encode(msg,key);
            }
            else
            {
                Unicode unicode = new Unicode();
                changedMsg = unicode.encode(msg,key);
            }
        } else {
            if(algo.equals("shift"))
            {
                Shift shift = new Shift();
                changedMsg = shift.decode(msg, key);
            }
            else
            {
                Unicode unicode = new Unicode();
                changedMsg = unicode.decode(msg,key);
            }
        }
        for (int i = 0; i < argc; i++)
        {
            if (args[i].equals("-out"))
            {
                try
                {
                    createFile(args[i+1], changedMsg);
                } catch ( Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}