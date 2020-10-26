package Contracts;

import Packages.Package;
import People.Client;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

public class DigitalTVContract extends Contract {
    private Package package_tv;

    public DigitalTVContract(Calendar date_contract, Calendar date_end_contract, Client client, Package package_tv) {
        super(date_contract, date_end_contract, client);
        this.package_tv = package_tv;
    }


    public Package getPackage_tv() {
        return package_tv;
    }

    public void setPackage_tv(Package package_tv) {
        this.package_tv = package_tv;
    }
}
