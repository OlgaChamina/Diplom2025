package ru.iteco.fmhandroid.ui.quote;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.quote.QuotePage.getButtonQuote;
import static ru.iteco.fmhandroid.ui.quote.QuotePage.getDeploymentButtonQuote;
import static ru.iteco.fmhandroid.ui.quote.QuotePage.getDescriptionQuoteClick;
import static ru.iteco.fmhandroid.ui.quote.QuotePage.getTitleQuoteClick;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.WaitId;

public class QuoteStep {
    public static void clickButtonQuote(){
        Allure.step("Нажать на кнопку Цитаты в AppBar");
        onView(getButtonQuote()).perform(click());
    }
    public static void clickDeploymentButtonQuote(){
        Allure.step("Нажать на кнопку развертывания описания цитат");
        onView(getDeploymentButtonQuote()).perform(click());
    }
    public  static void clickTitleQuoteClick(){
        Allure.step("Нажать на кнопку поле Заголовка цитаты");
        onView(getTitleQuoteClick()).perform(click());
    }
    public static void clickDescriptionQuoteClick(){
        Allure.step("Нажать на поле описания цитаты");
        onView(getDescriptionQuoteClick()).perform(click());
    }
    public static void isItQuotePage() {
        Allure.step("Проверяем, находимся ли на странице Цитаты.");
        WaitId.waitView(withText("Love is all")).check(matches(isDisplayed()));

    }
}
