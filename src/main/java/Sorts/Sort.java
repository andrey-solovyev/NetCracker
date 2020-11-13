package Sorts;

import Contracts.Contract;
import People.Client;

import java.util.Arrays;
import java.util.Comparator;

public class Sort<T> {
    public void bubbleSort(Comparator<T> comparator, T[] contract,int lastIndex){
        bubbleSortI(comparator,contract,lastIndex);
    }
    private void bubbleSortI(Comparator<T> comparator, T[] contract,int lastIndex){
        boolean sorted = false;
        while (!sorted){
            sorted=true;
            for (int i = 0; i<lastIndex-1; i++) {
                if (comparator.compare(contract[i],contract[i+1]) > 0) {
                    swapElements(contract, i, i + 1);
                }
            }
        }
        for (T c:contract){
            System.out.println(c.toString());
        }
    }

    private void swapElements(T[] array, int firstIndex, int secondIndex) {
        T buf = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buf;
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