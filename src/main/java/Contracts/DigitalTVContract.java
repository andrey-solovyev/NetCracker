package Contracts;

import Packages.Package;
import People.Client;

import java.util.Calendar;
/**
 * Класс Контракт на цифровое телевидение  со свойствами <b>package_tv</b> и наследованными полями.
 * @autor Андрей Соловьем
 */
public class DigitalTVContract extends Contract {
    /** Поле пакет */
    private Package package_tv;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param date_contract - дата начала
     * @param date_end_contract - дата конца
     * @param client - клиент
     * @param package_tv - пакет
     * @see DigitalTVContract()
     */
    public DigitalTVContract(Calendar date_contract, Calendar date_end_contract, Client client, Package package_tv) {
        super(date_contract, date_end_contract, client);
        this.package_tv = package_tv;
    }

    /** Getter and setter*/

    public Package getPackage_tv() {
        return package_tv;
    }

    public void setPackage_tv(Package package_tv) {
        this.package_tv = package_tv;
    }
}
