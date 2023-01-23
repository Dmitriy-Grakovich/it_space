package ru.grakovich.analyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class AnalyzerIndexImplTest {

    @Test
    void transformer() {
        List<Integer[]> nums = Arrays.asList(new Integer[]{1,3,4,5},new Integer[]{2},new Integer[]{3,4});
        String[] indexes = {"1,3-5", "2","3-4"};
        Assertions.assertArrayEquals(nums.toArray(),
                AnalyserIndexFactory.createAnalyserIndex().transformer(indexes).toArray());
    }

    @Test
    void allVariants() {
        List<Integer[]> nums = Arrays.asList(new Integer[]{1,3,4,5},new Integer[]{2},new Integer[]{3,4});
        List<Integer[]> integers = Arrays.asList(new Integer[]{1, 2, 3}, new Integer[]{1, 2, 4}, new Integer[]{3, 2, 3},
                new Integer[]{3, 2, 4}, new Integer[]{4, 2, 3}, new Integer[]{4, 2, 4},
                new Integer[]{5, 2, 3}, new Integer[]{5, 2, 4});
        Assertions.assertArrayEquals(integers.toArray(),
                AnalyserIndexFactory.createAnalyserIndex().allVariants(nums).toArray());

    }
}