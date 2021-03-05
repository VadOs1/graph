package com.gmail.dissa.vadim.graph.task;

import java.util.HashMap;
import java.util.Map;

class RotationalCipher {
    private static final Map<Character, Integer> charsMap = new HashMap<>();
    private static final Map<Integer, Character> intsMap = new HashMap<>();

    public RotationalCipher() {
        charsMap.put('a', 0);
        charsMap.put('b', 1);
        charsMap.put('c', 2);
        charsMap.put('d', 3);
        charsMap.put('e', 4);
        charsMap.put('f', 5);
        charsMap.put('g', 6);
        charsMap.put('h', 7);
        charsMap.put('i', 8);
        charsMap.put('j', 9);
        charsMap.put('k', 10);
        charsMap.put('l', 11);
        charsMap.put('m', 12);
        charsMap.put('n', 13);
        charsMap.put('o', 14);
        charsMap.put('p', 15);
        charsMap.put('q', 16);
        charsMap.put('r', 17);
        charsMap.put('s', 18);
        charsMap.put('t', 19);
        charsMap.put('u', 20);
        charsMap.put('v', 21);
        charsMap.put('w', 22);
        charsMap.put('x', 23);
        charsMap.put('y', 24);
        charsMap.put('z', 25);


        intsMap.put(0, 'a');
        intsMap.put(1, 'b');
        intsMap.put(2, 'c');
        intsMap.put(3, 'd');
        intsMap.put(4, 'e');
        intsMap.put(5, 'f');
        intsMap.put(6, 'g');
        intsMap.put(7, 'h');
        intsMap.put(8, 'i');
        intsMap.put(9, 'j');
        intsMap.put(10, 'k');
        intsMap.put(11, 'l');
        intsMap.put(12, 'm');
        intsMap.put(13, 'n');
        intsMap.put(14, 'o');
        intsMap.put(15, 'p');
        intsMap.put(16, 'q');
        intsMap.put(17, 'r');
        intsMap.put(18, 's');
        intsMap.put(19, 't');
        intsMap.put(20, 'u');
        intsMap.put(21, 'v');
        intsMap.put(22, 'w');
        intsMap.put(23, 'x');
        intsMap.put(24, 'y');
        intsMap.put(25, 'z');
    }


    String rotationalCipher(String input, int rotationFactor) {
        if (input == null) {
            return null;
        }
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    int index = (charsMap.get(Character.toLowerCase(c)) + rotationFactor) % 26;
                    c = Character.toUpperCase(intsMap.get(index));
                } else {
                    int index = (charsMap.get(c) + rotationFactor) % 26;
                    c = intsMap.get(index);
                }
            } else if (Character.isDigit(c)) {
                int v = Integer.parseInt(String.valueOf(c));
                v = (v + rotationFactor) % 10;
                c = (char) ('0' + v);
            }
            chars[i] = c;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new RotationalCipher().rotationalCipher("Zebra-493?", 3));
        System.out.println(new RotationalCipher().rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
    }
}
