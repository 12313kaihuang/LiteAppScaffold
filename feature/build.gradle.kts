plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.android.library.compose)
    alias(libs.plugins.custom.library.kotlinSerialization)
}

android {
    namespace = "com.yu.hu.feature"
}

dependencies {
    implementation(projects.core)
}