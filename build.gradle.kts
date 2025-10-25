// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    // Kotlin Serialization插件，自动为@Serializable注解的数据类生成序列化/反序列化代码；
    alias(libs.plugins.kotlin.serialization) apply false
    // KSP (Kotlin Symbol Processing)插件，用于注解处理
    alias(libs.plugins.google.ksp) apply false
    // 简化 Room 数据库相关的注解处理、Schema 导出、增量编译配置。
    alias(libs.plugins.androidx.room) apply false
}