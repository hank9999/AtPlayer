# AtPlayer
A Minecraft Bukkit(Spigot) Plugin to at player in your server  

![https://hank9999.github.io/AtPlayer/image/1.png](https://hank9999.github.io/AtPlayer/image/1.png)
![https://hank9999.github.io/AtPlayer/image/2.png](https://hank9999.github.io/AtPlayer/image/2.png)

[English](#English)  
[中文](#中文)

## English
### Usage
Download latest releases to your server and reboot or plugman load

### Features
 - Custom message
 - Custom sounds
 - Custom title

### Permission
 - AtPlayer.use
   - at player perm
 - AtPlayer.admin
   - at all perm
   - /at perm
> Tip:
> /at enable/disable no need perm 

### Command
 - /at
 - /at help get command list
 - /at reload (Only admin)reload config
 - /at on (Only admin)enable at
 - /at off (Only admin)disable at
 - /at enable (player and admin)enable title and sounds notifications
 - /at disable (player and admin)disable title and sounds notifications

### Config
>Tip: 1.8 must modify sound config
>1.8 Sounds ID: [https://jd.bukkit.org/org/bukkit/Sound.html](https://jd.bukkit.org/org/bukkit/Sound.html)  
>1.9+Sounds ID: [https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Sound.html](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Sound.html)  

```yaml
# enable or disable at player
atall: true
# enable or disble at all
atplayer: true
# enable or disable admin cooldown bypass
bypass_cooldown: true
# cooldown
cooldown: 10
message:
  # at message
  at: '&bat you!'
  # at all message
  atall: '&b at all player!'
  # at all title
  have_atall: '&bYou have all player message'
  # at title
  have_at: '&bSomebody at you'
  # no perm message
  no_perm: '&cYou don not have permission to do this.'
  # cooldown message
  cooldown: 'Please wait %s% seconds'
sounds:
  # at sounds
  at:
    ENTITY_PLAYER_LEVELUP:
      volume: 1.0
      pitch: 1.0
  # at all sounds
  atall:
    ENTITY_GENERIC_EXPLODE:
      volume: 1.0
      pitch: 1.0
    ENTITY_PLAYER_LEVELUP:
      volume: 1.0
      pitch: 1.0
command_message:
  # enable title and sounds notifications message
  enable:
  - '&6Notifications Enabled'
  # disable title and sounds notifications message
  disable:
  - '&6Notifications Disabled'
  # enable at message
  m_on:
  - '&6AtPlayer Enabled'
  # disable at message
  m_off:
  - '&6AtPlayer Disabled'
  # no perm message
  no_perm:
  - '&cYou don not have permission to do this.'
  # command not exist message
  not_exist:
  - '&cThis command does not exist'

```
### LICENSE
MIT License

## 中文
### 使用方法
下载最新的版本然后重启服务器或者使用plugman加载

### 特点
 - 自定义消息
 - 自定义声音
 - 自定义标题

### 权限组
 - AtPlayer.use
   - at玩家的权限
 - AtPlayer.admin
   - at全体玩家的权限
   - at所有指令的权限
> 注:
> /at enable/disable无需权限组  

### 指令
 - /at
 - /at help 获取指令列表
 - /at reload (仅管理)重载插件配置
 - /at on (仅管理)开启at功能
 - /at off (仅管理)关闭at功能
 - /at enable (玩家个人设置)开启被at标题声音提醒
 - /at disable (玩家个人设置)关闭被at标题声音提醒

### 配置
>注: 1.8请修改声音配置  
>1.8 声音ID详见[https://jd.bukkit.org/org/bukkit/Sound.html](https://jd.bukkit.org/org/bukkit/Sound.html)  
>1.9+声音ID详见[https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Sound.html](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Sound.html)  

```yaml
# 是否开启at全体
atall: true
# 是否开启at玩家
atplayer: true
# 是否开启管理无冷却时间(at玩家)
bypass_cooldown: true
# 冷却时间
cooldown: 10
message:
  # 被at的消息
  at: '&b@了你!'
  # 被at全体的消息
  atall: '&b@了全体成员!'
  # 被at全体的标题
  have_atall: '&b你有一条全体消息'
  # 有人at你的标题
  have_at: '&b有人@了你'
  # 没权限提示
  no_perm: '&c你没有权限这么做'
  # 冷却提示
  cooldown: '请等待 %s% 秒'
sounds:
  # 被玩家at的声音
  at:
    ENTITY_PLAYER_LEVELUP:
      volume: 1.0
      pitch: 1.0
  # 被at全体的声音
  atall:
    ENTITY_GENERIC_EXPLODE:
      volume: 1.0
      pitch: 1.0
    ENTITY_PLAYER_LEVELUP:
      volume: 1.0
      pitch: 1.0
command_message:
  # 开启提醒的消息
  enable:
  - '&6提醒开启'
  # 关闭提醒的消息
  disable:
  - '&6提醒关闭'
  # 开启at功能的消息
  m_on:
  - '&6AtPlayer开启'
  # 关闭at功能的消息
  m_off:
  - '&6AtPlayer关闭'
  # 没权限的消息
  no_perm:
  - '&c你没有权限这么做'
  # 指令不存在的消息
  not_exist:
  - '&c这条指令不存在'

```
### 开源协议
MIT License