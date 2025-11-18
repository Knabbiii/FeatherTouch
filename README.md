<div align="center">

![FeatherTouch Banner](.github/assets/FeatherTouch.png)

[![Spigot Downloads](https://img.shields.io/spiget/downloads/130005?style=for-the-badge&logo=spigotmc&color=d1d7dc)](https://www.spigotmc.org/resources/feathertouch.130005/)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/feathertouch?logo=modrinth&style=for-the-badge&label=Downloads&color=d1d7dc)](https://modrinth.com/plugin/feathertouch)
[![CodeFactor](https://img.shields.io/codefactor/grade/github/knabbiii/feathertouch?style=for-the-badge&logo=codefactor&color=d1d7dc&label=Code%20Quality)](https://www.codefactor.io/repository/github/knabbiii/feathertouch)
[![License: MIT](https://img.shields.io/github/license/knabbiii/feathertouch?color=d1d7dc&label=License&style=for-the-badge&logo=github)](https://opensource.org/licenses/MIT)
[![GitHub release](https://img.shields.io/github/v/release/knabbiii/feathertouch?style=for-the-badge&label=Release&color=d1d7dc&logo=github)](https://github.com/Knabbiii/feathertouch/releases)

</div>

> **Push mobs gently with feathers - no damage, just gentle nudges!**

A lightweight Minecraft plugin inspired by the community suggestion to use feathers for gentle mob pushing. Hit any mob with a feather to push them without causing damage or making them hostile.

**Simple, clean, and true to vanilla Minecraft feel**

## Features

- **🪶 Feather Touch** - Hit entities with feathers to push them without damage
- **⚡ Preserves Knockback** - Maintains the visual and physics effects of hits
- **🔊 Soft Whoosh Sound** - Satisfying audio feedback (configurable)
- **⏱️ Vanilla Timing** - Respects Minecraft's natural attack cooldown (600ms)
- **🔄 Reload Command** - Hot-reload configuration without restart
- **📊 Optional Metrics** - bStats integration that can be disabled anytime
- **🪶 Lightweight** - Minimal performance impact with clean event handling
- **🌟 Modern Compatibility** - Works with Spigot, Paper, Purpur and all modern versions

## Installation

1. Download the latest `.jar` file from the [releases page](https://github.com/Knabbiii/FeatherTouch/releases)
2. Place it in your server's `plugins` folder
3. Restart your server
4. Configure the plugin in `plugins/FeatherTouch/config.yml`

## Configuration

The plugin creates a simple `config.yml` file:

```yaml
# FeatherTouch Configuration
# A plugin that makes feather hits push without damage

# Enable/disable metrics collection (bStats)
# This helps the developer understand plugin usage
# You can disable this if you don't want to send anonymous usage data
metrics: true

# Plugin settings
settings:
  # Enable/disable the plugin functionality
  enabled: true
  
  # Play a soft whoosh sound when feather touch occurs
  sound: true
```

### Configuration Options

| Option | Description | Default |
|--------|-------------|---------|
| `settings.enabled` | Enable/disable plugin functionality | `true` |
| `settings.sound` | Enable custom whoosh sound effects | `true` |
| `metrics` | Enable bStats metrics collection | `true` |

## How to Use

1. **Get a Feather**: Obtain a feather from chickens or creative mode
2. **Gentle Push**: Left-click any mob with the feather in your main hand
3. **No Damage**: The mob gets pushed but takes no damage
4. **Stay Peaceful**: Neutral mobs won't become hostile from feather touches
5. **Natural Timing**: Follows vanilla attack cooldown for balanced gameplay

## Commands

| Command | Permission | Description |
|---------|------------|-------------|
| `/feathertouch reload` | `feathertouch.reload` | Reload plugin configuration |

**Aliases:** `/ft`

## Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `feathertouch.reload` | Allows reloading the plugin configuration | `op` |

## Requirements

- **Minecraft:** 1.20+ (compatible with 1.20.x and 1.21.x)
- **Server:** Spigot, Paper, or compatible
- **Java:** 21+ (LTS recommended)

## Inspiration

**Original Idea:** Reddit community suggestion - [r/minecraftsuggestions](https://www.reddit.com/r/minecraftsuggestions/comments/klq3k2/suggestion_if_you_punch_mob_while_holding_a/)

> "Suggestion to make so that if you punch a mob while holding a feather, it takes no damage and doesn't get hostile towards you (for iron golems, dogs etc.), that way you can push mobs wherever you like."

This plugin brings that brilliant community idea to life with a clean, lightweight implementation.

## Technical Details

- **Damage Prevention**: Completely cancels damage events for feather hits
- **Knockback Physics**: Applies gentle knockback (0.35 horizontal, 0.15 vertical)
- **Sound System**: Custom whoosh sounds with vanilla fallback option
- **Cooldown System**: 600ms cooldown matching vanilla attack timing
- **Event Priority**: Uses HIGHEST priority for reliable damage cancellation

## 📊 Statistics

This plugin uses [bStats](https://bstats.org/plugin/bukkit/FeatherTouch/27875) to collect anonymous usage statistics.

**To disable:** Set `metrics: false` in config.yml or `enabled: false` in `plugins/bStats/config.yml`

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔗 Links

- [Issues](https://github.com/knabbiii/FeatherTouch/issues)
- [Releases](https://github.com/knabbiii/FeatherTouch/releases)
- [bStats](https://bstats.org/plugin/bukkit/FeatherTouch/27875)
- [Original Reddit Suggestion](https://www.reddit.com/r/minecraftsuggestions/comments/klq3k2/suggestion_if_you_punch_mob_while_holding_a/)

## 📈 Changelog

### 1.0
- Initial release: Lightweight feather pushing plugin
- Core functionality: Feather hits remove damage but preserve knockback
- Configurable sound system with soft whoosh effects
- Vanilla-like 600ms attack cooldown system
- Simple reload command for configuration changes
- Optional bStats metrics integration
- Clean, professional code structure
- Compatible with Minecraft 1.20-1.21 on Spigot/Paper/Purpur

---

Made with ❤️ for the Minecraft community 🪶