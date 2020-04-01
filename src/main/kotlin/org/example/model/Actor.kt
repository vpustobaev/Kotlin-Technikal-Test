package org.example.model

import com.fasterxml.jackson.annotation.*

@JsonPropertyOrder("id", "login")
class Actor {
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: Int? = null

    @get:JsonProperty("login")
    @set:JsonProperty("login")
    @JsonProperty("login")
    var login: String? = null

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> =
        HashMap()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }

}