
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasicTest {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        //options.setApp("src/test/java/resources/ApiDemos-debug.apk");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/mda-1.0.13-15.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        System.out.println("App launched successfully on emulator!");
        Thread.sleep(5000);
        driver.quit();
    }
}
