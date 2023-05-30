package com.tangguanglei.array;

import org.junit.Test;

public class TwoSum001Test {

    @Test
    public void twoSum() {
        TwoSum001 twoSum001 = new TwoSum001();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum001.twoSum(nums, target);
        assert result[0] == 1 && result[1] == 0;
    }

    @Test
    public void twoSum1() {
        TwoSum001 twoSum001 = new TwoSum001();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum001.twoSum1(nums, target);
        assert result[0] == 1 && result[1] == 0;
    }
}
