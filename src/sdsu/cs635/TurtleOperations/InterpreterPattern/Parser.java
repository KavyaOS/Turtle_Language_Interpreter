package sdsu.cs635.TurtleOperations.InterpreterPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.*;
import sdsu.cs635.TurtleOperations.Point;

import java.util.Map;
import java.util.Objects;

public class Parser{
    private String expression;

    public Parser()
    {
        expression=null;
    }

    public void setExpression(String expression)
    {
        this.expression=expression;
    }

    public CommandElement parseExpression(Map<Character, Object> variables) {
        CommandElement command;

        if (expression.contains("=")) {
            if(Objects.equals(expression.split(" ")[0].charAt(1), 'P') && expression.contains(","))
            {
                Point point = new Point((Double.parseDouble(expression.split(" ")[2])),(Double.parseDouble(expression.split(" ")[4])));
                variables.put(expression.split(" ")[0].charAt(2),point);
                command = new Assignment(expression.split(" ")[0].charAt(2), point);
            }
            else if(expression.contains("bearingTo"))
            {
                command=new BearingTo(expression.split(" ")[0].charAt(1),(Point) variables.get(expression.split(" ")[3].charAt(1)));
            }
            else if(expression.contains("distanceTo"))
            {
                command=new DistanceTo((Point) variables.get(expression.split(" ")[3].charAt(1)),expression.split(" ")[0].charAt(1));
            }
            else {
                variables.put(expression.split(" ")[0].charAt(1), Double.parseDouble(expression.split(" ")[2]));
                command = new Assignment(expression.split(" ")[0].charAt(1), Double.parseDouble(expression.split(" ")[2]));
            }
        }

        else if (expression.contains("repeat"))
        {
            double count;
            if (expression.contains("#"))
                count = (double) variables.get((expression.split(" ")[1]).charAt(1));
            else
                count=Double.parseDouble(expression.split(" ")[1]);
            command=new Repeat((int)count);
        }

        else if (expression.contains("move")) {
            double distance;
            if (expression.contains("#"))
                distance = (double)variables.get((expression.split(" ")[1]).charAt(1));
            else
                distance = Double.parseDouble(expression.split(" ")[1]);
            command=new Move(distance);
        }

        else if(expression.contains("turn"))
        {
            double degrees;
            if(expression.contains("#"))
                degrees = (double) variables.get((expression.split(" ")[1]).charAt(1));
            else
                degrees = Double.parseDouble(expression.split(" ")[1]);
            command=new Turn(degrees);
        }

        else
        {
            //if expression contains end command
            command=new End();
        }
        return command;
    }
}