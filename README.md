# aimedia-bot


AIMedia Bot is a Telegram bot that generates images based on user-provided prompts using the OpenAI API. This project leverages Spring Boot to create a user-friendly interface for generating high-quality images.

## Features

- Generate images from text prompts.
- Easy integration with Telegram for user interactions.
- Powered by the OpenAI API for state-of-the-art image generation.

## Prerequisites

Before running the bot, ensure you have the following:

- Java 17 or higher
- Maven
- A Telegram bot token (you can create a bot using the BotFather on Telegram)
- OpenAI API key

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/aryanverma2199/aimedia-bot.git
cd aimedia-bot
2. Update application properties
Edit the src/main/resources/application.properties file to include your bot token and OpenAI API key:


bot.username=@your_bot_username
bot.token=your_bot_token
cloudinary.cloud.name=your_cloud_name
cloudinary.api.key=your_api_key
cloudinary.api.secret=your_api_secret
openai.api.key=your_openai_api_key
3. Build the project
Make sure you have Maven installed. Run the following command to build the project:

bash
Copy code
mvn clean install
4. Run the application
You can run the bot using the following command:

bash
Copy code
mvn spring-boot:run
5. Interact with the bot
Open Telegram and search for your bot using its username. Start a chat and provide prompts to generate images.

Contributing
If you'd like to contribute to this project, feel free to fork the repository and submit a pull request. Any improvements, suggestions, or bug fixes are welcome!

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgements
OpenAI for providing the API.
Telegram Bot API for enabling easy bot creation.
