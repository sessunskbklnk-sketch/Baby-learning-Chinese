# Baby Learning Chinese 宝宝学汉字

给小朋友的识字小游戏，每个都是单文件 HTML，浏览器直接打开即可（朗读需浏览器有中文语音）。

| 游戏 | 文件 | 玩法 |
| --- | --- | --- |
| 汉字迷宫 Hanzi Maze | [games/hanzi-maze.html](games/hanzi-maze.html) | 3D 迷宫里找汉字石板，集齐开门；WebGL |
| 骑车闯关 | [games/bike-ride.html](games/bike-ride.html) | 骑进写对字的车道，栏杆抬起；自适应难度、贴纸 |
| 小青蛙过河 | [games/frog-crossing.html](games/frog-crossing.html) | 跳上写对字的荷叶；看图 / 听音 / 读字三级题型 |
| 狐狸指南针 Kettukompassi | [games/fox-compass.html](games/fox-compass.html) | 中文 + 芬兰语学东南西北；三个小游戏 |

共同点：
- 字库：数字、大自然、动物、身体、方位、颜色、食物、双字词
- 形近字干扰（日/目、人/入）
- Web Speech API 朗读，无中文语音时降级为看图题
- 进度存 `localStorage`，仅本机
