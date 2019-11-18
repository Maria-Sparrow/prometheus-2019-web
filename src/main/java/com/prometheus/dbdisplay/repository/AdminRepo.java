//репозиторій працює з об'єктами бази даних, які містяться поза оперативною пам'яттю в момент виконання запиту.йому передається критерій, за яким він
// обирає один або кілька об'єктів (бо всі не потрібні!)

//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay.repository;

//аналог інклуда на С++
import com.prometheus.dbdisplay.domain.Admin;
import org.springframework.data.repository.CrudRepository;

//інтерфейс, який забезпечує основні операції по пошуку, зберіганню, видаленню даних
public interface AdminRepo extends CrudRepository<Admin, Long> {
  //  List<admin> findByUsername(String adminUsername); //цей метод формується за принципом findBy + назва параметра, за яким буде здійснюватися пошук (фільтрація)
}
