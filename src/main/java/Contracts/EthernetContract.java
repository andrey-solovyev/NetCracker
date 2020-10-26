package Contracts;

import People.Client;

import java.util.Calendar;

public class EthernetContract extends Contract {
    private int max_speed;

    public EthernetContract(Calendar date_contract, Calendar date_end_contract, Client client, int max_speed) {
        super(date_contract, date_end_contract, client);
        this.max_speed = max_speed;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }
}

