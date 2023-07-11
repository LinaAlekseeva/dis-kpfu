package tests;


import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class Container extends TestBase {

    @Test
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    @Owner("Lina Alekseeva")
    void containerTest() {
        step("Проверить ссылки в container", () -> {
            open("/");
            containerPage.openContainer()
                    .openPagePersonalAccount()
                    .verifyResultsModalAppears()
                    .verifyResults(personalAccount)
                    .openPageServiceDesk()
                    .verifyResultsModalAppears()
                    .verifyResults(serviceDesk)
                    .openPageApplications()
                    .verifyResultsModalAppears()
                    .verifyResults(applications)
                    .openPageSeeAll()
                    .verifyResultsModalAppears()
                    .verifyResults(seeAll);


        });
    }
}