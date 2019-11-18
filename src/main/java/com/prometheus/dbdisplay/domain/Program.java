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
public class Program {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним новим об'єктом)
    private int programId;

    private String programType;
    private Integer dailyProgress;
    private String comment;

    public Program() { } //чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз

    //конструктор нового об'єкта
    public Program(String program_type, Integer daily_progress, String comment)
    {
        this.programType = program_type;
        this.dailyProgress = daily_progress;
        this.comment = comment;
    }

    //методи присвоєння і доступу до даних

    public void setProgramId(int program_id) { this.programId = program_id; }

    public int getProgramId() { return programId; }

    public void setProgramType(String program_type) { this.programType = program_type; }

    public String getProgramType() { return programType; }

    public void setDailyProgress(Integer daily_progress) { this.dailyProgress = daily_progress; } //треба якось реалізувати фунцію, яка залежно від кількості виконаних тасків виставляє значення само

    public Integer getDailyProgress() { return dailyProgress; }

    public void setComment(String comment) { this.comment = comment; }

    public String getComment() { return comment; }

}

