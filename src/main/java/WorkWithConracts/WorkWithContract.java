package WorkWithConracts;

import Contracts.Contract;

import java.util.Arrays;
import java.util.Comparator;

public class WorkWithContract {
    private Contract[] contracts;
    private int last_index = 0;

    public WorkWithContract() {
        this.contracts = new Contract[10];
    }

    private void expandArrays() {
        setContracts(Arrays.copyOf(getContracts(), getContracts().length * 2));
    }

    public Contract getContractById(int id) {
        return getContracts()[binarySearch(id, 0, getContracts().length - 1)];
    }

    public void addNewContract(Contract contract) {
        if (last_index == getContracts().length) {
            expandArrays();
        }
        getContracts()[last_index] = contract;
        last_index++;
        if (last_index>2){
        quickSort(0, last_index-1);}
    }

    public void quickSort(int low, int high) {
        if (getContracts().length == 0)
            return;

        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int opora = getContracts()[middle].getId();

        int i = low, j = high;
        while (i <= j) {
            while (getContracts()[i].getId() < opora) {
                i++;
            }

            while (getContracts()[j].getId() > opora) {
                j--;
            }

            if (i <= j) {
                Contract temp = getContracts()[i];
                getContracts()[i] = getContracts()[j];
                getContracts()[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }

    public int binarySearch(int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (getContracts()[mid].getId() < key) {
                low = mid + 1;
            } else if (getContracts()[mid].getId() > key) {
                high = mid - 1;
            } else if (getContracts()[mid].getId() == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public Contract[] getContracts() {
        return contracts;
    }

    public void setContracts(Contract[] contracts) {
        this.contracts = contracts;
    }
}
