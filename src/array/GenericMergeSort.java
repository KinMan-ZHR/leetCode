package array;

public class  GenericMergeSort<T extends Comparable<T>>{
    // 归并排序


        private void mergeSort(T[] arr, T[] temp, int leftStart, int rightEnd) {
            if (leftStart >= rightEnd) {
                return;
            }

            int middle = (leftStart + rightEnd) / 2;
            mergeSort(arr, temp, leftStart, middle);
            mergeSort(arr, temp, middle + 1, rightEnd);
            mergeHalves(arr, temp, leftStart, rightEnd);
        }

        private void mergeHalves(T[] arr, T[] temp, int leftStart, int rightEnd) {
            int leftEnd = (rightEnd + leftStart) / 2;
            int rightStart = leftEnd + 1;
            int size = rightEnd - leftStart + 1;

            int left = leftStart;
            int right = rightStart;
            int index = leftStart;

            while (left <= leftEnd && right <= rightEnd) {
                if (arr[left].compareTo(arr[right]) <= 0) {
                    temp[index] = arr[left];
                    left++;
                } else {
                    temp[index] = arr[right];
                    right++;
                }
                index++;
            }

            System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
            System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
            System.arraycopy(temp, leftStart, arr, leftStart, size);
        }


}
