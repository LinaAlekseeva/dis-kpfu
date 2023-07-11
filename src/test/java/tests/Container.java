package tests;


import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class Container extends TestBase {

    @Test
    @Tag("containerTest")
    @DisplayName("Successful open")
    @Owner("Lina Alekseeva")
    void containerSuccessfulTest() {
        step("Личный кабинет сотрудника", () -> {
            open("/");
            containerPage.openContainer()
                    .openPagePersonalAccount()
                    .verifyResultsModalAppears()
                    .verifyResults(personalAccount);
        });
        step("Модуль «Service Desk»", () -> {
            open("/");
            containerPage.openContainer()
                    .openPageServiceDesk()
                    .verifyResultsModalAppears()
                    .verifyResults(serviceDesk);
        });
        step("Модуль «Заявки на IT-услуги»", () -> {
            open("/");
            containerPage.openContainer()
                    .openPageApplications()
                    .verifyResultsModalAppears()
                    .verifyResults(applications);
        });

    }

    @Test
    @Tag("containerTest")
    @DisplayName("Failed open")
    @Owner("Lina Alekseeva")
    void containerFailedTest() {
        step("Тест на модуль: «Смотреть все»", () -> {
            open("/");
            containerPage.openContainer()
                    .openPageSeeAll()
                    .verifyResultsModalAppears()
                    .verifyResults(seeAll);
        });
    }
}

