//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay.domain;

//аналог інклуда на С++
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову таблицю та/або нове поле!
//анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько підняв при зп. це є зручнішим, ніж просте копіювання рядків з файлу конфігу XML
@Entity
public class Doctors {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним новим об'єктом)
    private Integer doctorId;
    //  userAccess = 1;
    //  хз чи потрібно воно нам тепер, якщо ми відмовилися від таблиці Users, тобто Doctors тепер не наслідує від Users, бо його просто не існує
    //  але якщо що, то залежно від параметра user_access, який наслідувався від Users, мав відрізнятися рівень доступу до функціоналу сайту

    private String name;
    private String gender;
    private String organization;
    private String specialty;
    private String country;
    private String city;
    private Date dateOfBirth;

    private String email;
    private String phoneNumber;
    private String password;


    public Doctors() { } //чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз

    //конструктор нового об'єкта
    public Doctors(String name, String password, String gender, String date_of_birth, String organization, String specialty, String country, String city, String email, String phone_number) throws ParseException {
        this.name = name;
        this.gender = gender;
        this.organization = organization;
        this.specialty = specialty;
        this.country = country;
        this.city = city;
        this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(date_of_birth);
        this.email = email;
        this.phoneNumber = phone_number;
        this.password = password;
    }

    //методи присвоєння і доступу до даних

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    public void setGender(String gender) { this.gender = gender; }

    public String getGender() { return gender; }

    public void setOrganization(String organization) { this.organization = organization; }

    public String getOrganization() { return organization; }

    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getSpecialty() { return specialty; }

    public void setCountry(String country) { this.country = country; }

    public String getCountry() { return country; }

    public void setCity(String city) { this.city = city; }

    public String getCity() { return city; }

    public void setDateOfBirth(String date_of_birth) throws ParseException {    this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(date_of_birth); }

    public Date getDateOfBirth() { return dateOfBirth; }

    public void setDoctorId(Integer doctor_id) { this.doctorId = doctor_id; }

    public Integer getDoctorId() { return doctorId; }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email; }

    public void setPhoneNumber(String phone_number) { this.phoneNumber = phone_number; }

    public String getPhoneNumber() { return phoneNumber; } //отут мені не подобається

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password; }

}