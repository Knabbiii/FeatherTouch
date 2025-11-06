# FeatherTouch

A simple Minecraft plugin that makes hitting with a feather remove damage but keep knockback, allowing players to gently push entities without harming them.

## Features

- 🪶 **Feather Touch**: Hit entities with feathers to push them without damage
- ⚡ **Preserves Knockback**: Maintains the visual and physics effects of hits
- � **Soft Whoosh Sound**: Satisfying audio feedback (configurable)
- �🛡️ **Permission System**: Bypass functionality with permissions
- ⚙️ **Configurable**: Enable/disable functionality and sounds
- 🔄 **Reload Command**: Hot-reload configuration without restart

## Installation

1. Download the latest `FeatherTouch-1.0.jar` from the releases
2. Place it in your server's `plugins` folder
3. Start or restart your server
4. Configure the plugin in `plugins/FeatherTouch/config.yml`

## Usage

Simply hit any entity with a feather in your main hand. The entity will be pushed back without taking any damage!

## Commands

- `/feathertouch` - Shows plugin information
- `/feathertouch reload` - Reloads the plugin configuration

## Permissions

- `feathertouch.bypass` - Allows normal feather damage (default: op)
- `feathertouch.reload` - Allows reloading the configuration (default: op)

## Configuration

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

### Metrics

FeatherTouch uses [bStats](https://bstats.org/) to collect anonymous usage statistics. This helps the developer understand how the plugin is being used and improve it. The data collected includes:

- Server player count
- Plugin version
- Server software version
- Java version and OS information

**No personal data is collected.** You can opt-out by setting `metrics: false` in the config or through the global bStats config.

## Compatibility

- **Minecraft Version**: 1.20.1+
- **Server Software**: Paper, Purpur, or any Paper-based server
- **Folia Support**: Yes

## Building from Source

1. Clone this repository
2. Run `./gradlew build`
3. Find the built JAR in `build/libs/`

## License

This plugin is released under the MIT License.

## Support

If you encounter any issues or have suggestions, please open an issue on the GitHub repository.