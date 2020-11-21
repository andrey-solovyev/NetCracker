package WorkWithConracts;

import Contracts.Contract;
import Contracts.DigitalTVContract;
import Contracts.EthernetContract;
import Contracts.MobilePhoneContract;
import Packages.Package;
import People.Client;
import Sorts.ISorter;
import Sorts.QuickSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.GregorianCalendar;

public class WorkWithContractTest {

    @Test
    public void getContractById() {
    }

    @Test
    public void addNewContract() {
        Client client = new Client("Ivan", new GregorianCalendar(2017, 0, 25), true, "3333333333");
        Contract contract = new MobilePhoneContract(new GregorianCalendar(2017, 0, 25), new GregorianCalendar(2017, 0, 25), client, 23, 34, 23);
        Contract contract1 = new MobilePhoneContract(new GregorianCalendar(2017, 0, 25), new GregorianCalendar(2017, 0, 25), client, 23, 34, 23);

        Contract contract2 = new DigitalTVContract(new GregorianCalendar(2017, 0, 25), new GregorianCalendar(2017, 0, 25), client, Package.SMALL);

        Contract contract3 = new EthernetContract(new GregorianCalendar(2017, 0, 25), new GregorianCalendar(2017, 0, 25), client, 23);

        Contract contract4 = new MobilePhoneContract(new GregorianCalendar(2017, 0, 25), new GregorianCalendar(2017, 0, 25), client, 23, 34, 23);
        WorkWithContract workWithContract = new WorkWithContract();
        workWithContract.addNewContract(contract3);
        workWithContract.addNewContract(contract);
        workWithContract.addNewContract(contract4);
        workWithContract.addNewContract(contract1);
        workWithContract.addNewContract(contract2);
        ISorter<Contract> sorter = new QuickSort<>();
        Comparator<Contract> comparator = (o1, o2) -> {
            if (o1.getId() == o1.getId()) return 0;
            return o1.getId() > o2.getId() ? 1 : -1;
        };

        sorter.sort(comparator, workWithContract.getContracts(), workWithContract.getLast_index());
        for (Contract c:workWithContract.getContracts()){
            System.out.println(c.getId());
        }
        WorkWithContract workWithContract1 = new WorkWithContract();
        workWithContract1.addNewContract(contract);
        workWithContract1.addNewContract(contract1);
        workWithContract1.addNewContract(contract2);
        workWithContract1.addNewContract(contract3);
        workWithContract1.addNewContract(contract4);
        Assert.assertArrayEquals(workWithContract.getContracts(), workWithContract1.getContracts());
    }

    @Test
    public void getContracts() {
    }
}