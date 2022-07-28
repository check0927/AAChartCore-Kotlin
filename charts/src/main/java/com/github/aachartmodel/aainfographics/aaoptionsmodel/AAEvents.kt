package com.github.aachartmodel.aainfographics.aaoptionsmodel

open class AAEvents {

    var proxyOver = {

    }
    var proxyOut = {

    }

    fun proxyOut(proxy: () -> Unit): AAEvents {
        proxyOut = proxy
        return this
    }

    fun proxyOver(proxy: () -> Unit): AAEvents {
        proxyOver = proxy
        return this
    }

    fun mouseOver() {
        proxyOut()
    }

    fun mouseOut() {
        proxyOut()
    }

}