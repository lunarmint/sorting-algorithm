package project1;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort {

    public void quickSort(List<Product> arrList) {
        quickSort(arrList, 0, arrList.size() - 1);
    }

    private void quickSort(List<Product> arrList, int low, int high) {
        if (low < high + 1) {
            int pi = partition(arrList, low, high);
            quickSort(arrList, low, pi - 1);
            quickSort(arrList, pi + 1, high);
        }
    }

    private int getPivot(int low, int high) {
        Random r = new Random();
        return r.nextInt((high - low) + 1) + low;
    }

    private int partition(List<Product> arrList, int low, int high) {
        Collections.swap(arrList, low, getPivot(low, high));
        int lower = low + 1;
        for(int i = lower; i <= high; i++) {
            if(arrList.get(i).getCode() < arrList.get(low).getCode()) {
                Collections.swap(arrList, i, lower++);
            }
        }
        Collections.swap(arrList, low, lower - 1);
        return lower - 1;
    }
}
