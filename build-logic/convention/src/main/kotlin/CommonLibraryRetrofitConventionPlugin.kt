import com.yu.hu.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * 模块通用插件
 *
 * 配置Retrofit相关依赖
 *
 * huyu create
 * 2025/10/25 15:19
 */
@Suppress("unused")
class CommonLibraryRetrofitConventionPlugin : Plugin<Project> {
    /**
     * 插件应用入口
     *
     * @param target 目标项目实例
     */
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.yu.hu.library.kotlinSerialization")

            dependencies {
                "implementation"(libs.findLibrary("squareup.retrofit").get())
                "implementation"(libs.findLibrary("squareup.okhttp.logging.interceptor").get())
                // optional converter
                "implementation"(libs.findLibrary("squareup.retrofit.converter.serialization").get())
            }

        }
    }
}