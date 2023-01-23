package ru.grakovich.analyzer;

import java.util.List;

public interface AnalyzerIndex {
    List<Integer []> transformer(String[]  indexes);

    List<Integer[]> allVariants(List<Integer[]> nums);
}
