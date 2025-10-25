import com.yu.hu.configureAndroidRoom
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Android Library插件
 *
 * 引入Room相关依赖
 *
 * huyu create
 * 2025/10/22 9:19
 */
@Suppress("unused")
class AndroidLibraryRoomConventionPlugin : Plugin<Project> {
    /**
     * 插件应用入口
     *
     * @param target 目标项目实例
     */
    override fun apply(target: Project) {
        with(target) {
            configureAndroidRoom()
        }
    }
}