//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay.domain;

//аналог інклуда на С++
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову таблицю та/або нове поле!
//анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько підняв при зп. це є зручнішим, ніж просте копіювання рядків з файлу конфігу XML
@Entity
public class Kids {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним новим об'єктом)
    private Integer kidId;

    private String name;
    private String gender;
    private String diagnose;
    private String country;
    private String city;
    private Date dateOfBirth;
    private Integer weight;
    private Integer height;
    private String bloodType;

    public Kids () { } //чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз

    public Kids (String name, String gender, String diagnose, String country, String city, String date_of_birth, Integer weight, Integer height, String blood_type) throws ParseException {
        this.name = name;
        this.gender = gender;
        this.diagnose = diagnose;
        this.country = country;
        this.city = city;
        this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(date_of_birth);
        this.weight = weight;
        this.height = height;
        this.bloodType = blood_type;
    }

    //методи присвоєння і доступу до даних

    public void setKidId(Integer id) { this.kidId = id; }

    public Integer getKidId() { return kidId; }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    public void setGender(String gender) { this.gender = gender; }

    public String getGender() { return gender; }

    public void setDiagnose(String diagnose) { this.diagnose = diagnose; }

    public String getDiagnose() { return diagnose; }

    public void setCountry(String country) { this.country = country; }

    public String getCountry() { return country; }

    public void setCity(String city) { this.city = city; }

    public String getCity() { return city; }

    public void setDateOfBirth(String date_of_birth) throws ParseException {  this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(date_of_birth); }

    public Date getDateOfBirth() { return dateOfBirth; }

    public void setWeight(Integer weight) { this.weight = weight; }

    public Integer getWeight() { return weight; }

    public void setHeight(Integer height) { this.height = height; }

    public Integer getHeight() { return height; }

    public void setBloodType(String blood_type) { this.bloodType = blood_type; }

    public String getBloodType() { return bloodType; }

}
