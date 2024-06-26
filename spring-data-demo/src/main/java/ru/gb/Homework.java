package ru.gb;

public class Homework {
    /*
    * 0 - Переварить всё, что было изучено
    * 1 - Доделать сервис управление книгами:
    * 1.1 - Реализовать контроллер по управление книгами с ручками:
    *   Get /book/{id} - получить описание книги,
    *   Delete /book/{id} - удалить книгу,
    *   Post /book - создать книгу
    * 1.2 - Реализовать коннтроллер по управлению читателями(аналогично контроллеру с книгами 1.1)
    * 1.3 - В контроллере issueController добавить ресурс: Get /issue/{id} - получить описания факта выдачи
    *
    ** 2.1 - В сервис issueService добавить проверку, что у пользователя на руках нет книг. Если есть - не выдавать книгу (статус ответа - 404 Conflict)
    ** 2.2 - В сервис читателя добавить ручку Get /reader/{id}/issue - вернуть список всех выдачей для данного читателя
    *
    *    *    * */

    /*
    * 1. В предыдущий проект(где была библиотека с книгами, выдачами и читателями) добавить следующие ресурсы,
    *   которые возвращают готовые HTML-страницы(т.е. это просто Controller'ы)
    * 1.1 /ui/books/ - на странице должен отобразиться список всех доступных книг в системе.
    * 1.2 /ui/reader - аналогично 1.1
    * 1.3 /ui/issues - на странице отоброжаеться таблица, в которой есть столбцы(книга, читатель, когда взял, когда вернул,
    * (если не вернул - пустая ячейка))
    *
    * */

    /*
    * Домашнее задание:
    * 1. Подключить базу данных  к проекту "библиотека", который разрабатывали на прошлых уроках.
    * 1.1 Подключить spring-boot-starter-data-jpa (и необходимый драйвер) и указать параметры соединения в application.yml
    * 1.2 Для книги читателя и факта выдачи описать JPA-сущности.
    * 1.3 Заменить самописный репозиторий на JPA-репозиторий.
    * */
}
