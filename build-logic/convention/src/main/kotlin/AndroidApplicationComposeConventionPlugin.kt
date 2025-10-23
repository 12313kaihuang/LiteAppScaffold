import com.android.build.api.dsl.ApplicationExtension
import com.yu.hu.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Android Application插件
 *
 * 添加compose相关依赖
 */
@Suppress("unused")
class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    /**
     * 插件应用入口
     *
     * @param target 目标项目实例
     */
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                configureAndroidCompose(this)
            }
        }
    }
}