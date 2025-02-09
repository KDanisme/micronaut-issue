package com.example

import io.micronaut.jsonschema.JsonSchema
import io.micronaut.mcp.annotations.Tool
import jakarta.inject.Singleton
import com.example.tools.Tool1Request
import io.micronaut.serde.annotation.Serdeable

@Singleton
class Tools {
    @Tool
    fun tool1(request: Tool1Request) = true

    @Tool
    fun tool2(request: Tool2Request) = true
}

@JsonSchema
@Serdeable
data class Tool2Request(
    /**
     * a description for my property
     */
    val someProperty: Number
)
