#!/bin/bash
# ===========================================
# LiteAppScaffold Setup Script
# 用于快速替换包名、移动源码路径、更新配置
# Usage: ./setup.sh com.example
# ===========================================

set -e

OLD_PACKAGE="com.yu.hu"
NEW_PACKAGE="$1"

if [ -z "$NEW_PACKAGE" ]; then
  echo "❌ 请输入新的包名，例如："
  echo "   ./setup.sh com.example"
  exit 1
fi

echo "🔧 开始替换包名：$OLD_PACKAGE → $NEW_PACKAGE"

# 1. 替换文件内容中的包名
echo "🧩 替换代码与配置文件中的包名..."
find . -type f \( \
  -name "*.kt" -o \
  -name "*.java" -o \
  -name "*.xml" -o \
  -name "*.gradle" -o \
  -name "*.gradle.kts" -o \
  -name "AndroidManifest.xml" -o \
  -name "build.gradle" -o \
  -name "build.gradle.kts" \
\) -print0 | xargs -0 sed -i.bak "s/${OLD_PACKAGE//./\\.}/${NEW_PACKAGE//./\\.}/g"

# 删除 .bak 备份文件
find . -type f -name "*.bak" -delete

# 2. 移动源码目录
echo "📂 调整源码目录结构..."

OLD_PATH=${OLD_PACKAGE//./\/}
NEW_PATH=${NEW_PACKAGE//./\/}

find . -type d -path "*/src/main/java/${OLD_PATH}" | while read -r DIR; do
  NEW_DIR=$(echo "$DIR" | sed "s#${OLD_PATH}#${NEW_PATH}#g")
  mkdir -p "$NEW_DIR"
  mv "$DIR"/* "$NEW_DIR"/ 2>/dev/null || true
  rm -rf "$(dirname "$DIR")"
  echo "✅ $DIR → $NEW_DIR"
done

# 3. 更新 gradle.properties 中的 APP_PACKAGE_NAME（如果存在）
if grep -q "APP_PACKAGE_NAME" gradle.properties 2>/dev/null; then
  echo "📝 更新 gradle.properties 中的 APP_PACKAGE_NAME..."
  sed -i.bak "s/APP_PACKAGE_NAME=.*/APP_PACKAGE_NAME=${NEW_PACKAGE}/g" gradle.properties
  rm -f gradle.properties.bak
fi

# 4. 清理 Gradle 缓存文件
echo "🧹 清理构建缓存..."
rm -rf .gradle/ build/ */build/

echo "✅ 包名替换完成！"
echo "新包名: $NEW_PACKAGE"
echo
echo "🚀 下一步建议："
echo "1️⃣ 检查 build.gradle.kts 的 namespace/applicationId 是否读取 gradle.properties"
echo "2️⃣ 运行 'gradlew clean assembleDebug' 验证项目是否能正常构建"
