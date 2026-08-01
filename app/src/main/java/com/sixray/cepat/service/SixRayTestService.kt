package com.sixray.cepat.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.sixray.cepat.AppConfig.MSG_MEASURE_CONFIG
import com.sixray.cepat.AppConfig.MSG_MEASURE_CONFIG_CANCEL
import com.sixray.cepat.AppConfig.MSG_MEASURE_CONFIG_SUCCESS
import com.sixray.cepat.dto.EConfigType
import com.sixray.cepat.extension.serializable
import com.sixray.cepat.handler.MmkvManager
import com.sixray.cepat.handler.PluginServiceManager
import com.sixray.cepat.handler.SpeedtestManager
import com.sixray.cepat.handler.SixRayConfigManager
import com.sixray.cepat.util.MessageUtil
import com.sixray.cepat.util.Utils
import go.Seq
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import libv2ray.Libv2ray
import java.util.concurrent.Executors

class SixRayTestService : Service() {
    private val realTestScope by lazy { CoroutineScope(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher()) }

    /**
     * Initializes the V2Ray environment.
     */
    override fun onCreate() {
        super.onCreate()
        Seq.setContext(this)
        Libv2ray.initCoreEnv(Utils.userAssetPath(this), Utils.getDeviceIdForXUDPBaseKey())
    }

    /**
     * Handles the start command for the service.
     * @param intent The intent.
     * @param flags The flags.
     * @param startId The start ID.
     * @return The start mode.
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.getIntExtra("key", 0)) {
            MSG_MEASURE_CONFIG -> {
                val guid = intent.serializable<String>("content") ?: ""
                realTestScope.launch {
                    val result = startRealPing(guid)
                    MessageUtil.sendMsg2UI(this@SixRayTestService, MSG_MEASURE_CONFIG_SUCCESS, Pair(guid, result))
                }
            }

            MSG_MEASURE_CONFIG_CANCEL -> {
                realTestScope.coroutineContext[Job]?.cancelChildren()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    /**
     * Binds the service.
     * @param intent The intent.
     * @return The binder.
     */
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    /**
     * Starts the real ping test.
     * @param guid The GUID of the configuration.
     * @return The ping result.
     */
    private fun startRealPing(guid: String): Long {
        val retFailure = -1L

        val config = MmkvManager.decodeServerConfig(guid) ?: return retFailure
        if (config.configType == EConfigType.HYSTERIA2) {
            val delay = PluginServiceManager.realPingHy2(this, config)
            return delay
        } else {
            val configResult = SixRayConfigManager.getSixRayConfig4Speedtest(this, guid)
            if (!configResult.status) {
                return retFailure
            }
            return SpeedtestManager.realPing(configResult.content)
        }
    }
}
