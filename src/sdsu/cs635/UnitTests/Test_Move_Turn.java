package sdsu.cs635.UnitTests;

import org.junit.jupiter.api.Test;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CalculateTotalDistanceTraveledVisitor;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandExecuteVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Move_Turn {

    @org.junit.jupiter.api.Test
    public void testTurtleExecution() {
        Turtle turtle = new Turtle("turtleProgram1_a.txt");
        turtle.initiateCommandProcessor(new CommandExecuteVisitor());
        assertEquals(23, turtle.location().getX());
        assertEquals(28, turtle.location().getY());
    }

    @Test
    public void testTotalDistanceTravelled() {
        Turtle turtle = new Turtle ("turtleProgram1_a.txt");
        CalculateTotalDistanceTraveledVisitor distanceTraveled=new CalculateTotalDistanceTraveledVisitor();
        turtle.initiateCommandProcessor(distanceTraveled);
        assertEquals(45,distanceTraveled.getResult());
    }
}
