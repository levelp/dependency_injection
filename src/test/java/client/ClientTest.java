package client;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest extends Assert {
    /**
     * Без использования Dependency injection
     */
    @Test
    public void testClient() {
        Client client = new Client();
        assertEquals("Hello Service: ServiceExample", client.greet());
    }
}
