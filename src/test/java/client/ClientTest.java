package client;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import server.Service;
import server.ServiceExample;
import server.ServiceSetter;

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

    /**
     * [2] Setter injection - через setter
     */
    @Test
    public void testSetterInjection() {
        // Создаём сначала сервис (от него зависит клиент)
        // IoC-контейнер разбирает дерево зависимостей
        Service service = new ServiceExample();
        // Теперь создаём клиент
        Client client = new Client();
        // Указываем клиенту какой сервис использовать
        client.setService(service);
        // Используем клиент
        assertEquals("Hello Service: ServiceExample", client.greet());
    }

    /**
     * [3] Interface injection - используя специальный интерфейс
     */
    @Test
    public void testInterfaceInjection() {
        // Создаём клиент
        Client client = new Client();
        // Создаём сервис
        Service service = new ServiceExample();
        // Указываем клиенту какой сервис использовать
        ServiceSetter setter = client;
        setter.setService(service);
        // Используем клиент
        assertEquals("Hello Service: ServiceExample", client.greet());
    }

    @Test
    public void testConstructorInjectionSpring() {
        BeanFactory beanfactory = new ClassPathXmlApplicationContext("beans.xml");
        // Создаём клиент с помоз
        Client client = (Client) beanfactory.getBean("client");
        // Используем клиент
        assertEquals("Hello Service: ServiceExample", client.greet());
    }
}
