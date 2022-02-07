plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
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

}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.Coroutines.android)

    implementation(Libs.Kotlin.Coroutines.core)

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

    implementation (Libs.Accompanist.insets)
    implementation (Libs.Accompanist.systemuicontroller)
    implementation (Libs.Accompanist.flowlayouts)

    androidTestImplementation(Libs.AndroidX.Compose.uiTest)
    androidTestImplementation(Libs.AndroidX.Test.rules)
    androidTestImplementation(Libs.AndroidX.Test.runner)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)

}