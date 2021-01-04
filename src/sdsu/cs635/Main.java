package sdsu.cs635;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CalculateTotalDistanceTraveledVisitor;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandExecuteVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

import java.io.IOException;

class Main {

    public static void main(String[] args) {

        Turtle turtle=new Turtle("turtleProgram1.txt");
        turtle.initiateCommandProcessor(new CommandExecuteVisitor());
        System.out.println(turtle.location().getX());
        System.out.println(turtle.location().getY());

        CalculateTotalDistanceTraveledVisitor distanceVisitor=new CalculateTotalDistanceTraveledVisitor();
        turtle.initiateCommandProcessor(distanceVisitor);
        System.out.println(distanceVisitor.getResult());

    }
}
