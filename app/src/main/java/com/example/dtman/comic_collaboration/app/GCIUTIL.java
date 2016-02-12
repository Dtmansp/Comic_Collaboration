package com.example.dtman.comic_collaboration.app;

import java.util.Random;

public final class GCIUTIL {

    public GCIUTIL() { }

    public static String getUID() {

        //generate a psudo-random 32-bit UID
        Random rand = new Random();
        int iH = 0xff;
        int none = 0;
        int iLen = iH + 1;
        String[] list = new String[iLen];

        int i0 = (iH * rand.nextInt() | none);
        int i1 = (i0 * rand.nextInt() | none);
        int i2 = (i1 * rand.nextInt() | none);
        int i3 = (i2 * rand.nextInt() | none);

        for (int i = 0; i < iLen; i += 1) {
            list[i] = (i < 16 ? "0" : "") + (Integer.toString(i, 16));
        }

        String result = list[i0 & iH] + list[i0 >> 8 & iH] +
                list[i0 >> 16 & iH] + list[i0 >> 24 & iH] +
                list[i1 & iH] + list[i1 >> 8 & iH] +
                list[i1 >> 16 & iH] + list[i1 >> 24 & iH] +
                list[i2 & iH] + list[i2 >> 8 & iH] +
                list[i2 >> 16 & iH] + list[i2 >> 24 & iH] +
                list[i3 & iH] + list[i3 >> 8 & iH] +
                list[i3 >> 16 & iH] + list[i3 >> 24 & iH];

        return result;
    }

}