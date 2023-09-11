import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.run.BootRun

group = "rmpw"
version = "0.0.1-SNAPSHOT"
val javaVersion = JavaVersion.VERSION_17
java.sourceCompatibility = javaVersion

repositories {
    mavenCentral()
}

plugins {
    val springBootVersion = "3.0.6"
    val pluginVersion = "1.8.21"

    id("application")
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version pluginVersion
    kotlin("plugin.spring") version pluginVersion
    id("org.flywaydb.flyway") version "9.16.1"
    kotlin("plugin.jpa") version pluginVersion
    kotlin("plugin.noarg") version pluginVersion
    id("org.jlleitschuh.gradle.ktlint") version "11.3.2"
}

// Linting
apply(plugin = "org.jlleitschuh.gradle.ktlint")

dependencyLocking {
    lockAllConfigurations()
    lockMode.set(LockMode.STRICT)
}

application {
    applicationDefaultJvmArgs = listOf("-Dspring.devtools.restart.enabled=false")
}

dependencies {
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    // Language
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Spring and Configuration
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Logging
    implementation("ch.qos.logback.contrib:logback-json-classic:0.1.5")
    implementation("ch.qos.logback.contrib:logback-jackson:0.1.5")
    implementation("com.rollbar:rollbar-spring-boot-webmvc:1.10.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // PostgreSQL & Flyway
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("com.vladmihalcea:hibernate-types-60:2.21.1")
    implementation("org.hibernate.orm:hibernate-spatial:6.3.0.CR1")
    implementation("org.hibernate.orm:hibernate-core:6.3.0.CR1")
    implementation("io.hypersistence:hypersistence-utils-hibernate-60:3.5.1")
    implementation("org.geolatte:geolatte-geom:1.9.1")
    implementation("org.locationtech.jts:jts-core:1.19.0")
    implementation("org.flywaydb:flyway-core:9.16.1")

    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")

    // Asynchronous
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    implementation("com.google.maps:google-maps-services:2.2.0")
    implementation("com.google.code.gson:gson:2.10.1")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("org.testcontainers:postgresql:1.18.3")
}

tasks.register("resolveDependencies") {
    doLast {
        configurations
            .filter { it.isCanBeResolved && !Regex("^archives$|^default$|^test|Test$").containsMatchIn(it.name) }
            .forEach { it.resolve() }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = javaVersion.toString()
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("spring.profiles.active", "test")
    testLogging {
        events("FAILED", "SKIPPED")
        exceptionFormat = FULL
        showStackTraces = true
    }
}

tasks.getByName<BootRun>("bootRun") {
    systemProperty("spring.profiles.active", "local")
}
