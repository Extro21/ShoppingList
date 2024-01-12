plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.extro.vostr.shoppinglist"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.extro.vostr.shoppinglist"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation ("androidx.navigation:navigation-runtime-ktx:2.3.5")

    implementation ("com.github.siyamed:android-shape-imageview:0.9.+@aar")
    // Room

    implementation("androidx.room:room-runtime:2.5.1")
    kapt("androidx.room:room-compiler:2.5.1")
    implementation("androidx.room:room-ktx:2.5.1")

    //куротины
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx")

    implementation ("androidx.annotation:annotation:1.3.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")


    implementation ("androidx.fragment:fragment-ktx:1.5.5")

    implementation ("io.insert-koin:koin-android:3.3.0")
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("com.google.code.gson:gson:2.10")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    modules {
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk7") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk7 is now part of kotlin-stdlib")
        }
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk8") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk8 is now part of kotlin-stdlib")
        }
    }



////koin
//    implementation ("io.insert-koin:koin-android:3.3.0")
//
////Navigation Graph
//    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
//    implementation ("androidx.navigation:navigation-ui-ktx:2.7.5")
//    implementation ("androidx.fragment:fragment-ktx:1.6.2")
//
//    implementation("androidx.preference:preference-ktx:1.2.1")
//
//    //ViewModel and livedata
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//
//    // RoomDatabase
// //   def room_version = "2.3.0"
//    implementation("androidx.room:room-runtime:2.5.1")
//    kapt("androidx.room:room-compiler:2.5.1")
//    implementation("androidx.room:room-ktx:2.5.1")
//
//// Coroutines
// //   def coroutines_version = "1.3.9"
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
//
//// Navigation Component
//   // def nav_version = "2.3.5" // same as in build.gradle (:project)
//    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
//    implementation("androidx.navigation:navigation-ui-ktx:2.7.2")
//
////old
//    implementation("androidx.core:core-ktx:1.12.0")
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.9.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}