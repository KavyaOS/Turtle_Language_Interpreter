package sdsu.cs635.UnitTests;

import org.junit.jupiter.api.Test;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.*;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandExecuteVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Undo_Redo_On_Repeat {

    @Test
    public void Test_Undo_Redo_On_Repeat() {
        Turtle turtle = new Turtle("Empty_document.txt");
        ArrayList<CommandElement> commands = new ArrayList<>();

        commands.add(new Repeat(4));
        commands.add(new Move(10));
        commands.add(new Turn(90));
        commands.add(new Move(20));
        commands.add(new End());

        CommandProcessor commandProcessor=new CommandProcessor(commands);
        commandProcessor.processCommands(new CommandExecuteVisitor(),turtle);

        commandProcessor.redo(turtle);
        assertEquals(20,turtle.location().getX());

        commandProcessor.undo(turtle);
        assertEquals(0,turtle.location().getX());
    }
}
