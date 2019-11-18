//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay;

//аналог інклуда на С++
import com.prometheus.dbdisplay.domain.*;
import com.prometheus.dbdisplay.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;



//контролер - це модуль, який по шляху, вказаному в дужках в @GetMapping (напр. /greeting), слухає запити юзера і повертає якісь дані
@Controller
public class WebsiteController {
    //грубо кажучи, завдяки цьому не треба гріти голову про те, як передати класу інформацію
    @Autowired
    private ProgramRepo programRepo;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private DoctorsRepo doctorsRepo;
    @Autowired
    private ParentsRepo parentsRepo;
    @Autowired
    private KidsRepo kidsRepo;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        return "main";
    }

    //на сторінці localhost:8080/programs виведе всі програми та таски
    @GetMapping("programs")
    public String programs(Map<String, Object> model) {
       Iterable<Program> programs = programRepo.findAll();
       model.put("programs", programs);
        // придумати, як пов'язувати програми і таски цих програм

        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);

        return "programs";
    }

    @PostMapping("addprogram")  //додати нову програму
    public String addProgram(@RequestParam String programType, @RequestParam Integer dailyProgress, @RequestParam String comment, Map<String, Object> model) //@RequestParam бере дані з форми вводу (див. users.mustache)
    {
        Program program = new Program(programType, dailyProgress, comment);
        programRepo.save(program);

        Iterable<Program> programs = programRepo.findAll();
        model.put("programs", programs);
        return "redirect:/programs";
    }

    @PostMapping("addtask")     //додати нову таску
    public String addTask(@RequestParam String taskText, @RequestParam Boolean status, @RequestParam String comment, Map<String, Object> model) //@RequestParam бере дані з форми вводу (див. users.mustache)
    {
        Task task = new Task(taskText, status, comment);
        taskRepo.save(task);
        //і якусь кнопку виведення (скоріш за все вона буде як окремий @GetMapping як filter (див. нижче)
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "redirect:/programs";
    }

    @PostMapping("profil")
    public String programsFilter(@RequestParam String pfilter, Map<String, Object> model) { //@RequestParam бере дані з форми фільтра (див. programs.mustache)
       Iterable<Program> programs;
        //перевіряє, чи пусте поле; якщо ні, робить пошук, якщо так, виводить все
        if (pfilter != null && !pfilter.isEmpty()) {
            programs = programRepo.findByProgramType(pfilter);
        } else {
            programs = programRepo.findAll();
        }
        model.put("programs", programs);

        return "programs";
    }

    @PostMapping("tasfil")
    public String tasksFilter(@RequestParam Integer tfilter, Map<String, Object> model) {

        Iterable<Task> tasks;
        //перевіряє, чи пусте поле; якщо ні, робить пошук, якщо так, виводить все
        if (tfilter != null) {
            tasks = taskRepo.findByTaskId(tfilter);
        } else {
            tasks = taskRepo.findAll();
        }
        model.put("tasks", tasks);

        return "programs";
    }

    //на сторінці localhost:8080/users виведе всіх лікарів, дітей, батьків і їхні поля в БД
    @GetMapping("users")
    public String users(Map<String, Object> model) {
        Iterable<Doctors> doctors = doctorsRepo.findAll();
        model.put("doctors", doctors);

        Iterable<Parents> parents = parentsRepo.findAll();
        model.put("parents", parents);

        Iterable<Kids> kids = kidsRepo.findAll();
        model.put("kids", kids);

        return "users";
    }

    @PostMapping("adddoctor")    //можливість додавати нового лікаря в БД
    public String addDoctor(@RequestParam String name, @RequestParam String gender, @RequestParam String organization, @RequestParam String specialty,
                      @RequestParam String country, @RequestParam String city, @RequestParam String dateOfBirth, @RequestParam String email,
                      @RequestParam String phoneNumber, @RequestParam String password, Map<String, Object> model) throws ParseException //@RequestParam бере дані з форми вводу (див. users.mustache)
    {
        Doctors doctor = new Doctors(name, password, gender, dateOfBirth, organization, specialty, country, city, email, phoneNumber);
        doctorsRepo.save(doctor);

        Iterable<Doctors> doctors = doctorsRepo.findAll();
        model.put("doctors", doctors);
        return "redirect:/users";
    }

    @PostMapping("addparent") //можливість додавати нових батьків в БД
    public String addParent(@RequestParam String username, @RequestParam String country, @RequestParam String city, @RequestParam String email,
                      @RequestParam String phoneNumber, @RequestParam String password, Map<String, Object> model) //@RequestParam бере дані з форми вводу (див. users.mustache)
    {
        Parents parent = new Parents(username, password, country, city, email, phoneNumber);
        parentsRepo.save(parent);

        Iterable<Parents> parents = parentsRepo.findAll();
        model.put("parents", parents);
        return "redirect:/users";
    }

    @PostMapping("addkid") //можливість додавати нову дитину в БД
    public String addKid(@RequestParam String name, @RequestParam String gender, @RequestParam String diagnose, @RequestParam String country,
                      @RequestParam String city, @RequestParam String dateOfBirth, @RequestParam Integer weight, @RequestParam Integer height,
                      @RequestParam String bloodType, Map<String, Object> model) throws ParseException //@RequestParam бере дані з форми вводу (див. users.mustache)
    {
        Kids kid = new Kids(name, gender, diagnose, country, city, dateOfBirth, weight, height, bloodType);
        kidsRepo.save(kid);

        Iterable<Kids> kids = kidsRepo.findAll();
        model.put("kids", kids);
        return "redirect:/users";
    }

    //після натискання кнопки "Find" переходить на сторінку localhost:8080/users/docfil, де виводить або все, що знайшло за певним полем, або виводить всі повідомлення (якщо поле пусте)
    @PostMapping("docfil") //а тут вказується мепінг, бо працюємо вже з localhost:8080/users/docfil
    public String doctorsFilter(@RequestParam String dfilter, Map<String, Object> model) { //@RequestParam бере дані з форми фільтра (див. users.mustache)
        Iterable<Doctors> doctors;
        //перевіряє, чи пусте поле; якщо ні, робить пошук, якщо так, виводить все
        if (dfilter != null && !dfilter.isEmpty()) {
            doctors = doctorsRepo.findByName(dfilter);
        } else {
            doctors = doctorsRepo.findAll();
        }
        model.put("doctors", doctors);
        return "users";
    }

    @PostMapping("parfil")
            public String parentsFilter(@RequestParam String pfilter, Map<String, Object> model) {
        Iterable<Parents> parents;
        //перевіряє, чи пусте поле; якщо ні, робить пошук, якщо так, виводить все
        if (pfilter != null && !pfilter.isEmpty()) {
            parents = parentsRepo.findByUsername(pfilter);
        } else {
            parents = parentsRepo.findAll();
        }
        model.put("parents", parents);

        return "users";
    }

    @PostMapping("kidfil")
            public String kidsFilter(@RequestParam String kfilter, Map<String, Object> model) {
        Iterable<Kids> kids;
        //перевіряє, чи пусте поле; якщо ні, робить пошук, якщо так, виводить все
        if (kfilter != null && !kfilter.isEmpty()) {
            kids = kidsRepo.findByName(kfilter);
        } else {
            kids = kidsRepo.findAll();
        }
        model.put("kids", kids);

        return "users";
    }

}