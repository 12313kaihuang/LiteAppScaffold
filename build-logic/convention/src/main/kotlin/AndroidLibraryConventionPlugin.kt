import com.android.build.api.dsl.LibraryExtension
import com.yu.hu.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Android Library插件
 *
 * 配置基础插件&依赖&字段
 */
@Suppress("unused")
class AndroidLibraryConventionPlugin : Plugin<Project> {
    /**
     * 插件应用入口
     *
     * @param target 目标项目实例
     */
    override fun apply(target: Project) {
        with(target) {
            with(target.pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

        }
    }
}