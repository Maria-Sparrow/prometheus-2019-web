//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay.domain;

//аналог інклуда на С++
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;



//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову таблицю та/або нове поле!
//анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько підняв при зп. це є зручнішим, ніж просте копіювання рядків з файлу конфігу XML
@Entity
public class Parents {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним новим об'єктом)
    private Integer parentId;
    //  userAccess = 2;
    //  хз чи потрібно воно нам тепер, якщо ми відмовилися від таблиці Users, тобто Doctors тепер не наслідує від Users, бо його просто не існує
    //  але якщо що, то залежно від параметра user_access, який наслідувався від Users, мав відрізнятися рівень доступу до функціоналу сайту

    private String password;
    private String username;

    private String country;
    private String city;
    private String email;
    private String phoneNumber;

    public Parents () { } //чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз

    public Parents (String username, String password, String country, String city, String email, String phone_number)
    {
        this.username = username;
        this.password = password;
        this.country = country;
        this.city = city;
        this.email = email;
        this.phoneNumber = phone_number;
    }

    //методи присвоєння і доступу до даних

    public void setParentId(Integer parent_id) { this.parentId = parent_id; }

    public Integer getParentId() { return parentId; }

    public void setUsername(String userame) { this.username = username; }

    public String getUsername() { return username; }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password; }

    public void setCountry(String country) { this.country = country; }

    public String getCountry() { return country; }

    public void setCity(String city) { this.city = city; }

    public String getCity() { return city; }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPhoneNumber() { return phoneNumber; }
}
