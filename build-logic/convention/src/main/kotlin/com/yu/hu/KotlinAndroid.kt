package com.yu.hu

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

/**
 * android.application/android.library 通用配置
 */
fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = findProperty("compileSdk", 35)
        defaultConfig {
            minSdk = findProperty("minSdk", 26)
            testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        configure<KotlinAndroidProjectExtension> {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    dependencies {
        "implementation"(libs.findLibrary("androidx.core.ktx").get())
        "implementation"(libs.findLibrary("androidx.appcompat").get())
        "implementation"(libs.findLibrary("material").get())
        "testImplementation"(libs.findLibrary("junit").get())
        "androidTestImplementation"(libs.findLibrary("androidx.junit").get())
        "androidTestImplementation"(libs.findLibrary("androidx.espresso.core").get())
    }
}
