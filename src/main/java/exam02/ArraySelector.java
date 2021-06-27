package exam02;

/*
Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat, és egy
szövegként összerak, szögletes zárójelek között!

A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem
páratlan, stb.

Ha nulla elemű a tömb, akkor üres stringet adjon vissza!
 */


import java.util.Arrays;


public class ArraySelector {

    public String selectEvens(int[] ints) {
        if (ints.length == 0) {
            return "";
        }
        int[] result = new int[(int) Math.round(ints.length / 2.0)];
        for (int i = 0; i < ints.length; i = i + 2) {
            result[i / 2] = ints[i];
        }

        return Arrays.toString(result);
    }


}
