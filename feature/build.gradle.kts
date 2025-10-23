plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.android.library.compose)
}

android {
    namespace = "com.yu.hu.feature"
}

dependencies {
    implementation(projects.core)
}