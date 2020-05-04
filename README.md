# AtPlayer
A Minecraft Bukkit(Spigot) Plugin to at player in your server  

## English
### 
## 中文
### 配置
```yaml
atall: true
atplayer: true
bypass_cooldown: true
cooldown: 10
message:
  at: '&b@了你!'
  atall: '&b@了全体成员!'
  have_atall: '&b你有一条全体消息'
  have_at: '&b有人@了你'
  no_perm: '&c你没有权限这么做'
  cooldown: '请等待 %s% 秒'
sounds:
  at:
    ENTITY_PLAYER_LEVELUP:
      volume: 1.0
      pitch: 1.0
  atall:
    ENTITY_GENERIC_EXPLODE:
      volume: 1.0
      pitch: 1.0
    ENTITY_PLAYER_LEVELUP:
      volume: 1.0
      pitch: 1.0
command_message:
  enable:
  - '&6提醒开启'
  disable:
  - '&6提醒关闭'
  m_on:
  - '&6AtPlayer开启'
  m_off:
  - '&6AtPlayer关闭'
  no_perm:
  - '&c你没有权限这么做'
  not_exist:
  - '&c这条指令不存在'

```