package exam02;

/*
Az src/test/resources mappában találsz egy otos.csv fájlt, és olvasd be. Tárold el, hogy melyik számot hányszor húzták
ki. A fájl pontosvesszővel (;) elválasztva tárolja a mezőket. A 12 - 16. mező (nullával indexelve 11 - 15) tárolja a
kihúzott számokat.

Írj egy LottoReader osztályt! Használj egy 90 elemű tömb attribútumot! Vigyázz, a 90-es szám a tömb 89. eleme.

Konstruktorban töltsd be a fájlt, ami paraméterként egy InputStream-et vár. Mivel a fájl folytonosan frissül a megadott
 webhelyen és így a tesztesetek konkrét várt értékei is változhatnak, a mellékelt fájl alapján dolgozz!
 */

import java.io.*;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream inputStream) {

        try (
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(";");
                for (int i = 11; i < 16; i++) {
                    int number = Integer.parseInt(temp[i]);
                    numbers[number - 1]++;
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }


    }

    public int getNumber(int number) {
        return numbers[number - 1];
    }
}
