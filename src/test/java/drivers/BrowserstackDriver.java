package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.BrowserstackConfig;
import configs.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", config.username());
        mutableCapabilities.setCapability("browserstack.key", config.password());

        // Set URL of the application under test
//        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        mutableCapabilities.setCapability("app", mobileConfig.bs());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", mobileConfig.mobileDevice());
        mutableCapabilities.setCapability("os_version", mobileConfig.mobileVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", mobileConfig.project());
        mutableCapabilities.setCapability("build", mobileConfig.build());
        mutableCapabilities.setCapability("name", mobileConfig.name());


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}