//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay.domain;

//аналог інклуда на С++
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



//"об'єкт" таблички з бази даних: повинен називатися як певна табличка і містити всі її поля (однакові за типом і назвою), щоб зіставляти їх з табличкою.
// УВАГА: якщо назва таблички та/або назви змінних не співпадають з тими, що в БД, створює нову таблицю та/або нове поле!
//анотації (@) вказують спрінг буту, які частини коду за що відповідають, щоб він все швиденько підняв при зп. це є зручнішим, ніж просте копіювання рядків з файлу конфігу XML
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //це і @Id кажуть, що наступна змінна - це primary key (автоматично інкрементується з кожним новим об'єктом)
    private int taskId;

    private String taskText;
    private Boolean status;
    private String comment;

    public Task() { } //чомусь потрібно завжди створювати пустий конструктор, інакше воно все летить і не працює. я хз

    //конструктор нового об'єкта
    public Task(String task_text, Boolean status, String comment)
    {
        this.taskText = task_text;
        this.status = status;
        this.comment = comment;
    }

    //методи присвоєння і доступу до даних

    public void setTaskId(int task_id) { this.taskId = task_id; }

    public int getTaskId() { return taskId; }

    public void setTaskText(String task_text) { this.taskText = task_text; }

    public String getTaskText() { return taskText; }

    public void setStatus(Boolean status) { this.status = status; }

    public char getStatus() {
        char s;
        if (status = true)
            s = 'v';
        else
            s = 'x';

        return s; }

    public void setComment(String comment) { this.comment = comment; }

    public String getComment() { return comment; }

}

