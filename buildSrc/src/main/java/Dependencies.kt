object Libs {
    const val ktLintVersion = "0.41.0"
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.1.0-alpha02"
    const val ktLint = "com.pinterest:ktlint:$ktLintVersion"

    object Kotlin {
        private const val version = "1.5.20"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"

        object Coroutines {
            private const val version = "1.5.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-rc01"
        }

        object Compose {
            const val snapshot = ""
            const val version = "1.0.0-rc01"

            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val material = "androidx.compose.material:material:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
        }

        object Lifecycle {
            private const val version = "2.3.0"
            const val viewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Test {
            private const val version = "1.4.0"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.3"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }

        object Room {
            private const val roomVersion = "2.3.0"
            private const val lifecycleVersion = "2.3.1"
            val room = "androidx.room:room-runtime:$roomVersion"
            val roomCompiler = "androidx.room:room-compiler:$roomVersion"
            val roomKtx = "androidx.room:room-ktx:$roomVersion"
            val runtime = "androidx.lifecycle:lifecycle-runtime:$lifecycleVersion"
            val commons = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        }
    }

    object Hilt {
        private const val version = "2.31.2-alpha"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }

    object JUnit {
        private const val version = "4.13"
        const val junit = "junit:junit:$version"
    }

    object Network {
        private const val retrofitVersion = "2.9.0"
        private const val okhttpVersion = "4.9.1"
        private const val moshiVersion = "1.12.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val okhttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"
        const val okhttpIntercepter =
            "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
        const val moshi = "com.squareup.moshi:moshi:$moshiVersion"
        const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
        const val moshiConverter =
            "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    }

    object Timber {
        private const val version = "4.7.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }

    object App {
        const val minSdkVersion = 24
        const val targetSdkVersion = 30
        const val compileSdkVersion = 30
        const val applicationId = "com.template"
    }
}
