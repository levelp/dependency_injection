package client;

import org.springframework.beans.factory.annotation.Autowired;
import server.MyLogger;
import server.Service;

/**
 * Другой клиент, который будет использовать Service
 */
public class OtherClient {
    @Autowired
    MyLogger logger;

    Service myService;

    public void setMyService(Service myService) {
        logger.log("setMyService " + myService);
        this.myService = myService;
    }

    public void doSomething() {
        logger.log("doSomething()");
        myService.doSomethingElse();
    }
}
