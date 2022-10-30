import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.7.0"
    application
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "art.scidsgn"
version = "1.0-SNAPSHOT"

javafx {
    version = "17"
    modules("javafx.controls")
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.antlr:antlr4-runtime:4.11.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}