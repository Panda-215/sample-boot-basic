package th.mfu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    //บอกตัวจาวาว่าประกาศตัวแปรมาหนึ่งตัว ใช้สำหรับส่งค่าใส่ให้กับcontroller โดยไม่ต้องnew
    private HelloController controller;

    @Test
    //ใช้สำหรับเทส
    public void testHello() {

        // Act รับมาจากรีเทิน
        String response = controller.hello();
        // Assert
        assertEquals("Hello World!", response);
        //เช็คว่าตรงกันมั้ย
    }
}
