package test;

/**
 * Created by zqin on 2016/8/18.
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int j = n-2;
        while(j >= 0 && nums[j] > nums[j+1]) {
            j--;
        }

        if(j >= 0){
            int i = n-1;
            while(nums[i] <= nums[j]) i--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        j++;
        int i = n-1;
        while(j < i){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i--;j++;
        }
    }

    public static void main(String [] args){
        Solution31 a = new Solution31();
        int [] nums = {1,2,3};
        a.nextPermutation(nums);
    }
}
