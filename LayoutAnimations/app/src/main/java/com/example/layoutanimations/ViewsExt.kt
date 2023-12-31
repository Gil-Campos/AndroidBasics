package com.example.layoutanimations

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.transition.Slide
import androidx.transition.TransitionManager

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hideToBottom(root: ViewGroup) {
    val transition = Slide(Gravity.BOTTOM)
        .setDuration(500)
        .addTarget(this)

    TransitionManager.beginDelayedTransition(root, transition)
    visibility = View.GONE
}

fun View.showFromBottom(root: ViewGroup) {
    val transition = Slide(Gravity.BOTTOM)
        .setDuration(500)
        .addTarget(this)

    TransitionManager.beginDelayedTransition(root, transition)
    visibility = View.VISIBLE
}