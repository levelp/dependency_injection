package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import server.Service;

/**
 * Демонстрация автоматического подключения нескольких Beans
 */
public class AutowiredDemo {
    @Autowired
    Service service;

    @Autowired
    @Qualifier("client2")
    Client client;

    public String callClient() {
        return client.greet();
    }
}
