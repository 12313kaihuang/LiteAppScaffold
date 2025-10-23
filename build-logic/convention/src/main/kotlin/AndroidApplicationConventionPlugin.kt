import com.android.build.api.dsl.ApplicationExtension
import com.yu.hu.configureKotlinAndroid
import com.yu.hu.findProperty
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Android Application插件
 *
 * 配置基础插件&依赖&字段
 */
@Suppress("unused")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    /**
     * 插件应用入口
     *
     * @param target 目标项目实例
     */
    override fun apply(target: Project) {
        with(target) {
            with(target.pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    applicationId = target.findProperty("applicationId", "com.yu.hu")
                    targetSdk = target.findProperty("targetSdk", 35)
                }
            }

        }
    }
}