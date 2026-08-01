package com.sixray.cepat.ui

import android.os.Bundle
import com.sixray.cepat.R
import com.sixray.cepat.handler.SixRayServiceManager

class ScSwitchActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moveTaskToBack(true)

        setContentView(R.layout.activity_none)

        if (SixRayServiceManager.isRunning()) {
            SixRayServiceManager.stopVService(this)
        } else {
            SixRayServiceManager.startVServiceFromToggle(this)
        }
        finish()
    }
}
