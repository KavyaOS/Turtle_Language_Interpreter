package sdsu.cs635.UnitTests;

import org.junit.jupiter.api.Test;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.Assignment;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.CommandElement;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.Move;
import sdsu.cs635.TurtleOperations.Turtle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Undo_Redo {


    @Test
    public void test_Undo_Redo() {
        Turtle turtle = new Turtle("Empty_document.txt");
        CommandElement command = new Move(10);
        command.execute(turtle);

        command.redo(turtle);
        assertEquals(20,turtle.location().getX());

        command.undo(turtle);
        assertEquals(10, turtle.location().getX());

        command = new Assignment('k',22);
        command.undo(turtle);
        assertEquals(null,turtle.getVariables().get('k'));

        command.redo(turtle);
        assertEquals(22,turtle.getVariables().get('k'));
    }
}