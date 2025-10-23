// 启用类型安全的项目访问器功能 可以通过projects.xx引入模块
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// Gradle插件管理配置
pluginManagement {
    // 包含build-logic目录作为构建逻辑模块
    includeBuild("build-logic")
    // 配置插件仓库
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

// 依赖解析管理配置
dependencyResolutionManagement {
    // 设置仓库模式为严格模式，禁止在项目中单独配置仓库
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // 配置项目级依赖仓库
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LiteAppScaffold"
include(":app")
include(":core")
include(":feature")
 