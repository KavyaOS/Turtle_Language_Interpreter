package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Point;
import sdsu.cs635.TurtleOperations.Turtle;

public class DistanceTo implements CommandElement{
    Point point;
    Character variable;

    public DistanceTo(Point point, Character variable)
    {
        this.point=point;
        this.variable=variable;
    }

    @Override
    public void accept(CommandVisitor commandVisitor, Turtle turtle) {
        commandVisitor.visit(this,turtle);
    }

    @Override
    public String expressionType() {
        return "distanceTo";
    }

    @Override
    public void execute(Turtle turtle) {
        turtle.addVariable(variable,turtle.distanceTo(point));
    }

    @Override
    public void undo(Turtle turtle) {
        turtle.removeVariable(variable);
    }

    @Override
    public void redo(Turtle turtle) {
        execute(turtle);
    }
}
