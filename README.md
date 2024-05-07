# Pasos para generar el proyecto:

1. Agregar esto en `build.gradle.kts`:

```
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
}
```

Y también las dependencias:

```
dependencies {

  // INICIO DE DEPENDENCIAS ADICIONALES

  // NAVIGATION
  val navVersion = "2.7.2"
  implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
  implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
  implementation("androidx.navigation:navigation-compose:$navVersion")

  // HTTP CLIENT: Retrofit
  val retrofitVersion = "2.9.0"
  implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
  implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

  // IMAGE
  val glideVersion = "2.2.8"
  implementation("com.github.skydoves:landscapist-glide:$glideVersion")

  // ROOM - ORM FRAMEWORK
  val room_version = "2.5.2"
  implementation("androidx.room:room-runtime:$room_version")
  annotationProcessor("androidx.room:room-compiler:$room_version")
  // To use Kotlin annotation processing tool (kapt)
  kapt("androidx.room:room-compiler:$room_version")
  // optional - Kotlin Extensions and Coroutines support for Room
  implementation("androidx.room:room-ktx:$room_version")

  // FIN DE DEPENDENCIAS ADICIONALES
```
(Nota: Debajo del comentario debe de mantenerse `libs.androidx.core.ktx` y todo lo demás que viene por defecto)

(Nota: Después de pegar todas las dependencias, hacer click en Sync Now)

2. Crear la siguiente estructura de carpetas:
```
.
└── kotlin+java
    └── NOMBREDETUPROYECTO
        ├── factories
        |
        ├── model
        |    ├── data
        |    ├── local
        |    └── remote
        |
        ├── network
        |
        ├── persistence
        |
        ├── repositories
        |
        └── ui
            ├── navigation
            ├── screens
            └── theme (Este viene por defecto)

```

3. Crear el archivo `MyApplication.kt` en `NOMBREDETUPROYECTO/ui`, y pegar esto:

```
import android.app.Application
import android.content.Context

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        private var application: Application? = null
        private fun getApplication(): Application {
            return application as Application
        }

        fun getContext(): Context {
            return getApplication().applicationContext
        }
    }
}
```

4. Agregar esto en `app/manifests/AndroidManifest.xml`, en la línea 4, o debajo de donde dice `<manifest xmlns:android xmlns:tools>`:

```
<uses-permission android:name="android.permission.INTERNET"/>
```

Y esto en la línea 7, o debajo de la línea que dice `<application`:

```
android:name=".MyApplication"
```
