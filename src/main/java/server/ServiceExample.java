package server;

/**
 * Пример реализации сервиса
 */
public class ServiceExample implements Service {
    // Счётчик объектов
    static int count = 0;
    // Идентификатор объекта
    int id = ++count;

    public ServiceExample() {
        System.out.println("ServiceExample #" + id + " constructor");
    }

    @Override
    public String getName() {
        return "Service: ServiceExample";
    }

    @Override
    public void doSomethingElse() {
        System.out.println("ServiceExample.doSomethingElse");
    }
}
