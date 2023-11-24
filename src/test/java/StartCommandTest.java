import com.github.JBolivarLi.javarushtelegrambot.bot.command.Command;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.StartCommand;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.StopCommand;

import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.*;
import static com.github.JBolivarLi.javarushtelegrambot.bot.command.StartCommand.START_MESSAGE;

public class StartCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
