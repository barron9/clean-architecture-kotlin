import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

fun Project.commonDep() {
    dependencies {
        "testImplementation"("org.junit.jupiter:junit-jupiter-api:5.7.0")
        "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:5.7.0")
        "implementation"("io.reactivex.rxjava2:rxjava:2.2.21")
        "implementation"("com.google.dagger:dagger:2.37")
        "kapt"("com.google.dagger:dagger-compiler:2.37")
    }
}

fun Project.dataModuleDep() {
    tasks.getByName("build").dependsOn("buildclean")
    task("buildclean").run {
        delete("${projectDir}/build/")
    }
    dependencies {
        "implementation"(project(":domain"))
    }
}

fun Project.networkModuleDep() {
    dependencies {
        "implementation"(project(":domain"))
        "implementation"("com.squareup.retrofit2:retrofit:2.9.0")
        "implementation"("com.squareup.retrofit2:converter-gson:2.9.0")
    }
}


fun Project.androidUIDep() {
    apply(plugin = "com.android.application")
    apply(plugin = "kotlin-android")
   // configure<AppExtension>("android") {
    tasks.getByName("build").dependsOn("buildclean")
    task("buildclean").run {
        delete("${projectDir}/build/")
     }
  //  task("build").dependsOn("build2")
    //}
    dependencies {
        "implementation"(project(":data"))
        "implementation"(project(":domain"))
        "implementation"(project(":network"))

        "kapt"("androidx.room:room-compiler:2.3.0")
        "implementation"("androidx.room:room-ktx:2.3.0")
        "implementation"("androidx.room:room-runtime:2.3.0")

        "implementation"("com.google.dagger:dagger:2.37")
        "implementation"("androidx.navigation:navigation-fragment-ktx:2.3.0")
        "implementation"("androidx.navigation:navigation-ui-ktx:2.3.0")
        "implementation"("androidx.fragment:fragment-ktx:1.3.6")
        "implementation"("androidx.legacy:legacy-support-v4:1.0.0")
        "implementation"("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
        "implementation"("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
        "kapt"("com.google.dagger:dagger-compiler:2.37")
        "implementation"("io.reactivex.rxjava2:rxjava:2.2.21")
        "implementation"("io.reactivex.rxjava2:rxandroid:2.1.1")
      //  "implementation"("org.openjfx:javafx:11")
     //   "implementation"("org.openjfx:javafx-controls:11")

      //  "implementation"("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")

        "implementation"("androidx.appcompat:appcompat:1.2.0")
        "implementation"("androidx.constraintlayout:constraintlayout:1.1.3")
        "testImplementation"("junit:junit:4.+")
        "androidTestImplementation"("androidx.test.ext:junit:1.1.1")
        "androidTestImplementation"("androidx.test.espresso:espresso-core:3.1.0")
    }
}
