package WorkWithConracts;

import Contracts.Contract;

import java.util.Arrays;

public class WorkWithContract {
    public Contract[] contracts;

    public WorkWithContract() {
        this.contracts = new Contract[10];
    }
    private void expandArrays(){
        setContracts(Arrays.copyOf(getContracts(),getContracts().length*2));
    }
//    public Contract getContractById(int id){
//        return id;
//    }

    public Contract[] getContracts() {
        return contracts;
    }

    public void setContracts(Contract[] contracts) {
        this.contracts = contracts;
    }
}
