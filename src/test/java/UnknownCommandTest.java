import com.github.JBolivarLi.javarushtelegrambot.bot.command.Command;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.UnknownCommand;

import static com.github.JBolivarLi.javarushtelegrambot.bot.command.UnknownCommand.UNKNOWN_MESSAGE;

public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/kdjfksdjfksj";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
