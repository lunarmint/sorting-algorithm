package project1;

import java.util.Collections;
import java.util.List;

public class HeapSort {

    public void heapSort(List<Product> arrList) {
        int heapSize = arrList.size();
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(arrList, heapSize, i);
        }
        for (int i = heapSize - 1; i > 0; i--) {
            Collections.swap(arrList, 0, i);
            heapify(arrList, i, 0);
        }
    }

    private void heapify(List<Product> arrList, int heapSize, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && arrList.get(left).getCode() > arrList.get(max).getCode()) {
            max = left;
        }

        if (right < heapSize && arrList.get(right).getCode() > arrList.get(max).getCode()) {
            max = right;
        }

        if (max != i) {
            Collections.swap(arrList, i, max);
            heapify(arrList, heapSize, max);
        }
    }
}
