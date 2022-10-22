package com.example.androidassignments;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> act =
        new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void TestLoginningIntoApp() {
        onView(withId(R.id.Password)).perform(typeText("test"));
        onView(withId(R.id.Loginbtn)).perform(click());
    }

}
