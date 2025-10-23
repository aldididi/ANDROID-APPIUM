import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService serviceBuilder;

    @BeforeClass
    public void AppiumConfiguration() throws MalformedURLException {
        // run appium server everytime code running
        AppiumDriverLocalService serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/Users/aldymochamadheryana/.nvm/versions/node/v20.19.5/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        serviceBuilder.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        //options.setApp("src/test/java/resources/ApiDemos-debug.apk");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk");
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }
    @AfterClass
    public void Closing(){
        driver.quit();
        serviceBuilder.stop();
    }
}
