package com.br.basedroid.utils

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import junit.framework.AssertionFailedError
import org.hamcrest.Matcher

fun Matcher<View>.onView(func: ViewInteraction.() -> Unit): ViewInteraction {
    val viewInteraction = Espresso.onView(this)
    viewInteraction.func()
    return viewInteraction
}
private fun ViewInteraction.verify(
    matcher: Matcher<View>,
    retryCount: Int
): ViewInteraction {
    withFailureHandler { error, _ ->
        when {
            error !is AssertionFailedError -> throw error
            retryCount > 0 -> {
                perform(waitFor(200))
                verify(matcher, retryCount - 1)
            }
            else -> throw AssertionFailedError("${error.message} after retries")
        }
    }
    return check(ViewAssertions.matches(matcher))
}

fun ViewInteraction.verify(matcher: Matcher<View>) = verify(matcher, 5)

fun waitFor(millis: Long): ViewAction {
    return object : ViewAction {
        override fun getConstraints() = ViewMatchers.isAssignableFrom(View::class.java)

        override fun getDescription() = "Wait for $millis milliseconds."

        override fun perform(uiController: UiController, view: View) {
            uiController.loopMainThreadUntilIdle()
            uiController.loopMainThreadForAtLeast(millis)
        }
    }
}