package com.davecon.reelview.navigation

import java.lang.IllegalArgumentException

/**
 * Navigation stores routes the similar to paths: Home/Detail/supscreen
 * This enum is used to parse the route and determine which screen
 * to display.
 */
enum class MovieScreens {
    HOME,
    DETAIL;

    companion object {
        fun fromRoute(route: String?): MovieScreens =
            when (route?.substringBefore("/")) {
                HOME.name -> HOME
                DETAIL.name -> DETAIL
                null -> throw IllegalArgumentException("Route: $route cannot be null")
                else -> HOME
            }
    }
}