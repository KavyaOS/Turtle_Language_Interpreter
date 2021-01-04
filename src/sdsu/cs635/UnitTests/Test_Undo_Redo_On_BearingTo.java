package sdsu.cs635.UnitTests;

import org.junit.jupiter.api.Test;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.BearingTo;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.CommandElement;
import sdsu.cs635.TurtleOperations.Point;
import sdsu.cs635.TurtleOperations.Turtle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Undo_Redo_On_BearingTo {

    @Test
    public void Test_Undo_Redo_On_BearingTo() {
        Turtle turtle = new Turtle("Empty_document.txt");
        Point point = new Point(10, 20);
        CommandElement command = new BearingTo('a', point);//Computes distance to point and assign it to variable a
        command.undo(turtle);
        assertEquals(null, turtle.getVariables().get('a'));

        command.redo(turtle);
        assertEquals(63, Math.round((double) turtle.getVariables().get('a')));
    }
}
