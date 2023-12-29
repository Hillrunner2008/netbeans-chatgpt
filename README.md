# NetBeans ChatGPT Plugin

This plugin allows you to use OpenAI's APIs to generate chat responses directly in NetBeans. I'll probably add some editor context menu actions to speed up code suggestions, but for now its a simple UI for chat that lives in Netbeans.

![Screenshot](screenshots/demo.png)

## Installation

1. [Download the plugin file (.nbm file)](https://github.com/Hillrunner2008/netbeans-chatgpt/releases/download/0.0.1/netbeans-chatgpt-0.0.1.nbm)
2. In NetBeans, go to `Tools > Plugins`.
3. Click on the `Downloaded` tab.
4. Click on the `Add Plugins...` button and select the downloaded ZIP file.
5. Set the `OPENAI_TOKEN` environment variable with your OpenAI API key
6. Restart NetBeans

## Usage

Before you can use this plugin, you need to set the `OPENAI_TOKEN` environment variable with your OpenAI API key. Below are instructions for different operating systems:

### Setting the OPENAI_TOKEN Environment Variable

#### Unix-like Systems (Linux, macOS)
Open a terminal and run the following command to set the environment variable. This will be temporary and limited to the current session:
```bash
export OPENAI_TOKEN=your_token_here
```
To make it permanent, add the line to your shell configuration file (~/.bashrc, ~/.zshrc, etc.):
```
echo 'export OPENAI_TOKEN=your_token_here' >> ~/.bashrc  # For Bash
echo 'export OPENAI_TOKEN=your_token_here' >> ~/.zshrc   # For Zsh
```
#### Windows 
##### Windows Powershell
Open powershell Prompt and run:
```
[Environment]::SetEnvironmentVariable("OPENAI_TOKEN", "your_token_here", [System.EnvironmentVariableTarget]::User)
```
##### Windows Using System GUI

1. Right-click on 'This PC' or 'Computer' on the desktop or in File Explorer.
2. Choose 'Properties'.
3. Click on 'Advanced system settings'.
4. In the 'System Properties' window, click on the 'Environment Variables...' button.
5. Under the 'User variables' section, click 'New...' to create a new environment variable.
6. Enter `OPENAI_TOKEN` as the variable name and your OpenAI API key as the variable value.
7. Click 'OK' to save.

After setting the `OPENAI_TOKEN` environment variable through the system properties, you'll need to restart any Command Prompts or IDEs for the new setting to take effect.
