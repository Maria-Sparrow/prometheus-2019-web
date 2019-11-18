//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay;

//аналог інклуда на С++
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//штука, яка запускає саму програмку
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}