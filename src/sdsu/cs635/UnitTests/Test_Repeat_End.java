package sdsu.cs635.UnitTests;

import org.junit.jupiter.api.Test;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CalculateTotalDistanceTraveledVisitor;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandExecuteVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Repeat_End {
    @org.junit.jupiter.api.Test
    public void testTurtleExecution() {
        Turtle turtle = new Turtle("turtleProgram2.txt");
        turtle.initiateCommandProcessor(new CommandExecuteVisitor());
        assertEquals(0.0, turtle.location().getX());
        assertEquals(0.0, turtle.location().getY());
    }

    @Test
    public void testTotalDistanceTravelled() {
        Turtle turtle = new Turtle ("turtleProgram2.txt");
        CalculateTotalDistanceTraveledVisitor distanceTraveled=new CalculateTotalDistanceTraveledVisitor();
        turtle.initiateCommandProcessor(distanceTraveled);
        assertEquals(40,distanceTraveled.getResult());
    }


}
