package com.github.aachartmodel.aainfographics.aaoptionsmodel

class AATime {
    private var useUTC: Boolean? = null

    fun useUTC(prop: Boolean?): AATime {
        useUTC = prop
        return this
    }
}