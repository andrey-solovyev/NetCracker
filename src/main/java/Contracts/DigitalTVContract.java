package Contracts;

import java.util.Calendar;
import java.util.UUID;

public class DigitalTVContract extends Contract {
    private Package package_tv;

    public DigitalTVContract(UUID id, Calendar date_contract, Calendar date_end_contract, Package package_tv) {
        super(id, date_contract, date_end_contract);
        this.package_tv = package_tv;
    }

    public Package getPackage_tv() {
        return package_tv;
    }

    public void setPackage_tv(Package package_tv) {
        this.package_tv = package_tv;
    }
}
