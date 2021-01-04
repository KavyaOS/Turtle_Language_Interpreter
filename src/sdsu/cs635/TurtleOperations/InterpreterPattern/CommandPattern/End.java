package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

public class End implements CommandElement{

    @Override
    public void accept(CommandVisitor commandVisitor, Turtle turtle) {
        commandVisitor.visit(this,turtle);
    }

    @Override
    public String expressionType() {
        return "end";
    }

    @Override
    public void execute(Turtle turtle) {
        //End has no functionality to execute
    }

    @Override
    public void undo(Turtle turtle) {
        //Undo after Repeat-end is already handled by the CommandProcessor
    }

    @Override
    public void redo(Turtle turtle) {
        //Redo after Repeat-end is already handled by the CommandProcessor
    }
}