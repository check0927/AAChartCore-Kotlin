package com.github.aachartmodel.aainfographics.aaoptionsmodel

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer.pureJavaScriptFunctionString


open class AAEvents {

    var proxyOver = ""
    var proxyOut = ""
    var legendItemClick = ""
    fun proxyLegendItemClick(proxy: String): AAEvents {
        var pureJSFunctionStr = "(" + proxy + ")";
        pureJSFunctionStr = pureJavaScriptFunctionString(pureJSFunctionStr!!)
        legendItemClick = pureJSFunctionStr
        return this
    }

    fun proxyOut(proxy: String): AAEvents {
        var pureJSFunctionStr = "(" + proxy + ")";
        pureJSFunctionStr = pureJavaScriptFunctionString(pureJSFunctionStr!!)
        proxyOut = pureJSFunctionStr
        return this
    }

    fun proxyOver(proxy: String): AAEvents {
        var pureJSFunctionStr = "(" + proxy + ")";
        pureJSFunctionStr = pureJavaScriptFunctionString(pureJSFunctionStr!!)
        proxyOver = pureJSFunctionStr
        return this
    }


}