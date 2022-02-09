object Libs {
    const val ktLintVersion = "0.43.2"
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.1.0"
    const val ktLint = "com.pinterest:ktlint:$ktLintVersion"

    object Kotlin {
        private const val version = "1.6.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.6.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
        object Serialization {
            const val kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
        }
    }

    object Accompanist {
        const val version = "0.22.1-rc"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val flowlayouts = "com.google.accompanist:accompanist-flowlayout:$version"
        const val navAnimation = "com.google.accompanist:accompanist-navigation-animation:$version"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        }

        object Compose {
            const val snapshot = ""
            const val version = "1.1.0-rc03"

            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:${version}"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val material = "androidx.compose.material:material:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val materialIcons = "androidx.compose.material:material-icons-extended:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
        }

        object Lifecycle {
            private const val version = "2.4.0"
            const val viewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

        object Navigation {
            const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0"
        }

        object Test {
            private const val version = "1.4.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"
            const val archCoreTest = "androidx.arch.core:core-testing:2.1.0"
            const val kotlinJunitTest = "org.jetbrains.kotlin:kotlin-test-junit:1.6.0"

            object Ext {
                private const val version = "1.1.3"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            object Mockito {
                const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
                const val mockitoInline = "org.mockito:mockito-inline:4.2.0"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        }

        object Room {
            private const val roomVersion = "2.4.1"
            private const val lifecycleVersion = "2.3.1"
            val room = "androidx.room:room-runtime:$roomVersion"
            val roomCompiler = "androidx.room:room-compiler:$roomVersion"
            val roomKtx = "androidx.room:room-ktx:$roomVersion"
            val runtime = "androidx.lifecycle:lifecycle-runtime:$lifecycleVersion"
            val commons = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        }
    }

    object Hilt {
        private const val version = "2.40.5"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

    object Timber {
        private const val version = "5.0.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }

    object App {
        const val minSdkVersion = 24
        const val targetSdkVersion = 31
        const val compileSdkVersion = 31
        const val applicationId = "com.quotes"
    }
}
