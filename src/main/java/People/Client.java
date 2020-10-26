package People;


import java.util.Calendar;
/**
 * Класс продукции со свойствами <b>Id</b>, <b>fcs</b>,<b>date_births</b>,<b>is_male</b>,<b>passport_data</b>.
 * @autor Андрей Соловьем
 */
public class Client {
//Клиент - отдельная сущность ID, фио, дата_рождения, пол, номер_серия_паспорта
private static int countId;
    /** Поле id */
    private int Id;
    /** Поле фио */
    private String fcs;
    /** Поле дата_рождения */
    private Calendar date_births;
    /** Поле пол */
    private boolean is_male;
    /** Поле номер_серия_паспорта */
    private String passport_data;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param fcs - фио
     * @param date_births - дата_рождения
     * @param is_male - пол
     * @param passport_data - номер_серия_паспорта
     * @see Client()
     */
    public Client(String fcs, Calendar date_births, boolean is_male, String passport_data) {
        Id = ++countId;
        this.fcs = fcs;
        this.date_births = date_births;
        this.is_male = is_male;
        this.passport_data = passport_data;
    }
    /** getter and setter */

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFcs() {
        return fcs;
    }

    public void setFcs(String fcs) {
        this.fcs = fcs;
    }

    public Calendar getDate_births() {
        return date_births;
    }

    public void setDate_births(Calendar date_births) {
        this.date_births = date_births;
    }

    public boolean isIs_male() {
        return is_male;
    }

    public void setIs_male(boolean is_male) {
        this.is_male = is_male;
    }

    public String getPassport_data() {
        return passport_data;
    }

    public void setPassport_data(String passport_data) {
        this.passport_data = passport_data;
    }
    /**
     * Функция получения возраста
     * @return возвращает влзраст клиента
     */
    public String getAge(){
        long diff = Calendar.getInstance().getTimeInMillis() - getDate_births().getTimeInMillis();
        long ddays = diff / (24 * 60 * 60 * 1000);
        long years = ddays/365;
        return ""+years;
    }
}
