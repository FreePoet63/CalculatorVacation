# CalculatorVacation
Приложение "Калькулятор отпускных".
Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculacte"

Минимальные требования: Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.

Проверяться будет чистота кода, структура проекта, название полей\классов, правильность использования паттернов. Желательно написание юнит-тестов, проверяющих расчет.

## Стек проекта
OpenJDK Java 17

Maven

Spring Boot

Lombok

Log4j2

JUnit 5

Mockito

## Инструкция для запуска
Приложение запускается с параметрами, по адресу 

http://localhost:8080/calculacte?salary={salary}&vacationDays={vacationDays} 

или

http://localhost:8080/calculacte?salary={salary}&vacationDays={vacationDays}&startVacation={startVacation}&endVacation={endVacation}

{salary}, {vacationDays}, {startVacation}, {endVacation} - показаны, как пример, используются любые валидные параметры, например:

http://localhost:8080/calculacte?salary=1000&vacationDays=10

или 

http://localhost:8080/calculacte?salary=1000}&vacationDays=10&startVacation=2024-01-01&endVacation=2024-01-10

Параметры проверяются на валидность.

Приложение покрыто на 80 процентов Unit - тестами.
