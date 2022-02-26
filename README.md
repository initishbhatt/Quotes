<p align="center">
<img src="/art/logo.png" width="33%"/>
</p>
<h1 align="center">Quotes</h1>

<p align="center">
  <a href="https://developer.android.com/jetpack/androidx/releases/compose"><img alt="JetpackCompose" src="https://img.shields.io/badge/Jetpack%20Compose-1.2.0--alpha04-orange"/></a>
  <a href="https://developer.android.com/reference"><img alt="Android" src="https://img.shields.io/badge/Platform-android-brightgreen"/></a>
  <a href="https://androidstudio.googleblog.com/2022/01/android-studio-dolphin-canary-1-now.html"><img alt="Android Studio Dolphin" src="https://img.shields.io/badge/Android%20Studio-Dolphin-yellow"/></a>

Quotes app demonstrates some of the general use cases and demands on a typical production project using: <b>Jetpack Compose</b>, <b>Functional Programming</b>,<b>MVVM</b>, <b>Kotlin Coroutines</b>,<b>Flow</b>,
<b>Jetpack (Room, ViewModel)</b>, and <b>Material Design based on MVVM architecture</b>.

<p align="center">
<img src="/art/Quotes.png"/>
</p>

## Built With 🛠
* [Jetpack Compose][0] Jetpack Compose is Android's modern toolkit for building native UI. It simplifies and accelerates UI development on Android.
* [Coroutines][1] A Coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
* [Flows][2] Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.
* [Compose Navigation][3] For tabs navigation using Jetpack Compose.
* [Dagger Hilt][4] Dependency injection library for Android.
* [Jetpack DataStore][5] Jetpack DataStore is a data storage solution that allows you to store key-value pairs or typed objects with protocol buffers. DataStore uses Kotlin coroutines and Flow to store data asynchronously, consistently, and transactionally
* [Timber][6] Logger with a small API which provides utility on top of Android's normal Log class.
* [Accompanist][7] Accompanist is a group of libraries that aim to supplement Jetpack Compose
* [KotlinxSerialization][8] Kotlin serialization consists of a compiler plugin, that generates visitor code for serializable classes, runtime library with core serialization API and support libraries with various serialization formats.
* [Turbine][9] Turbine is a small testing library for kotlinx.coroutines Flow.
* [Mockito][10] Mocking framework
* [Room][11] The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
* [Espresso][12] Android UI Testing framework.

[0]:  https://developer.android.com/jetpack
[1]:  https://github.com/Kotlin/kotlinx.coroutines
[2]:  https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/
[3]:  https://developer.android.com/jetpack/compose/navigation
[4]:  https://dagger.dev/hilt/
[5]:  https://developer.android.com/topic/libraries/architecture/datastore
[6]:  https://github.com/JakeWharton/timber
[7]:  https://google.github.io/accompanist/
[8]:  https://github.com/Kotlin/kotlinx.serialization
[9]:  https://github.com/cashapp/turbine
[10]: https://github.com/mockito/mockito-kotlin
[11]: https://developer.android.com/jetpack/androidx/releases/room
[12]: https://developer.android.com/training/testing/espresso/


## Architecture 🗼
The app uses [***MVVM(Model View ViewModel)***](https://developer.android.com/jetpack/guide#recommended-app-arch)

![](https://developer.android.com/topic/libraries/architecture/images/mad-arch-overview.png)

## MAD Scorecard
![summary](https://user-images.githubusercontent.com/16473147/155850920-267f53c6-db91-49cb-a15c-fcbd3ef891a6.png)
![jetpack](https://user-images.githubusercontent.com/16473147/155850916-9a65907c-e844-499d-ada1-5c46fd9c239d.png)
![kotlin](https://user-images.githubusercontent.com/16473147/155850918-ae1cfd50-7b8b-47fd-96e2-b2cd1e008a56.png)

## Want to contribute
You can create [issues](https://github.com/initishbhatt/quotes/issues) or [pull requests](https://github.com/initishbhatt/quotes/pulls) to contribute this project

## Find this repository useful? :heart:
Support it by joining __[stargazers](https://github.com/initishbhatt/Quotes/stargazers)__ for this repository. :star: <br>
Also, __[follow me](https://github.com/initishbhatt)__ on GitHub for my next creations! 🤩

## License 🔖
```
MIT License

Copyright (c) 2021 Nitish Bhatt

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```