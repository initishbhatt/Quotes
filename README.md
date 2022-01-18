# kotlin-android-compose-template

![Workflow result](https://github.com/initishbhatt/android-kotlin-compose-template/workflows/pr_merge/badge.svg)

A simple Github template to create an **Android/Kotlin**, **Compose** ready project.

A major chunk of development time is taken up by setting up **DSL**, **static analysis** and **CI**.
This template is made with an aim to reduce this redundant work and be ready with a working repository where all these are handled.

## How to use

Copy this repository by pressing the [![Use this template](https://img.shields.io/badge/use-this%20tempate-yellowgreen)](https://github.com/initishbhatt/android-kotlin-compose-template/generate) button.
Clone your repository and open it in the latest [Android Studio (Canary build)](https://developer.android.com/studio/preview).

Once created don't forget to update the:
- [Application Id](buildSrc/src/main/java/Dependencies.kt)
- [AndroidManifest](app/src/main/AndroidManifest.xml)
- **Package of the source files**

## Features 

- **Kotlin-only template**.
- **Compose-Ready** 
- Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
- Sample Compose Test.
- Kotlin Static Analysis via `ktlint`.
- `Spotless` for code formatting.
- CI Setup with GitHub Actions.
- Issues Template (bug report + feature request). 
- Pull Request Template.

## Gradle Setup 
This template uses [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html)

Dependencies are placed inside the [Dependencies.kt](buildSrc/src/main/java/Dependencies.kt) file in the `buildSrc` folder inspired by [Jetcaster](https://github.com/android/compose-samples/tree/main/Jetcaster)

## Static Analysis

This template is using [**ktlint**](https://github.com/pinterest/ktlint) with the [**spotless**](https://github.com/diffplug/spotless) plugin to format your code. Run `./gradlew app:spotlessApply` to automatically format your code.


## Contributing 

Feel free to open a issue or submit a pull request for any bugs/improvements.


> For template without compose i would recommend [**this**](https://github.com/cortinico/kotlin-android-template) template from [Nikola Corti](https://github.com/cortinico)
