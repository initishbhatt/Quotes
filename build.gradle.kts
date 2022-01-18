buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
    }
}

plugins {
    id("com.diffplug.spotless") version ("5.14.0")
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
            ktlint(Libs.ktLintVersion)
        }
    }
}