package jdcb;

import java.util.Scanner;

/**
 * Created by isher on 30/05/2016.
 */
public class Helper {

    private static Scanner sc;

    public static Scanner getSc() {
        if (sc == null)
            sc = new Scanner(System.in);
        return sc;
    }

    // print string to user and return it
    public static String inputText(String textToPrint) {
        System.out.println(textToPrint);
        String str = getSc().nextLine();
        return str;
    }


}
