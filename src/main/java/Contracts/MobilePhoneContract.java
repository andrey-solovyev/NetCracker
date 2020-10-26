package Contracts;

import People.Client;

import java.util.Calendar;
import java.util.UUID;

public class MobilePhoneContract extends Contract {
    private int minites;
    private int megabytes;
    private int sms;

    public MobilePhoneContract(Calendar date_contract, Calendar date_end_contract, Client client, int minites, int megabytes, int sms) {
        super(date_contract, date_end_contract, client);
        this.minites = minites;
        this.megabytes = megabytes;
        this.sms = sms;
    }

    public int getMinites() {
        return minites;
    }

    public void setMinites(int minites) {
        this.minites = minites;
    }

    public int getMegabytes() {
        return megabytes;
    }

    public void setMegabytes(int megabytes) {
        this.megabytes = megabytes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }
}

