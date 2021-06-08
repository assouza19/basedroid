package com.br.basedroid.utils

import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import com.br.basedroid.presentation.YourActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule

/*
* Por fim, essa é a classe que literalmente usa o Espresso para realizar as ações.
* O ideal é que todos os seus testes herdem dela para reutilizar esses métodos criados.
* Aqui possui apenas 4 funções de exemplo, mas sempre que necessário, basta criar
* uma nova função para realizar a sua asserção/ação.
*/
open class BaseRobot {

    @Rule
    @JvmField
    val activityRule = IntentsTestRule(
        YourActivity::class.java,
        true, true
    )

    fun checkViewIsDisplayed(@IdRes viewId: Int) = apply {
        ViewMatchers.withId(viewId).onView {
            verify(ViewMatchers.isDisplayed())
        }
    }

    fun checkViewHasText(@IdRes viewId: Int, expected: String) = apply {
        ViewMatchers.withId(viewId).onView {
            verify(ViewMatchers.withText(expected))
        }
    }

    fun checkRecyclerViewHasText(@IdRes viewId: Int, position: Int, expected: String) = apply {
        Espresso.onView(ViewMatchers.withId(viewId))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        position,
                        ViewMatchers.hasDescendant(ViewMatchers.withText(expected))
                    )
                )
            )
    }

    fun checkRecyclerViewHasDrawable(
        @IdRes viewId: Int,
        position: Int,
        @DrawableRes drawableResId: Int
    ) =
        apply {
            Espresso.onView(ViewMatchers.withId(viewId))
                .check(
                    ViewAssertions.matches(
                        atPosition(
                            position,
                            ViewMatchers.hasDescendant(withDrawable(drawableResId))
                        )
                    )
                )
        }

    companion object {

        fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

                override fun describeTo(description: Description) {
                    description.appendText("has item at position: ")
                    description.appendValue(position)
                }

                override fun matchesSafely(view: RecyclerView): Boolean {
                    val viewHolder = view.findViewHolderForAdapterPosition(position) ?: return false
                    return itemMatcher.matches(viewHolder.itemView)
                }
            }
        }

        fun withDrawable(@DrawableRes drawable: Int): Matcher<View> {
            return object : BoundedMatcher<View, ImageView>(ImageView::class.java) {

                override fun describeTo(description: Description) {
                    description.appendText("with drawable resource id: ")
                    description.appendValue(drawable)
                }

                override fun matchesSafely(view: ImageView): Boolean {
                    val expected =
                        ContextCompat.getDrawable(view.context, drawable) as BitmapDrawable
                    val actual = view.drawable as BitmapDrawable
                    return expected.bitmap.sameAs(actual.bitmap)
                }
            }
        }
    }
}