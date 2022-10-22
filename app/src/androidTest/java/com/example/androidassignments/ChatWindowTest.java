package com.example.androidassignments;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

public class ChatWindowTest {

    @Rule
    public ActivityTestRule<ChatWindow> act =
        new ActivityTestRule<>(ChatWindow.class);

    @Test
    public void onClick() {
        Intent intent = new Intent();
        act.launchActivity(intent);
        onView(withId(R.id.sendbtn)).perform(click());
        onView(withId(R.id.msgBox)).perform(typeText("message"));
        onView(withId(R.id.sendbtn)).perform(click());
    }
}
