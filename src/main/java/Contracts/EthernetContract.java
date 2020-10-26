package Contracts;

import People.Client;

import java.util.Calendar;
/**
 * Класс Контракт на проводной интернет со свойствами <b>max_speed</b> и наследованными полями.
 * @autor Андрей Соловьем
 */
public class EthernetContract extends Contract {
    /** Поле максимальная скорость */
    private int max_speed;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param date_contract - дата начала
     * @param date_end_contract - дата конца
     * @param client - клиент
     * @param max_speed - пакет
     * @see EthernetContract()
     */
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

