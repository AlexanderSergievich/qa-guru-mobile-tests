package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:android.properties"
})
public interface AndroidConfig extends Config {
    @Key("mobile.version")
    String mobileVersion();

    @Key("mobile.deviceName")
    String mobileDevice();

    @Key("mobile.app.path")
    String mobileAppPath();

    @Key("mobile.platformName")
    String mobilePlatformName();

    @Key("mobile.apppackage")
    String mobileAppPackage();

    @Key("mobile.appactivity")
    String mobileAppActivity();

    @Key("mobile.url")
    String mobileUrl();
}