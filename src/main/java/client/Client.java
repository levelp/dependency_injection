package client;

import server.Service;
import server.ServiceExample;

// Пример без использования Dependency injection:
// Клиент напрямую управляет созданием сервиса, к которому потом обращается (владеет им)
public class Client {
    // Внутренняя ссылка на сервис, используемый этим клиентом
    private Service service;

    // Конструктор
    Client() {
        // Указываем конкретную реализацию сервиса вместо использования Dependency Injection
        this.service = new ServiceExample();
    }

    // Пример метода, который использует сервис
    public String greet() {
        return "Hello " + this.service.getName();
    }
}