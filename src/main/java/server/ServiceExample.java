package server;

/**
 * Пример реализации сервиса
 */
public class ServiceExample implements Service {
    public ServiceExample() {
        System.out.println("ServiceExample constructor");
    }

    @Override
    public String getName() {
        return "Service: ServiceExample";
    }
}
