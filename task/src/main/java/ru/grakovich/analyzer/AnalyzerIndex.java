package ru.grakovich.analyzer;

public interface AnalyzerIndex {
    int[][] transformer(String[]  indexes);

    int[][] allVariants(int[][] nums);
}
