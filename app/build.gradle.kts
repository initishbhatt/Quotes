plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.6.10"
}
android {
    compileSdk = Libs.App.compileSdkVersion
    defaultConfig {
        applicationId = Libs.App.applicationId
        minSdk = Libs.App.minSdkVersion
        targetSdk = Libs.App.targetSdkVersion
        versionCode = ReleaseConfig.appVersionCode
        versionName = ReleaseConfig.appVersionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false

        kotlinOptions.freeCompilerArgs += "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    packagingOptions {
        resources.excludes.add("/META-INF/AL2.0")
        resources.excludes.add("/META-INF/LGPL2.1")
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }

    sourceSets {
        this.getByName("androidTest").java.srcDirs("src/test-common/java")
        this.getByName("test").java.srcDirs("src/test-common/java")
    }

}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.Coroutines.android)
    implementation(Libs.Kotlin.Coroutines.core)
    implementation(Libs.Kotlin.Serialization.kotlinxSerializationJson)


    implementation(Libs.AndroidX.coreKtx)

    implementation(Libs.AndroidX.Activity.activityCompose)
    implementation(Libs.AndroidX.Lifecycle.viewModelCompose)
    implementation(Libs.AndroidX.Navigation.navigationCompose)

    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.runtime)
    implementation(Libs.AndroidX.Compose.foundation)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.materialIcons)
    implementation(Libs.AndroidX.Compose.layout)
    implementation(Libs.AndroidX.Compose.animation)
    implementation(Libs.AndroidX.Compose.tooling)

    implementation(Libs.Accompanist.insets)
    implementation(Libs.Accompanist.systemuicontroller)
    implementation(Libs.Accompanist.flowlayouts)
    implementation(Libs.Accompanist.navAnimation)

    implementation(Libs.Hilt.android)
    implementation(Libs.Hilt.navigationCompose)
    kapt(Libs.Hilt.compiler)

    implementation(Libs.Timber.timber)

    implementation(Libs.AndroidX.Room.room)
    implementation(Libs.AndroidX.Room.roomKtx)
    kapt(Libs.AndroidX.Room.roomCompiler)

    testImplementation(Libs.Kotlin.Coroutines.test)
    testImplementation(Libs.AndroidX.Test.kotlinJunitTest)
    testImplementation(Libs.AndroidX.Test.Mockito.mockitoKotlin)
    testImplementation(Libs.AndroidX.Test.Mockito.mockitoInline)
    testImplementation(Libs.AndroidX.Test.archCoreTest)
    testImplementation(Libs.AndroidX.Test.turbine)

    androidTestImplementation(Libs.AndroidX.Compose.uiTest)
    debugImplementation(Libs.AndroidX.Compose.uiTestManifest)
    androidTestImplementation(Libs.AndroidX.Test.rules)
    androidTestImplementation(Libs.AndroidX.Test.runner)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)

}