package People;


import java.util.Calendar;

public class Client {
//Клиент - отдельная сущность ID, фио, дата_рождения, пол, номер_серия_паспорта
private static int countId;
    private int Id;
    private String fcs;
    private Calendar date_births;
    private boolean is_male;
    private String passport_data;

    public Client(String fcs, Calendar date_births, boolean is_male, String passport_data) {
        Id = ++countId;
        this.fcs = fcs;
        this.date_births = date_births;
        this.is_male = is_male;
        this.passport_data = passport_data;
    }

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
    public String getAge(){
        long diff = Calendar.getInstance().getTimeInMillis() - getDate_births().getTimeInMillis();
        long ddays = diff / (24 * 60 * 60 * 1000);
        long years = ddays/365;
        return ""+years;
    }
}
