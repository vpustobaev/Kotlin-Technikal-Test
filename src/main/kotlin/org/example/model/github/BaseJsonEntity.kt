package org.example.model.github

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonIgnore

open class BaseJsonEntity {

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any?> =
        HashMap()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any?> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any?) {
        additionalProperties[name] = value
    }

}