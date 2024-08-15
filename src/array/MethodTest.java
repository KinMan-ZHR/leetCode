package array;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.binarySearch;
import static org.junit.Assert.assertEquals;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class MethodTest {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        System.out.printf("Hello and welcome!");
        int[] a={1,2,3,4,5};

    }
    // 测试
    @Test
    public void TestBinarySearch()
    {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(4, binarySearch(arr, 5));
        assertEquals(1,TrainingGrounds.mySqrt(1));
        Integer [] arr2 =Utils.generateOrderedArray(Integer.class, 10, 0, 100, null);
        System.out.println(Arrays.toString(arr2));

    }
    @Test
    public void TestFindBiggestSumByLimitedLength()
    {
        int[] arr = { 2,3,8,9,1,4, 5, 6, 7, };
        int[] res = {3,8,9};
        assertEquals(Arrays.toString(res), Arrays.toString(TwoPointer.maxSlidingWindow(arr, 3)));
    }

   

}
