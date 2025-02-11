package ru.iteco.fmhandroid.ui.quote;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class QuotePage {
    public static Matcher<View> getButtonQuote(){
        return allOf(withId(R.id.our_mission_image_button));
    }
    public static Matcher<View> getDeploymentButtonQuote() {
        return allOf(withId(R.id.our_mission_item_list_recycler_view));
    }

    public static Matcher<View> getTitleQuoteClick() {
        return allOf(withId(R.id.our_mission_item_list_recycler_view));
    }

    public static Matcher<View> getDescriptionQuoteClick() {
        return allOf(withId(R.id.our_mission_item_list_recycler_view));
    }

}
