package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegisterResultsModule {

    public void verifyModule(String title) {

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(title));
    }

    public void verifyModuleNotVisible(String title) {

        $(".modal-dialog").shouldNot(appear);
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}