//репозиторій працює з об'єктами бази даних, які містяться поза оперативною пам'яттю в момент виконання запиту.йому передається критерій, за яким він
// обирає один або кілька об'єктів (бо всі не потрібні!)

//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay.repository;

//аналог інклуда на С++
import com.prometheus.dbdisplay.domain.Kids;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

//інтерфейс, який забезпечує основні операції по пошуку, зберіганню, видаленню даних
public interface KidsRepo extends CrudRepository<Kids, Long> {
    List<Kids> findByName(String name); //цей метод формується за принципом findBy + назва параметра, за яким буде здійснюватися пошук (фільтрація)
}
