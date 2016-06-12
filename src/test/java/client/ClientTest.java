package client;

import org.junit.Assert;
import org.junit.Test;
import server.Service;
import server.ServiceExample;

public class ClientTest extends Assert {
    /**
     * Без использования Dependency injection
     */
    @Test
    public void testClient() {
        Client client = new Client();
        assertEquals("Hello Service: ServiceExample", client.greet());
    }

    /**
     * [1] Constructor injection - передаём объект как параметр конструктора
     */
    @Test
    public void testConstructorInjection() {
        // Создаём сначала сервис (от него зависит клиент)
        // IoC-контейнер разбирает дерево зависимостей
        Service service = new ServiceExample();
        // Теперь создаём клиент используя service как параметр конструктора
        Client client = new Client(service);
        // Используем клиент
        assertEquals("Hello Service: ServiceExample", client.greet());
    }
}
