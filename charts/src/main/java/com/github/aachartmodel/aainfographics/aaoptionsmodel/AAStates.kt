/**
 * Copyright (C), 2015-2020,
 * FileName: AAStates
 * Author: AnAn
 * Date: 2020-01-29 23:53
 * Description:
 * History:
 */
package com.github.aachartmodel.aainfographics.aaoptionsmodel

open class AAStates {
    var hover: AAHover? = null
    var select: AASelect? = null
    var inactive: AAInactive? = null

    fun hover(prop: AAHover?): AAStates {
        hover = prop
        return this
    }

    fun select(prop: AASelect?): AAStates {
        select = prop
        return this
    }
    fun inactive(prop: AAInactive?): AAStates {
        inactive = prop
        return this
    }
}


open class AAHover {
    var borderColor: String? = null
    var brightness: Float? = null
    var color: String? = null
    var halo: AAHalo? = null
    var lineWidth: Float? = null
    var enabled: Boolean? = null

    fun lineWidth(prop: Float?): AAHover {
        lineWidth = prop
        return this
    }

    fun enabled(prop: Boolean?): AAHover {
        enabled = prop
        return this
    }

    fun borderColor(prop: String?): AAHover {
        borderColor = prop
        return this
    }

    fun brightness(prop: Float?): AAHover {
        brightness = prop
        return this
    }

    fun color(prop: String?): AAHover {
        color = prop
        return this
    }

    fun halo(prop: AAHalo?): AAHover {
        halo = prop
        return this
    }
}

open class AASelect {
    var borderColor: String? = null
    var color: String? = null
    var halo: AAHalo? = null

    fun borderColor(prop: String?): AASelect {
        borderColor = prop
        return this
    }

    fun color(prop: String?): AASelect {
        color = prop
        return this
    }

    fun halo(prop: AAHalo?): AASelect {
        halo = prop
        return this
    }
}

open class AAHalo {
    var attributes: Map<*, *>? = null
    var opacity: Float? = null
    var size: Float? = null

    fun attributes(prop: Map<*, *>?): AAHalo {
        attributes = prop
        return this
    }

    fun opacity(prop: Float?): AAHalo {
        opacity = prop
        return this
    }

    fun size(prop: Float?): AAHalo {
        size = prop
        return this
    }
}
class AAInactive {
    var enabled: Boolean? = null
    var opacity: Number? = null
    fun enabled(prop: Boolean?): AAInactive {
        enabled = prop
        return this
    }

    fun opacity(prop: Number?): AAInactive {
        opacity = prop
        return this
    }
}
