import com.yu.hu.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * 模块通用插件
 *
 * 引入kotlin-serialization相关依赖
 *
 * huyu create
 * 2025/10/22 9:19
 */
@Suppress("unused")
class CommonLibrarySerializationConventionPlugin : Plugin<Project> {
    /**
     * 插件应用入口
     *
     * @param target 目标项目实例
     */
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                // serialization
                "implementation"(libs.findLibrary("kotlinx.serialization.json").get())
            }
        }
    }
}