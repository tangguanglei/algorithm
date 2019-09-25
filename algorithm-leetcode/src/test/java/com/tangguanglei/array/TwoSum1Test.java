package com.tangguanglei.array;

import org.junit.Test;

public class TwoSum1Test {

    @Test
    public void twoSum() {
        TwoSum1 twoSum1 = new TwoSum1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum1.twoSum(nums, target);
        assert result[0] == 1 && result[1] == 0;
    }

    @Test
    public void twoSum1() {
        TwoSum1 twoSum1 = new TwoSum1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum1.twoSum1(nums, target);
        assert result[0] == 1 && result[1] == 0;
    }
}
