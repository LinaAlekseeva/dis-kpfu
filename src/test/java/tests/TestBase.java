package tests;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import page.ContainerPage;

public class TestBase {
    public ContainerPage containerPage = new ContainerPage();
    String personalAccount ="Личный кабинет сотрудника";
    String serviceDesk ="Модуль «Service Desk»";
    String applications ="Модуль «Заявки на IT-услуги»";
    String seeAll ="Смотреть все";


    @BeforeAll
    static void setConfigurationParameters() {

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();

        if (config.isRemoteWebDriver()) {
            Configuration.remote = config.getRemoteURL();
        }
    }

}