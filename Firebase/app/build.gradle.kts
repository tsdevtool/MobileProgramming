plugins {
//    alias(libs.plugins.android.application)
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    signingConfigs {
        create("my_config") {
            storeFile =
                file("C:\\Users\\admin\\OneDrive\\Desktop\\GithubClone\\MobileProgramming\\Firebase\\test_keystore.jks")
            storePassword = "123456"
            keyAlias = "Tincoder"
            keyPassword = "123456"
        }
    }
    namespace = "com.crissiiu.getsha1tutorial"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.crissiiu.getsha1tutorial"
        minSdk = 24
        targetSdk = 34
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
            signingConfig = signingConfigs.getByName("my_config")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //create firebase
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation("com.google.firebase:firebase-analytics")

    //Push notification
    //When using the Bom, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-messaging")


}