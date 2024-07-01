plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.comst.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(project(":domain"))

    // hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // serialization
    implementation(libs.kotlinx.serialization.json)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.serialization)
    implementation(libs.okhttp)

    // datastore
    implementation(libs.datastore)

    // lifecycle service
    implementation(libs.androidx.lifecycle.service)

    // paging3
    implementation(libs.paging.runtime)

    // room
    implementation(libs.room.runtime)
    implementation(libs.room.paging)
    kapt(libs.room.compiler)

    // test coroutines
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    androidTestImplementation("androidx.test:runner:1.5.2")

    // hilt + work
    implementation("androidx.work:work-runtime:2.9.0")
    implementation("androidx.hilt:hilt-work:1.2.0")
    kapt("androidx.hilt:hilt-compiler:1.2.0")
}