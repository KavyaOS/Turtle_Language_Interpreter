package sdsu.cs635.UnitTests;

import org.junit.jupiter.api.Test;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CalculateTotalDistanceTraveledVisitor;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandExecuteVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_distanceTo_bearingTo {
    @org.junit.jupiter.api.Test
    public void testTurtleExecution() {
        Turtle turtle = new Turtle("turtleProgram3.txt");
        turtle.initiateCommandProcessor(new CommandExecuteVisitor());
        assertEquals(20, turtle.location().getX());
        assertEquals(18, turtle.location().getY());
    }

    @Test
    public void testTotalDistanceTravelled() {
        Turtle turtle = new Turtle ("turtleProgram3.txt");
        CalculateTotalDistanceTraveledVisitor distanceTraveled=new CalculateTotalDistanceTraveledVisitor();
        turtle.initiateCommandProcessor(distanceTraveled);
        assertEquals(74,distanceTraveled.getResult());
    }
}
