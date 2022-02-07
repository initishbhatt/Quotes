buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Hilt.gradlePlugin)
    }
}

plugins {
    id("com.diffplug.spotless") version ("6.2.0")
    id("com.github.ben-manes.versions") version("0.39.0")
}
allprojects {

    apply {
        plugin("com.diffplug.spotless")
    }
    repositories {
        google()
        mavenCentral()
    }
    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("bin/**/*.kt")
            targetExclude("buildSrc/**/*.kt")
            ktlint(Libs.ktLintVersion).userData(mapOf("android" to "true"))
        }
    }
}