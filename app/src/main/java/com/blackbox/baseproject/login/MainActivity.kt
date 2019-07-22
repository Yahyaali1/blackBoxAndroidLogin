package com.blackbox.baseproject

import com.blackbox.baseproject.shared.activities.BaseActivity
import com.blackbox.baseproject.shared.viewModel.EmptyViewModel

class MainActivity : BaseActivity<EmptyViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setup() {

    }


}
