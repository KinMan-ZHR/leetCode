
import java.util.*;

public class Search {
    /**
     * 二分查找
     * 针对有序数组，找到key对应的索引
     * 时间复杂度：O(log n)，空间复杂度：O(1)
     * @param arr 有序数组
     * @param key 目标对象
     * @return key对应的索引，若不存在则返回-1
     * @param <T> 可比较泛型
     */
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T key)
    {
        if (arr == null || arr.length == 0 || key == null)
            return -1;
        // 初始化低值和高值索引
        int low = 0;
        int high = arr.length - 1;
        // 循环查找,直到高低索引碰面
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].compareTo(key) == 0)
                return mid;
            if (arr[mid].compareTo(key) < 0)// key大于中间值
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    /**
     * 数组中原地删除(在乱序寻找数组中所有等于x的数，并删除)
     * 时间复杂度：O(n)，空间复杂度：O(1)
     * @param arr 乱序数组
     * @return 删除后的数组
     * @param <T> 可比较泛型
     */
    public static <T extends Comparable<T>> T[] remove(T[] arr, T x) {
        if (arr == null || arr.length == 0 || x == null)
            return arr;
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != x)// 不等于x, 保留
                arr[i++] = arr[j];
        }
        return Arrays.copyOf(arr, i);
    }

    /**
     * 寻找下一个大于key的元素
     * 时间复杂度：O(n)，空间复杂度：O(n)
     * @param arr 有序数组
     * @return 下一个大于key的元素
     * @param <T> 可比较泛型
     */
    public static <T extends Comparable<T>> List<T> nextGreaterElements(T[] arr) {
        List<T> result = new ArrayList<>(Collections.nCopies(arr.length, null));
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()].compareTo(arr[i]) < 0) {
                result.set(stack.pop(), arr[i]);
            }
            stack.push(i);
        }

        return result;
    }

}
