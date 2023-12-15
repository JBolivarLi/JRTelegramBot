import com.github.JBolivarLi.javarushtelegrambot.bot.command.Command;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.StopCommand;

import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.*;
import static com.github.JBolivarLi.javarushtelegrambot.bot.command.StopCommand.STOP_MESSAGE;

public class StopCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}
