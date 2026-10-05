plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.firebase.appdistribution")
}

android {
    namespace = "com.example.bibleverse"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bibleverse"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }
}

kotlin {
    jvmToolchain(17)
}

firebaseAppDistributionDefault {
    appId = "1:687422664521:android:af5bee2cafee1cdcbab498"
    serviceCredentialsFile = System.getenv("GOOGLE_APPLICATION_CREDENTIALS")
    releaseNotes = "Daily Verse reference generator"
}
