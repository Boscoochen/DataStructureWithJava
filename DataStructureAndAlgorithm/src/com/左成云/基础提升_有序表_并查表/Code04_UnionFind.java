package com.左成云.基础提升_有序表_并查表;

import java.util.HashMap;
import java.util.List;

public class Code04_UnionFind {

    //样本进来会包一包，叫做元素
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        // key 某个元素 value 该元素的父
        public HashMap<Element<V>, Element<V>> fatherMap;
        // key 某个集合的代表元素 value 该集合的大小
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public boolean isSameSet(V a, V b) {

        }

        public void union(V a, V b) {

        }
    }
}
