plugins {
    kotlin("jvm") version "1.9.20"
    id("io.gatling.gradle") version "3.9.5"
    application
}

group = "lu.lnds.daam"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.gatling.highcharts:gatling-charts-highcharts:3.9.5")
    implementation("io.gatling:gatling-app:3.9.5")
    implementation("io.gatling:gatling-core:3.9.5")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}