package com.sixray.cepat.dto

import com.sixray.cepat.AppConfig.TAG_BLOCKED
import com.sixray.cepat.AppConfig.TAG_DIRECT
import com.sixray.cepat.AppConfig.TAG_PROXY

data class ServerConfig(
    val configVersion: Int = 3,
    val configType: EConfigType,
    var subscriptionId: String = "",
    val addedTime: Long = System.currentTimeMillis(),
    var remarks: String = "",
    val outboundBean: SixRayConfig.OutboundBean? = null,
    var fullConfig: SixRayConfig? = null
) {
    companion object {
        fun create(configType: EConfigType): ServerConfig {
            when (configType) {
                EConfigType.VMESS,
                EConfigType.VLESS ->
                    return ServerConfig(
                        configType = configType,
                        outboundBean = SixRayConfig.OutboundBean(
                            protocol = configType.name.lowercase(),
                            settings = SixRayConfig.OutboundBean.OutSettingsBean(
                                vnext = listOf(
                                    SixRayConfig.OutboundBean.OutSettingsBean.VnextBean(
                                        users = listOf(SixRayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean())
                                    )
                                )
                            ),
                            streamSettings = SixRayConfig.OutboundBean.StreamSettingsBean()
                        )
                    )

                EConfigType.CUSTOM ->
                    return ServerConfig(configType = configType)

                EConfigType.SHADOWSOCKS,
                EConfigType.SOCKS,
                EConfigType.HTTP,
                EConfigType.TROJAN,
                EConfigType.HYSTERIA2 ->
                    return ServerConfig(
                        configType = configType,
                        outboundBean = SixRayConfig.OutboundBean(
                            protocol = configType.name.lowercase(),
                            settings = SixRayConfig.OutboundBean.OutSettingsBean(
                                servers = listOf(SixRayConfig.OutboundBean.OutSettingsBean.ServersBean())
                            ),
                            streamSettings = SixRayConfig.OutboundBean.StreamSettingsBean()
                        )
                    )

                EConfigType.WIREGUARD ->
                    return ServerConfig(
                        configType = configType,
                        outboundBean = SixRayConfig.OutboundBean(
                            protocol = configType.name.lowercase(),
                            settings = SixRayConfig.OutboundBean.OutSettingsBean(
                                secretKey = "",
                                peers = listOf(SixRayConfig.OutboundBean.OutSettingsBean.WireGuardBean())
                            )
                        )
                    )
            }
        }
    }

    fun getProxyOutbound(): SixRayConfig.OutboundBean? {
        if (configType != EConfigType.CUSTOM) {
            return outboundBean
        }
        return fullConfig?.getProxyOutbound()
    }

    fun getAllOutboundTags(): MutableList<String> {
        if (configType != EConfigType.CUSTOM) {
            return mutableListOf(TAG_PROXY, TAG_DIRECT, TAG_BLOCKED)
        }
        fullConfig?.let { config ->
            return config.outbounds.map { it.tag }.toMutableList()
        }
        return mutableListOf()
    }
}
