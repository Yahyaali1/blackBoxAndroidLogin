package com.blackbox.baseproject.shared.activities

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProviders
import com.blackbox.baseproject.shared.viewModel.BaseViewModel
import java.lang.reflect.ParameterizedType

fun <T : BaseViewModel> BaseActivity<T>.initViewModel(): T {
    return initViewModel(getViewModelClass(javaClass))
}

fun <T : BaseViewModel> BaseActivity<*>.initViewModel(clazz: Class<T>): T {
    return ViewModelProviders.of(this, viewModelFactory).get(clazz).also {
        lifecycle.addObserver(it)
    }
}

/**
 *https://stackoverflow.com/a/52073780/6910603
 * Based on the answer
 */
@Suppress("UNCHECKED_CAST", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun <T : BaseViewModel> getViewModelClass(aClass: Class<*>): Class<T> {
    val type = aClass.genericSuperclass

    return if (type is ParameterizedType) {
        type.actualTypeArguments[0] as Class<T>
    } else {
        getViewModelClass(aClass.superclass)
    }
}

interface LayoutSetup {
    fun restoreBundleState(savedInstanceState: Bundle?)
    @LayoutRes
    fun getLayoutId(): Int

    fun setup()
}