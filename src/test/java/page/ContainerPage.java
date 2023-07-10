package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ContainerPage {
    private SelenideElement containerGet =  $(".header-menuTrigger.hamburger_animate1");
    private SelenideElement personalAccount= $("#menu-item-690");
    private SelenideElement serviceDesk= $("#menu-item-689");
    private SelenideElement applications= $("#menu-item-692");
    private SelenideElement seeAll = $(".menu-item/menu-item-readmore");
    private SelenideElement error = $(".error404.wp-embed-responsive");
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

    public ContainerPage verifyModalAppears() {
        ResultsModal.verifyModalAppears();
        return this;
    }
    public ContainerPage verifyResult (String key, String value) {
        ResultsModal.verifyResult(key, value);

        return this;
    }
}
