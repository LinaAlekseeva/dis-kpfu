package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ContainerPage {

    private SelenideElement containerGet =  $(".header-menuTrigger.hamburger_animate1");
    private SelenideElement personalAccount= $("#menu-item-690");
    private SelenideElement serviceDesk= $("#menu-item-689");
    private SelenideElement applications= $("#menu-item-692");
    private SelenideElement seeAll = $(".menu-item/menu-item-readmore");
    private SelenideElement error = $(".error404.wp-embed-responsive");
    private SelenideElement containerNameSearch = $(".container");
    private SelenideElement moduleDescription = $(".page-content.container ");
    public ContainerPage openContainer() {
        containerGet.click();
        return this;
    }
    public ContainerPage openPagePersonalAccount() {
        personalAccount.click();
        return this;
    }
    public ContainerPage openPageServiceDesk() {
        serviceDesk.click();
        personalAccount.click();
        return this;
    }
    public ContainerPage openPageApplications() {
        applications.click();
        personalAccount.click();
        return this;
    }
    public ContainerPage openPageSeeAll() {

            seeAll.click();
            personalAccount.click();
            error.getClass();
        return this;
    }
    public ContainerPage verifyResultsModalAppears() {
        moduleDescription.should(appear);
        moduleDescription.shouldHave(text("Описание модуля"));
        return this;
    }
    public ContainerPage verifyResults(String value) {
        containerNameSearch.$(byText(value)).parent()
                .shouldHave(text(value));
        return this;
    }
}
