package com.dleschev.maps;

import java.util.HashMap;

public class MyTest {

    static class MyKey {
        final int key;

        public MyKey(int key) {
            this.key = key;
        }

        /*public void setKey(int key) {
            this.key = key;
        }*/

        /*@Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MyKey o) {
                return key == o.key;
            }
            return false;
        }*/
    }

    public static void main(String[] args) {
        HashMap<MyKey, String> map = new HashMap<>();
        var myKey = new MyKey(1);
        //myKey.setKey(1);
        map.put(myKey, "my value");
        //myKey.setKey(2);
        System.out.println(map.get(new MyKey(2)));
        //myKey.setKey(1);
        System.out.println(map.get(new MyKey(1)));
        System.out.println(map.get(myKey));
    }
}