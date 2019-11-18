//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay.domain;

//аналог інклуда на С++
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову таблицю та/або нове поле!
//анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько підняв при зп. це є зручнішим, ніж просте копіювання рядків з файлу конфігу XML
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним новим об'єктом)
    private int adminId;
    private String username;
    private String password;

    public Admin() { } //чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз

    //конструктор нового об'єкта
    public Admin(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    //методи присвоєння і доступу до даних

    public void setAdminId(Integer id) {
        this.adminId = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() {
        return password;
    }

}

