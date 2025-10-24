import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`  // 必须，表示这是 Kotlin DSL Gradle 插件工程
}

// 配置构建逻辑插件以目标 JDK 11
// 这与用于构建项目的 JDK 匹配，与设备上运行的内容无关
java {
    // 设置Java源代码和目标字节码的兼容性版本为Java 11
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
}

// 声明构建逻辑模块的依赖
dependencies {
    // 添加Android Gradle插件依赖（仅编译时需要）
    compileOnly(libs.android.gradlePlugin)
    // 添加Kotlin Gradle插件依赖（仅编译时需要）
    compileOnly(libs.kotlin.gradlePlugin)
    // 添加KSP注解处理器插件依赖（仅编译时需要）
    compileOnly(libs.ksp.gradlePlugin)
}

// 配置Gradle插件
gradlePlugin {
    plugins {
        val prefix = "com.yu.hu"
        // Android Application 插件
        register("androidApplication") {
            id = "${prefix}.application"  // 子模块引用的 ID
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "${prefix}.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        // Android Library 插件
        register("androidLibrary") {
            id = "${prefix}.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "${prefix}.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibraryRoom") {
            id = "${prefix}.library.room"
            implementationClass = "AndroidLibraryRoomConventionPlugin"
        }
    }

}