package project1;

import java.util.Arrays;
import java.util.List;

public class RadixSort {

    private Product getMax(Product[] arr, int n) {
        Product maxValue = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i].getCode() > maxValue.getCode()) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    private void countSort(Product[] arr, int size, long exp) {
        Product[] output = new Product[size];
        int i;
        int[] count = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < size; i++) {
            count[(int) ((arr[i].getCode() / exp) % 10)]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = size - 1; i >= 0; i--) {
            output[count[(int) ((arr[i].getCode() / exp) % 10)] - 1] = arr[i];
            count[(int) ((arr[i].getCode() / exp) % 10)]--;
        }

        for (i = 0; i < size; i++) {
            arr[i] = output[i];
        }
    }

    public Product[] radixSort(List<Product> arrList) {
        int size = arrList.size();
        Product[] arr = new Product[size];
        arr = arrList.toArray(arr);
        Product mx = getMax(arr, size);
        for (long exp = 1; mx.getCode() / exp > 0; exp *= 10)
            countSort(arr, size, exp);
        return arr;
    }
}