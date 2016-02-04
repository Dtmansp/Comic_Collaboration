package com.example.dtman.comic_collaboration.app;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Gene on 2/1/2016.
 */
public final class GCIUID {

    private String UID = "";

    ArrayList<Integer> randomList = new ArrayList<Integer>();


    public GCIUID() {
        this.UID = getGCIUID();
    }

    public static String getGCIUID() {
        String result = "";
        byte r0 = (byte)ThreadLocalRandom.current().nextInt(256);
        int r1 = ThreadLocalRandom.current().nextInt(256);
        int r2 = ThreadLocalRandom.current().nextInt(256);
        int r3 = ThreadLocalRandom.current().nextInt(256);
        //double r0 = 0xffffffff * Math.random() | 0;
        // var r1 = 4294967295 * Math.random() | 0;
        //var r2 = 4294967295 * Math.random() | 0;
        //var r3 = 4294967295 * Math.random() | 0;

        byte[] rb = {1,1,0,1,0,0,0,0};


        System.out.println("Random number 0: " + r0);
        System.out.println("Random number 1: " + r1);
        System.out.println("Random number 2: " + r2);
        System.out.println("Random number 3: " + r3);
        System.out.println("Hex number 0: " + hexEncode(rb));
        System.out.println("Hex number 1: " + r1);
        System.out.println("Hex number 2: " + r2);
        System.out.println("Hex number 3: " + r3);
        /*
        for (int i = 0; i < 256; i += 1) {
            randomList.set(i) = (i < 16 ? "0" : "") + i);
        }

        return  randomList.get(255);
            +
                list[r0 >> 8    & 255] +
                list[r0 >> 16   & 255] +
                list[r0 >> 24   & 255] +
                list[r1         & 255] +
                list[r1 >> 8    & 255] +
                list[r1 >> 16   & 255] +
                list[r1 >> 24   & 255] +
                list[r2         & 255] +
                list[r2 >> 8    & 255] +
                list[r2 >> 16   & 255] +
                list[r2 >> 24   & 255] +
                list[r3         & 255] +
                list[r3 >> 8    & 255] +
                list[r3 >> 16   & 255] +
                list[r3 >> 24   & 255];
                */
        return result;
    }

    static private String hexEncode(byte[] aInput){
        StringBuilder result = new StringBuilder();
        char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
        for (int idx = 0; idx < aInput.length; ++idx) {
            byte b = aInput[idx];
            result.append(digits[ (b&0xf0) >> 4 ]);
            result.append(digits[ b&0x0f]);
        }
        return result.toString();
    }

    /*

        getGCIUID = function (){
            var list = [];
            var i;
            var r0 = 4294967295 * Math.random() | 0;
            var r1 = 4294967295 * Math.random() | 0;
            var r2 = 4294967295 * Math.random() | 0;
            var r3 = 4294967295 * Math.random() | 0;

            for (i = 0; i < 256; i += 1) {
                list[i] = (i < 16 ? '0': '') + (i).toString(16);
            }

            return  list[r0         & 255] +
                    list[r0 >> 8    & 255] +
                    list[r0 >> 16   & 255] +
                    list[r0 >> 24   & 255] +
                    list[r1         & 255] +
                    list[r1 >> 8    & 255] +
                    list[r1 >> 16   & 255] +
                    list[r1 >> 24   & 255] +
                    list[r2         & 255] +
                    list[r2 >> 8    & 255] +
                    list[r2 >> 16   & 255] +
                    list[r2 >> 24   & 255] +
                    list[r3         & 255] +
                    list[r3 >> 8    & 255] +
                    list[r3 >> 16   & 255] +
                    list[r3 >> 24   & 255];
        },


        */
}
