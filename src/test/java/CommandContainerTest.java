import com.github.JBolivarLi.javarushtelegrambot.bot.command.Command;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandContainer;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.UnknownCommand;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
class CommandContainerTest {
    private CommandContainer commandContainer;
    @BeforeEach
    public void unit() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }
    @Test
    public void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }
    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String unknownCommand = "/fgjhdfgdf";

        //when
        Command command = commandContainer.retrieveCommand(unknownCommand);


        //then
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }


}
