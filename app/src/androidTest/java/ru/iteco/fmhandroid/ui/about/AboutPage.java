package ru.iteco.fmhandroid.ui.about;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class AboutPage {

    public static Matcher<View> getButtonAbout() {
        return allOf(withId(android.R.id.title), withText("About"));
    }

    public static Matcher<View> getLinkPrivacyPolicy() {
        return allOf(withId(R.id.about_privacy_policy_value_text_view));
    }

    public static Matcher<View> getLinkTermsOfUse() {
        return withId(R.id.about_terms_of_use_value_text_view);
    }
    public static Matcher<View> getButtonBack() {
        return allOf(withId(R.id.about_back_image_button));
    }
}
