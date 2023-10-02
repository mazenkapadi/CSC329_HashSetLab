package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();

        hs.add(10);
        hs.add(34);
        hs.add(12);
        hs.add(98);
        hs.add(24);
        hs.add(65);
        hs.add(34);
        hs.add(89);
        hs.add(98);
        hs.add(22);
        hs.show();

        System.out.println(hs.loadFactor());

        hs.autoResize();

        System.out.println(hs.loadFactor());
    }
}