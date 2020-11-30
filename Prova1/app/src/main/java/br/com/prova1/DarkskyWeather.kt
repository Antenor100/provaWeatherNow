package br.com.prova1

import java.util.*

class DarkskyWeather {
    var latitude = 0.0
    var longitude = 0.0
    var timezone: String? = null
    var currently: Currently? = null
    var offset = 0

    private val additionalProperties: MutableMap<String, Any> = HashMap()

    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}