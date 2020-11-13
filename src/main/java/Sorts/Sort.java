package Sorts;

import Contracts.Contract;

import java.util.Arrays;
import java.util.Comparator;

public class Sort<T> {
    public void bubbleSort(Comparator<T> comparator, Contract[] contract){

    }
    private void bubbleSortI(Comparator<T> comparator, Contract[] contract){

    }
    public void quickSort(Comparator<T> comparator, T[] contract){
        quickSortI(comparator,contract,0,contract.length-1);
    }
    private void quickSortI(Comparator<T> comparator, T[] contract, int low, int high){
        if (contract.length == 0)
            return;

        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        T opora = contract[middle];

        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(contract[i],opora)<0) {
                i++;
            }
            while (comparator.compare(contract[i],opora)>0) {
                j--;
            }

            if (i <= j) {
                T temp = contract[i];
                contract[i] = contract[j];
                contract[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSortI(comparator,contract,low, j);

        if (high > i)
            quickSortI(comparator,contract,i, high);
    }
}