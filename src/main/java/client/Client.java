package client;

import server.Service;
import server.ServiceExample;
import server.ServiceSetter;

// Пример без использования Dependency injection:
// Клиент напрямую управляет созданием сервиса, к которому потом обращается (владеет им)
//
// Разберём 3 вида Dependency injection:
//  [1] Constructor injection - передаём объект как параметр конструктора
//  [2] Setter injection - через setter
//  [3] Interface injection - используя специальный интерфейс
public class Client implements ServiceSetter {
    // Счётчик объектов
    static int count = 0;
    // Идентификатор объекта
    int id = ++count;
    // Внутренняя ссылка на сервис, используемый этим клиентом
    private Service service;

    // Конструктор без DI со специальным сообщением
    Client(String message) {
        System.out.println("Client #" + id + " constructor: " + message);
        // Указываем конкретную реализацию сервиса вместо использования Dependency Injection
        this.service = new ServiceExample();
    }

    Client() {
        System.out.printf("Client #%d default constructor%n", id);
    }

    // 1. Constructor injection
    Client(Service service) {
        // Сохраняем переданный нам сервис
        this.service = service;
        System.out.println("Client #" + id + " service constructor");
    }

    // [2] Setter injection - через setter
    // [3] Interface injection - используя специальный интерфейс
    @Override
    public void setService(Service service) {
        this.service = service;
        System.out.println("Client.setService");
    }

    // Пример метода, который использует сервис
    public String greet() {
        return "Hello " + this.service.getName();
    }
}