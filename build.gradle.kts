plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.3.0"
    id("com.google.devtools.ksp") version "2.3.4"
    id("io.micronaut.minimal.application") version "4.6.1"
    id("io.micronaut.jsonschema") version "4.6.1"
}

version = "0.1"
group = "com.example"
repositories.mavenCentral()
dependencies {
    implementation(mn.micronaut.http.server.netty)
    implementation(mn.micronaut.serde.jackson)
    implementation(mn.micronaut.mcp.server.java.sdk)
    ksp(mn.micronaut.serde.processor)
    ksp(mn.micronaut.json.schema.processor)
    jsonSchemaGenerator(mn.micronaut.sourcegen.generator.kotlin)
}

application.mainClass = "com.example.ApplicationKt"

micronaut {
    jsonschema {
        fromFile(file("tool1-request.schema.json")) {
            lang.set("kotlin")
            outputPackageName.set("com.example.tools")
        }
    }
    processing {
        annotations("com.example.*")
    }
}


