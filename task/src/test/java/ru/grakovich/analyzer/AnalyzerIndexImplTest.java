package ru.grakovich.analyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class AnalyzerIndexImplTest {

    @Test
    void transformer() {
        int[][] nums = {{1,3,4,5},{2},{3,4}};
        String[] indexes = {"1,3-5", "2","3-4"};
        assertArrayEquals(AnalyserIndexFactory.createAnalyserIndex().transformer(indexes), nums);
    }

    @Test
    void allVariants() {
        int[][] nums = {{1,3,4,5},{2},{3,4}};
        int[][] var = {{1, 2, 3}, {1, 2, 4}, {3, 2, 3}, {3, 2, 4}, {4, 2, 3}, {4, 2, 4}, {5, 2, 3}, {5, 2, 4}};
        assertArrayEquals(AnalyserIndexFactory.createAnalyserIndex().allVariants(nums), var );
    }
}