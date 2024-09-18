package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {
    /**
     * 快速排序
     */
    public static <T extends Comparable<T>> void quickSort(T[] arr,int left,int right)
        {
            //思想：递归无限细分，最后递归到只有一个元素，此时该元素就是有序的,每一个元素都在它的合适位置
            if(left < right){
                int pos = partition(arr, left, right);
                quickSort(arr, left, pos - 1);
                quickSort(arr, pos + 1, right);
            }
        }

    /**
     * 分区, 返回pivot的位置,让pivot的左边都小于pivot,右边都大于pivot
     * @param arr 乱序数组
     * @param left 左边界
     * @param right 右边界
     * @return 返回pivot的位置
     * @param <T> 可比较泛型
     */
        public static <T extends Comparable<T>> int partition(T[] arr,int left,int right){
              T pivot = arr[left];
              while(left < right){
                  // 从右向左找第一个小于pivot的数
                  while(left < right && arr[right].compareTo(pivot) >= 0){
                      right--;
                  }
                  arr[left] = arr[right];
                  // 从左向右找第一个大于pivot的数
                  while(left < right && arr[left].compareTo(pivot) <= 0){
                      left++;
                  }
                  arr[right] = arr[left];
              }
              arr[left] = pivot;
              return left;

        }
    /**
     * 可迭代可求局部最优解(本质：维持一定的条件(连续空间),移动拓展，动态规划)
     * 控制窗口大小，寻找最大数组和(简单遍历而已)
     * @param nums  输入数组
     * @param k 窗口大小
     * @return 窗口最大值数组
     */
    public static int[]  maxSlidingWindow(int[] nums, int k) {
        int[]  ans= new int[nums.length];
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        ans[k-1]= sum;
        int resultIndex = k-1;
        for (int i = k; i < nums.length; i++) {
            ans[i] = ans[i - 1] + nums[i] - nums[i - k];
            if (ans[i] > ans[resultIndex]){
                resultIndex = i;
                System.out.println("resultIndex:"+resultIndex);
            }

        }
        int[] result;
        result=Arrays.copyOfRange(nums, resultIndex - k+1 , resultIndex+1);
        return result;

    }
    /**
     * 滑动窗口(本质：维持一定的条件(连续空间),移动拓展)
     * 控制数组和，寻找最小滑动窗口
     * @param nums  输入数组
     * @param s 要求数组和
     * @return 满足条件的窗口最小长度
     */
    public static int  minSlidingWindow(int[] nums, int s) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    /**
     * 三数之和
     * @param nums 输入数组
     * @return 不重复的三元组
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }





}
