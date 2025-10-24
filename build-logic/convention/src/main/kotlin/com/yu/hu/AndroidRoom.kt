package com.yu.hu

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * 配置room相关依赖
 * https://developer.android.com/training/data-storage/room?hl=zh-cn
 *
 * huyu create
 * 2025/10/22 9:21
 */
internal fun Project.configureAndroidRoom() {
    with(pluginManager) {
        apply("androidx.room")
        apply("com.google.devtools.ksp")

        withPlugin("androidx.room") {
            extensions.findByName("room")?.let { roomExt ->
                val method = roomExt.javaClass.getMethod("schemaDirectory", String::class.java)
                println("配置room.schemaLocation:${projectDir}/schemas")
                method.invoke(roomExt, "$projectDir/schemas")
            }
        }
    }

    dependencies {
        "implementation"(libs.findLibrary("androidx.room.runtime").get())
        // optional - Kotlin Extensions and Coroutines support for Room
        "implementation"(libs.findLibrary("androidx.room.ktx").get())
        // optional - Paging 3 Integration
        "implementation"(libs.findLibrary("androidx.room.paging").get())

        "testImplementation"(libs.findLibrary("androidx.room.testing").get())

        "ksp"(libs.findLibrary("androidx.room.compiler").get())
    }
}