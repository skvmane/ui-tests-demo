package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:general.properties",
        "classpath:grid.properties"
})
public interface Configuration extends Config {

    @DefaultValue("http")
    String protocol();

    @DefaultValue("local")
    String target();

    @DefaultValue("test")
    String host();

    @DefaultValue("test")
    String port();

    @DefaultValue("en")
    String fakerLocale();

    @DefaultValue("false")
    Boolean headless();

    @DefaultValue("Chrome")
    String browser();

    @DefaultValue("5")
    Integer timeout();

    @DefaultValue("http://automationpractice.com/")
    String baseUrl();

    @DefaultValue("testivanovtest777@gmail.com")
    String username();

    @DefaultValue("Ww343434")
    String password();

}
