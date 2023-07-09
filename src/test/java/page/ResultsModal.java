package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {
    private SelenideElement containerNameSearch= $(".container");
    private SelenideElement moduleDescription= $(".page-content.container");
    public void verifyModalAppears(String value) {
        moduleDescription.should(appear);
        moduleDescription.shouldHave(text("Описание модуля"));
    }
    public void verifyResult(String value) {
        containerNameSearch.$(byText(value)).parent()
                .shouldHave(text(value));
    }
}


