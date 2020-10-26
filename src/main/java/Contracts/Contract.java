package Contracts;

import People.Client;

import java.util.Calendar;

/**
 * Класс Контракт со свойствами <b>Id</b>, <b>date_contract</b>,<b>date_end_contract</b>,<b>client</b>.
 * @autor Андрей Соловьем
 */
public abstract class Contract implements Comparable<Contract> {
    //private UUID Id; Один из способов сделать уникальный id
    private static int countId;
    /** Поле id */
    private int Id;
    /** Поле Календарь начала контракта */
    private Calendar date_contract;
    /** Поле Календарь окончания контракта  */
    private Calendar date_end_contract;
    /** Поле клиент */
    private Client client;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param date_contract - дата начала
     * @param date_end_contract - дата конца
     * @param client - клиент
     * @see Contract()
     */
    public Contract(Calendar date_contract, Calendar date_end_contract, Client client) {
        this.Id = ++countId;
        this.date_contract = date_contract;
        this.date_end_contract = date_end_contract;
        this.client = client;
    }

    /** Getter and setter */

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
    public String getRemainingTime(){
        return RemainingTime();
    }

    /**
     * Функция получения оставшихся дней контракта
     * @return возвращает строку с оставшимся днями
     */
    private String RemainingTime(){
        long diff = getDate_contract().getTimeInMillis() - getDate_end_contract().getTimeInMillis();
        long ddays = diff / (24 * 60 * 60 * 1000);
        return "Осталось дней: "+ddays;
    }

    /** compareTo Используется для сравнений и сортировок */

    @Override
    public int compareTo(Contract o) {
        return getId()- o.getId();
    }
}
