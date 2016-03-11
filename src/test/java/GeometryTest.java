import geometry.Line;
import geometry.Point;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GeometryTest extends Assert {
    @Test
    public void testPoints() {
        BeanFactory beanfactory = new ClassPathXmlApplicationContext("beans.xml");
        // Создаём объект Spring
        Point A = (Point) beanfactory.getBean("pointA");
        System.out.println(A);

        Line line1 = (Line) beanfactory.getBean("line1");
        System.out.println(line1);
        Line line2 = (Line) beanfactory.getBean("line2");
        System.out.println(line2);
    }
}
