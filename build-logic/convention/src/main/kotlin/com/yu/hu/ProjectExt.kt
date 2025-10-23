package com.yu.hu

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>()
        .named("libs")

/**
 * 获取gradle.properties中的字段值
 *
 * @param name 字段名
 * @param defaultValue 默认值
 */
inline fun <reified T> Project.findProperty(name: String, defaultValue: T): T {
    val property = findProperty(name)?.toString() ?: return defaultValue
    return when (T::class) {
        String::class -> property as T
        Int::class -> property.toIntOrNull() as? T ?: defaultValue
        Boolean::class -> property.toBooleanStrictOrNull() as? T ?: defaultValue
        else -> throw IllegalArgumentException("unsupported type ${T::class}")
    }.also {
        logger.debug("build Property {} -> {}", name, it)
    }
}