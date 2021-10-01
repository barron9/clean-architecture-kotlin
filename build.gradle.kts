import org.gradle.api.internal.artifacts.dependencies.*;
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath ("com.android.tools.build:gradle:4.2.2")
    }
}
plugins {
   // base
   // java
    kotlin("jvm") version "1.3.70" apply false
    kotlin("kapt") version "1.5.31"
}


/*sourceSets {
    main {
        java {
            srcDir("${buildDir}/generated/source/kapt2/main")
        }
    }
}*/
repositories {
    mavenCentral()
    google()
}





