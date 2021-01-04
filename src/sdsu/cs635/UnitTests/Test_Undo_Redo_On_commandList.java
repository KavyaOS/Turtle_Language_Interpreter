package sdsu.cs635.UnitTests;

import org.junit.jupiter.api.Test;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.CommandElement;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.CommandProcessor;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.Move;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.Turn;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandExecuteVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Undo_Redo_On_commandList {

    @Test
    public void Test_Undo_Redo_On_commandList() {
        Turtle turtle = new Turtle("Empty_document.txt");
        ArrayList<CommandElement> commands = new ArrayList<>();
        commands.add(new Move(10));
        commands.add(new Turn(90));
        commands.add(new Move(20));

        CommandProcessor commandProcessor=new CommandProcessor(commands);
        commandProcessor.processCommands(new CommandExecuteVisitor(),turtle);

        commandProcessor.undo(turtle);
        assertEquals(10,turtle.location().getX());

        commandProcessor.undo(turtle);
        assertEquals(0,turtle.direction());

        commandProcessor.undo(turtle);
        assertEquals(0,turtle.location().getX());

        commandProcessor.redo(turtle);
        assertEquals(10,turtle.location().getX());
    }
}