package com.chubecode.common_android.extension

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.chubecode.common_android.R
import com.chubecode.common_android.utils.DeviceUtils
import com.chubecode.common_android.widget.DividerExceptFirstLastDecorator
import com.chubecode.common_android.widget.SimpleDividerDecorator

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.hideKeyboard(context: Context) {
    val imm = context.getSystemService (Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.getWindowToken(), 0)
}

fun RecyclerView.applyVerticalDecorator() {
    val dividerDrawable = ContextCompat.getDrawable(this.context, R.drawable.divider)
    dividerDrawable?.let {
        this.addItemDecoration(SimpleDividerDecorator(dividerDrawable))
    }
}

fun RecyclerView.applyVerticalDecoratorExceptFirstLast() {
    val dividerDrawable = ContextCompat.getDrawable(this.context, R.drawable.divider)
    dividerDrawable?.let {
        this.addItemDecoration(DividerExceptFirstLastDecorator(dividerDrawable))
    }
}

fun RecyclerView.applySnapHelper() {
    val snapHelper: SnapHelper = LinearSnapHelper()
    snapHelper.attachToRecyclerView(this)
}
//
//fun View.setOnClickListenerFastCheck(listener: (View) -> (Unit)) {
//    this.setOnClickListener {
//        GlobalScope.launch(context = Dispatchers.Main) {
//            isEnabled = false
//            listener(it)
//            delay(1500)
//            isEnabled = true
//        }
//    }
//}
//
//fun View.setOnClickListenerNetworkCheck(listener: (View) -> (Unit)) {
//    this.setOnClickListener {
//        GlobalScope.launch(context = Dispatchers.Main) {
//            isEnabled = false
//            if (DeviceUtils.isNDeviceUtiletworkConnected(it.context)) {
//                listener(it)
//            } else {
//                val activity = it.context as Activity
//                activity.showOKAlertDialog(message = activity.getString(R.string.network_error_using_function), pBtnTitle = activity.getString(R.string.error_dialog_accept))
//            }
//            delay(1500)
//            isEnabled = true
//        }
//    }
//}
