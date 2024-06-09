package com.tangguanglei.array;

import org.junit.Test;

public class 两数之和001Test {

    @Test
    public void twoSum() {
        两数之和001 两数之和001 = new 两数之和001();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = 两数之和001.twoSum(nums, target);
        assert result[0] == 1 && result[1] == 0;
    }

    @Test
    public void twoSum1() {
        两数之和001 两数之和001 = new 两数之和001();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = 两数之和001.twoSum1(nums, target);
        assert result[0] == 1 && result[1] == 0;
    }
}
