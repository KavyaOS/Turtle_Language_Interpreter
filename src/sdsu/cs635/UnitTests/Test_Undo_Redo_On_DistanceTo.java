package sdsu.cs635.UnitTests;

import org.junit.jupiter.api.Test;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.CommandElement;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.DistanceTo;
import sdsu.cs635.TurtleOperations.Point;
import sdsu.cs635.TurtleOperations.Turtle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Undo_Redo_On_DistanceTo {
    @Test
    public void Test_Undo_Redo_On_BearingTo_DistanceTo() {
        Turtle turtle = new Turtle("Empty_document.txt");
        Point point=new Point(10,20);
        CommandElement command = new DistanceTo(point,'a');//Computes distance to point and assign it to variable a

        command.undo(turtle);
        assertEquals(null,turtle.getVariables().get('a'));

        command.redo(turtle);
        assertEquals(22,Math.round((double)turtle.getVariables().get('a')));

    }
}
