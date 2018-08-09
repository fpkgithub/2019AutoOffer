package swordoffertest;

public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {


        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        int res = moreThanHalfArray(nums);
        System.out.println(res);
    }

    private static int moreThanHalfArray(int[] nums) {
        int len = nums.length;
        if(nums==null||len<=0)
            return 0;
        int result=nums[0];
        int times=1;
        for (int i = 0; i <len; i++) {
            if(times==0){
                result=nums[i];
                times++;
            }
            else{
                if(nums[i]==result)
                    times++;
                else
                    times--;
            }
        }
        times=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]==result)
                times++;
            if(times>len/2)
                return result;
        }
        return 0;

    }
}
