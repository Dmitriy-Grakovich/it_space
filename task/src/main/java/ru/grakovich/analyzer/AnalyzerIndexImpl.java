package ru.grakovich.analyzer;

import java.util.Arrays;

class AnalyzerIndexImpl implements AnalyzerIndex {


    @Override
    public int[][] transformer(String[] indexes) {
        int[][] result = new int[indexes.length][];
        for (int i = 0; i < indexes.length; i++) {
            //   Arrays.stream(st.split(",")).map(x-> x.split("-"))
            String[] temp = indexes[i].split(",");
            int[] arr = new int[0];
            for (String s1 : temp) {
                arr = sumArrays(arr, stringToArraysInt(s1));
            }
            result[i] = arr;
        }
        return result;
    }

    @Override
    public int[][] allVariants(int[][] nums) {

        return new int[0][0];
    }

    private int[] stringToArraysInt(String string) {
        int start = Character.getNumericValue(string.charAt(0));
        int end = Character.getNumericValue(string.charAt(string.length() - 1));
        int[] result = new int[end - start + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = start++;
        }
        return result;
    }

    private int[] sumArrays(int[] a, int[] b) {
        int l = a.length;
        int r = b.length;
        int[] result = new int[l + r];
        for (int i = 0; i < l; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < r; i++) {
            result[i + l] = b[i];
        }
        return result;
    }

}
