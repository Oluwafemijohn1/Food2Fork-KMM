buildscript {
    val kotlin_version by extra("1.8.20-RC")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.buildTools)
//        classpath("com.android.tools.build:gradle:7.1.3")
        classpath(Build.sqlDelightGradlePlugin)
//        classpath("com.google.dagger:hilt-android-gradle-plugin:2.45")
        classpath(Build.hiltGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}