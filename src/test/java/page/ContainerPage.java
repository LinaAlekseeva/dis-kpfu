package page;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;


public class ContainerPage {


    private SelenideElement containerGet =  $(".header-menuTrigger.hamburger_animate1");
    private SelenideElement personalAccount= $("#menu-item-690");
    private SelenideElement serviceDesk= $("#menu-item-689");
    private SelenideElement applications= $("#menu-item-692");
    private SelenideElement seeAll = $(".menu-item/menu-item-readmore");
    private SelenideElement error = $(".error404.wp-embed-responsive");
    private SelenideElement moduleDescription = $(".page-content.container h1");
    private SelenideElement containerNameSearch = $(".container h1");

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

        return this;
    }
    public ContainerPage openPageApplications() {
        applications.click();

        return this;
    }
    public ContainerPage openPageSeeAll() {

            seeAll.click();

            error.getClass();
        return this;
    }
    public ContainerPage verifyResultsModalAppears() {
        moduleDescription.should(appear);
        moduleDescription.shouldHave(text("Описание модуля"));
        return this;
    }
    public ContainerPage verifyResults(String value) {
        containerNameSearch
                .shouldHave(text(value));
        return this;
    }
}
