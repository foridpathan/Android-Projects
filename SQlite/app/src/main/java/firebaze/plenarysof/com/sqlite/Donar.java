package firebaze.plenarysof.com.sqlite;


public class Donar {
    private int id;
    private String name;
    private String email;
    private String number;
    private String blood_group;
    private String date;

    public Donar(int id, String name, String email, String number, String blood_group, String date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.blood_group = blood_group;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
