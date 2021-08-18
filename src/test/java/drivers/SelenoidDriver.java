package drivers;

import com.codeborne.selenide.Configuration;
import config.Project;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelenoidDriver {

    public static void configure() {
        Configuration.browserVersion = Project.deviceConfig.browserVersion();
        Configuration.browser = Project.deviceConfig.browser();
        Configuration.browserSize = Project.deviceConfig.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.remote = String.format(
                Project.deviceConfig.hubUrl(),
                Project.deviceConfig.hubUsername(),
                Project.deviceConfig.hubPassword());

        Configuration.browserCapabilities = capabilities;
    }

}
