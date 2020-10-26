package Contracts;

import java.util.Calendar;
import java.util.Comparator;
import java.util.UUID;

public abstract class Contract implements Comparable<Contract> {
    //private UUID Id; Один из способов сделать уникальный id
    private static int countId;
    private int Id;
    private String q;
    private Calendar date_contract;
    private Calendar date_end_contract;

    public Contract(Calendar date_contract, Calendar date_end_contract) {
        this.Id = ++countId;
        this.date_contract = date_contract;
        this.date_end_contract = date_end_contract;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Calendar getDate_contract() {
        return date_contract;
    }

    public void setDate_contract(Calendar date_contract) {
        this.date_contract = date_contract;
    }

    public Calendar getDate_end_contract() {
        return date_end_contract;
    }

    public void setDate_end_contract(Calendar date_end_contract) {
        this.date_end_contract = date_end_contract;
    }
    public long getRemainingTime(){
        return RemainingTime();
    }
    private long RemainingTime(){
        return date_end_contract.getTimeInMillis() - date_contract.getTimeInMillis();
    }

    @Override
    public int compareTo(Contract o) {
        return getId()- o.getId();
    }
}
