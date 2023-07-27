package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})
public interface MobileConfig extends Config {
    @Key("mobile.version")
    String mobileVersion();
    @Key("bs")
    String bs();
    @Key("project")
    String project();
    @Key("build")
    String build();
    @Key("name")
    String name();

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