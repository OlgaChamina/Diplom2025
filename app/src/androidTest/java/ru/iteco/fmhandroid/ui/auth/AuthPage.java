package ru.iteco.fmhandroid.ui.auth;

import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class AuthPage extends AuthStep {
    public static int getAuthorizationButton (){
        return R.id.enter_button;
    }
    public static Matcher<View> getAuthorizationLoginField(){
        return allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout))));
    }
    public static Matcher<View> getAuthorizationPasswordField(){
        return allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout))));
    }

    public static Matcher<View> getAuthText(){
        return allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))));
    }
    public static int getAuthorizationButtonExit() {

        return R.id.authorization_image_button;
    }

    public static Matcher<View> getAuthorizationButtonLogOut() {
        return allOf(withId(android.R.id.title), withText("Log out"));
    }


}
