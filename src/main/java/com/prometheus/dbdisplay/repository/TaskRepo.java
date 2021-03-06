//репозиторій працює з об'єктами бази даних, які містяться поза оперативною пам'яттю в момент виконання запиту.йому передається критерій, за яким він
// обирає один або кілька об'єктів (бо всі не потрібні!)

//шлях, за яким лежить цей файл
package com.prometheus.dbdisplay.repository;

//аналог інклуда на С++
import com.prometheus.dbdisplay.domain.Task;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

//інтерфейс, який забезпечує основні операції по пошуку, зберіганню, видаленню даних
public interface TaskRepo extends CrudRepository<Task, Long> {
    List<Task> findByTaskId(Integer taskId); //цей метод формується за принципом findBy + назва параметра, за яким буде здійснюватися пошук (фільтрація)
}
