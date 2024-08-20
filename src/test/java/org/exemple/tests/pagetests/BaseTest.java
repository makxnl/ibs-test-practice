package org.exemple.tests.pagetests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    /** С этой конструкцией не работает, первый тест проходит, следующие падают
     * с ошибкой NoSuchSessionException: invalid session id. Не получилось разобраться почему.
     */

//    @BeforeAll
//    static void beforeAll() {
//        System.setProperty("webdriver.chrome.driver", "C:\\ideaProject"
//                + "\\ibsTest1\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @BeforeEach
//    void beforeEach() {
//        driver.get("http://localhost:8080/food");
//        driver.manage().window().maximize();
//    }
//
//    @AfterEach
//    void afterEach() {
//        driver.close();
//    }
//
//    @AfterAll
//    static void afterAll() {
//        driver.quit();
//    }

    /** С этой конструкцией всё тесты проходят
     */

    @BeforeEach
    void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\ideaProject"
                + "\\ibsTest1\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/food");
        driver.manage().window().maximize();
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }

}
