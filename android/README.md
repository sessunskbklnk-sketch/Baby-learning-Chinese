# Android App

把仓库里的网页游戏打包成离线安卓 App（WebView + 系统中文朗读）。

- 构建时 `copyWebAssets` 任务把根目录的 `index.html` 和 `games/` 复制进 APK 的 `assets/www`
- `TtsBridge` 向网页暴露 `window.AndroidTTS`，游戏用它调用系统 TTS 读中文 / 芬兰语
- 最低 Android 8.0（API 26）

## 本地构建

需要 JDK 17 和 Android SDK（API 35）：

```bash
cd android
./gradlew assembleRelease
# 输出：app/build/outputs/apk/release/app-release.apk
```

## 发布

推送 `v*` 标签会触发 [Android APK](../.github/workflows/android.yml) 工作流，并把 `baby-learning-chinese.apk` 附到 GitHub Release。其它推送只上传构建产物（Actions → Artifacts）。

### 正式签名

未配置签名时使用 debug 密钥签名，可以安装，但每次 CI 的 debug 密钥不同，**新版本无法覆盖安装旧版本**。正式发布前请生成固定密钥并添加仓库 Secrets：

```bash
keytool -genkeypair -v -keystore release.jks -alias babychinese \
  -keyalg RSA -keysize 2048 -validity 10000
base64 -w0 release.jks   # 结果填入 ANDROID_KEYSTORE_BASE64
```

| Secret | 内容 |
|---|---|
| `ANDROID_KEYSTORE_BASE64` | `release.jks` 的 base64 |
| `ANDROID_KEYSTORE_PASSWORD` | 密钥库密码 |
| `ANDROID_KEY_ALIAS` | 别名，如 `babychinese` |
| `ANDROID_KEY_PASSWORD` | 密钥密码 |

`release.jks` 不要提交到仓库。
