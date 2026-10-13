# 宝宝学汉字 · Baby Learning Chinese

给 3–8 岁孩子的汉字识字小游戏合集。纯静态网页，无需安装、无需账号、不收集数据，手机、平板、电脑浏览器打开就能玩。

A collection of browser games that help young children learn Chinese characters through listening, looking and reading. Static HTML, no build step, no tracking.

[![Android APK](https://github.com/sessunskbklnk-sketch/Baby-learning-Chinese/actions/workflows/android.yml/badge.svg)](https://github.com/sessunskbklnk-sketch/Baby-learning-Chinese/actions/workflows/android.yml)

## 📱 下载安卓 App · Download for Android

**[⬇️ 下载 baby-learning-chinese.apk](https://github.com/sessunskbklnk-sketch/Baby-learning-Chinese/releases/latest/download/baby-learning-chinese.apk)**（所有版本见 [Releases](https://github.com/sessunskbklnk-sketch/Baby-learning-Chinese/releases)）

1. 用安卓手机 / 平板打开上面的链接下载 APK
2. 打开下载的文件，按提示允许「安装未知来源应用」
3. 安装后桌面出现「宝宝学汉字」🐸，离线可玩

要求 Android 8.0 及以上。App 使用系统朗读引擎读中文；若没有声音，到 **设置 → 文字转语音** 选择 Google 引擎并下载中文（普通话）语音。

## 游戏 · Games

| | 游戏 | 玩法 | 适合 | 操作 |
|---|---|---|---|---|
| 🐸 | [小青蛙过河 Frog Crossing](games/frog-crossing/) | 跳上写对字的荷叶，送小青蛙回家 | 3–6 岁 | 触屏 / 鼠标 |
| 🚲 | [骑车闯关 Bike Ride](games/bike-ride/) | 骑进写对字的车道，栏杆才会抬起 | 3–6 岁 | 触屏 / 鼠标 / ← ↑ → |
| 🧩 | [汉字迷宫 Hanzi Maze](games/hanzi-maze/) | 3D 迷宫里找汉字石板，集齐开门，结尾小测验 | 5–8 岁 | WASD + 鼠标 / 双摇杆触屏 |
| 🦊 | [狐狸指南针 Kettukompassi](games/fox-compass/) | 中文 + 芬兰语学东南西北，含 3 个小游戏 | 5–8 岁 | 触屏 / 鼠标 / 键盘 |

### 学习内容

- **小青蛙过河 / 骑车闯关**：8 组字库，约 80 个常用字 + 16 个双字词 —— 数字、大自然、小动物、我的身体、上下左右、颜色、好吃的、两个字
- **汉字迷宫**：5 组字库 × 10 字 —— 数字、大自然、小动物、人和身体、方位和大小；3 种迷宫大小
- **狐狸指南针**：8 个方向（北、东北、东……），中文 / 芬兰语 / 双语三种模式；游戏：小狐狸回家、小动物在哪边、翻牌配对

## 特点 · Highlights

- **自适应难度**：每个字有 0–4 级熟练度，一次答对升级、答错降级；题型从「看图 + 听音找字」→「只听声音找字」→「看字选图」
- **形近字干扰**：熟练后混入长得像的字（日 / 目、人 / 入、木 / 本），训练看清笔画
- **真人发音**：使用浏览器 Web Speech API 朗读普通话；找不到中文语音时自动换成看图题，不会用错误语言乱读
- **家长设置**：拼音显示（答对后 / 一直 / 不显示）、朗读开关、语速、音效
- **奖励机制**：星星、贴纸收集、撒花
- **隐私**：进度只存在本机 `localStorage`，不联网上报

详见 [docs/learning-design.md](docs/learning-design.md)。

## 快速开始 · Getting started

直接双击 `index.html` 即可打开。推荐用本地服务器（部分浏览器对 `file://` 有限制）：

```bash
python3 -m http.server 8000
# 打开 http://localhost:8000
```

### 构建安卓 App

见 [android/README.md](android/README.md)。每次推送到默认分支，GitHub Actions 会自动构建 APK 并发布到 Releases。

### 部署到 GitHub Pages

仓库已含 `.nojekyll`。在 GitHub 仓库 **Settings → Pages** 中选择 *Deploy from a branch*，分支选 `main`、目录 `/ (root)`，保存后即可通过 `https://<user>.github.io/Baby-learning-Chinese/` 访问。

## 浏览器支持 · Browser support

| 功能 | 要求 |
|---|---|
| 基本游戏 | 近两年的 Chrome / Edge / Safari / Firefox |
| 汉字迷宫 | 需要 WebGL |
| 中文朗读 | 系统需有中文语音。iOS / macOS 自带；Windows 用 Edge；Android 在「文字转语音」中安装中文 |
| 芬兰语朗读 | 电脑用 Edge；Android 用 Google TTS 下载 suomi 语音 |

字体通过 Google Fonts 加载（ZCOOL KuaiLe、Andika、Noto Serif SC），离线时自动回退到系统楷体 / 宋体。

## 目录结构 · Project structure

```
.
├── index.html               # 游戏大厅
├── android/                 # 安卓 App（WebView 包装 + 系统 TTS）
├── games/
│   ├── frog-crossing/       # 小青蛙过河
│   ├── bike-ride/           # 骑车闯关
│   ├── hanzi-maze/          # 汉字迷宫
│   └── fox-compass/         # 狐狸指南针
└── docs/
    └── learning-design.md   # 教学设计与扩展字库说明
```

每个游戏是一个自包含的 `index.html`（HTML + CSS + JS），无外部依赖、无构建步骤。安卓 App 在构建时把这些网页打包进 APK。

## 贡献 · Contributing

欢迎提 Issue 或 PR：新增字库、修正拼音、适配更多设备。修改字库的方法见 [docs/learning-design.md](docs/learning-design.md#扩展字库)。
