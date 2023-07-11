package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.ContainerPage;

import static com.codeborne.selenide.Selenide.open;


public class TestBase {
        public ContainerPage containerPage = new ContainerPage();
        String personalAccount ="Личный кабинет сотрудника";
        String serviceDesk ="Модуль «Service Desk»";
        String applications ="Модуль «Заявки на IT-услуги»";
        String seeAll ="Смотреть все";
        @BeforeAll
        static void beforeAll() {

            WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

            Configuration.baseUrl = config.getBaseUrl();
            Configuration.browser = config.getBrowser();
            Configuration.browserVersion = config.getBrowserVersion();

            if (config.isRemoteWebDriver()) {
                Configuration.remote = config.getRemoteURL();
            }
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
        @BeforeEach
        void addListener() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            open("https://dis.kpfu.ru/");
        }

        @AfterEach
        void addAttachments() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
            Selenide.closeWindow();
        }
    }