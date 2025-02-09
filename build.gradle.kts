plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25"
    id("com.google.devtools.ksp") version "1.9.25-1.0.20"
    id("io.micronaut.minimal.application") version "4.5.3"
    id("io.micronaut.openapi") version "4.5.3"
}

version = "0.1"
group = "com.example"

val kotlinVersion= project.properties["kotlinVersion"]
repositories.mavenCentral()
dependencies {
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.openapi:micronaut-openapi")
    ksp("io.micronaut.serde:micronaut-serde-processor")

    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    compileOnly("io.micronaut:micronaut-http-client")
    compileOnly("io.micronaut.openapi:micronaut-openapi-annotations")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("io.micronaut:micronaut-http-client")
}

application.mainClass = "com.example.ApplicationKt"
java.sourceCompatibility = JavaVersion.toVersion("21")

micronaut {
    openapiVersion = "6.17.1"
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
    openapi {
        server(file("src/main/resources/openapi.yml")) {
            apiPackageName = "com.example.api"
            modelPackageName = "com.example.model"
            // coroutines = true
            useReactive = false
            useBeanValidation = false
            lang = "kotlin"
        }
    }
}


