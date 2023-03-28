package dev.mr3n.onlylatest

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyPingEvent
import com.velocitypowered.api.network.ProtocolVersion
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import com.velocitypowered.api.proxy.server.ServerPing

@Plugin(id = "onlylatest", name = "OnlyLatest")
class OnlyLatest @Inject constructor(private val server: ProxyServer) {
    @Subscribe
    fun on(event: ProxyPingEvent) {
        val protocolVersion = ProtocolVersion.values().maxByOrNull { it.protocol }!!
        event.ping = event.ping.asBuilder().version(ServerPing.Version(protocolVersion.protocol,protocolVersion.name)).build()
    }
}