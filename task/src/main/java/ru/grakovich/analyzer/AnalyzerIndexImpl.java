package ru.grakovich.analyzer;

import java.util.*;

class AnalyzerIndexImpl implements AnalyzerIndex {


    @Override
    public List<Integer[]> transformer(String[] indexes) {
        List<Integer[]> result = new ArrayList<>();
        for (String index : indexes) {
            String[] temp = index.split(",");
            Integer[] arr = new Integer[0];
            for (String s1 : temp) {
                arr = sumArrays(arr, stringToArraysInt(s1));
            }
            result.add(arr);
        }
        return result;
    }

    @Override
    public List<Integer[]> allVariants(List<Integer[]> nums) {
        Map<Integer, Integer[]> source = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            source.put(i, nums.get(i));
        }
        ListIterator<Integer> keysIterator = new ArrayList<>(source.keySet()).listIterator();

        Map<Integer, Integer> counter = new HashMap<>();

        List<Integer[]> result = new ArrayList<>();
        step(source, keysIterator, counter, result);

        return result;
    }

    private void step(Map<Integer, Integer[]> source, ListIterator<Integer> keysIterator,
                      Map<Integer, Integer> counter, List<Integer[]> result) {
        if (keysIterator.hasNext()) {
            Integer key = keysIterator.next();
            counter.put(key, 0);
            while (counter.get(key) < source.get(key).length) {
                step(source, keysIterator, counter, result);
                counter.put(key, counter.get(key) + 1);
            }
            keysIterator.previous();

        } else {
            Integer[] variant = new Integer[source.size()];
            for (int i = 0; i < variant.length; i++) {
                Integer position = counter.get(i);
                variant[i] = source.get(i)[position];
            }
            result.add(variant);

        }
    }


    private Integer[] stringToArraysInt(String string) {
        int start = Character.getNumericValue(string.charAt(0));
        int end = Character.getNumericValue(string.charAt(string.length() - 1));
        Integer[] result = new Integer[end - start + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = start++;
        }
        return result;
    }

    private Integer[] sumArrays(Integer[] a, Integer[] b) {
        int l = a.length;
        int r = b.length;
        Integer[] result = new Integer[l + r];
        System.arraycopy(a, 0, result, 0, l);
        System.arraycopy(b, 0, result, l, r);
        return result;
    }

}
