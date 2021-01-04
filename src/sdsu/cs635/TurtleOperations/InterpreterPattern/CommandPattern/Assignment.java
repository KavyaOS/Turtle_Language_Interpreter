package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

public class Assignment implements CommandElement {

    private Character variable;
    private Object value;

    public Assignment(Character variable,Object value)
    {
        this.variable=variable;
        this.value=value;
    }

    @Override
    public void accept(CommandVisitor commandVisitor, Turtle turtle) {
        commandVisitor.visit(this,turtle);
    }

    @Override
    public String expressionType() {
        return "assignment";
    }

    @Override
    public void execute(Turtle turtle) {
        turtle.addVariable(variable,value);
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
