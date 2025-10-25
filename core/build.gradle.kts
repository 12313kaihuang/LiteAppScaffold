plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.android.library.compose)
    alias(libs.plugins.custom.android.library.room)
    alias(libs.plugins.custom.library.kotlinSerilization)
}

android {
    namespace = "com.yu.hu.core"
}