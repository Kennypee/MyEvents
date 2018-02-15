package com.example.ekene.blogzone;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by EKENE on 2/15/2018.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(PostActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testMainActivityLaunch(){

        View view = mainActivity.findViewById(R.id.toolbar);
        assertNotNull(view);
    }
    @Test
    public void testLaunchOfPostActivityOnButtonClick(){

        View view = mainActivity.findViewById(R.id.action_add);
        assertNotNull(view);
        onView(withId(R.id.action_add)).perform(click());
        Activity postActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(postActivity);
    }

    @After
    public void tearDown() throws Exception {

        mainActivity = null;
    }

}