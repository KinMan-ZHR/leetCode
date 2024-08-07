import java.util.Arrays;
import java.util.Random;

public class Utils {
    /**
     * 对数器
     * @param arr1 数组1
     * @param arr2 数组2
     */
    public static <T extends Comparable<T>> boolean isEqual(T[] arr1, T[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * 生成有序数组
     *
     * @param maxSize  数组长度
     * @param maxValue 最大值
     * @param <T> 数组类型
     * @param minValue 最小值
     * @param accent 是否升序
     */

    @SuppressWarnings("unchecked")
    public static <T extends Number & Comparable<? super T>> T[] generateOrderedArray(Class<T> clazz, int maxSize, int minValue, int maxValue, Boolean accent) {
        Random random = new Random();
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, maxSize);

        for (int i = 0; i < maxSize; i++) {
            try {
                // Generate numbers between minValue and maxValue inclusive.
                int randomNumber = minValue + random.nextInt(maxValue - minValue + 1);
                array[i] = clazz.getConstructor(Integer.TYPE).newInstance(randomNumber);
            } catch (Exception e) {
                throw new RuntimeException("Error creating instance of " + clazz.getName(), e);
            }
        }
        if (accent != null) {
            // Sort the array based on the accent flag.
            if (accent) {
                Arrays.sort(array);
            }
            if (!accent) {
                Arrays.sort(array);
                reverseArray(array);
            }
        }

        return array;
    }

    /**
     * Helper method to reverse an array of comparable elements.
     * @param array The array to be reversed.
     *              @param <T> The type of elements in the array.
     *
     */
    private static <T extends Comparable<? super T>> void reverseArray(T[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            T temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}