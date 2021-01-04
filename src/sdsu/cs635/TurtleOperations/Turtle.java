package sdsu.cs635.TurtleOperations;

import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.CommandElement;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.CommandProcessor;
import sdsu.cs635.TurtleOperations.InterpreterPattern.Parser;
import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Turtle {
    private Double direction;
    private Point location;
    private Map<Character, Object> variables;
    ArrayList<CommandElement> commands;

    public Turtle(String fileName)
    {
        //Initialize turtle position to middle of the screen headed horizontally right (zero degrees)
        setLocation(new Point());
        setDirection(0);
        variables=new HashMap<>();
        commands=new ArrayList<>();
        File directory= new File(".");
        try {
            File file = new File(directory.getCanonicalPath() + File.separator
                    + fileName);
            parseFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        Parser parser = new Parser();
        while ((line = bufferedReader.readLine()) != null) {
            parser.setExpression(line);
            CommandElement command =parser.parseExpression(this.variables);
            if(command.expressionType().equals("bearingTo")||command.expressionType().equals("distanceTo"))
                command.execute(this);
            else
                this.commands.add(command);
        }
        bufferedReader.close();
    }

    public void setLocation(Point location)
    {
        this.location=location;
    }

    public void setDirection(double direction)
    {
        this.direction=direction;
    }

    public void addVariable(Character key, Object value)
    {
        this.variables.put(key,value);
    }

    public void removeVariable(Character key)
    {
        this.variables.remove(key);
    }

    public Map<Character, Object> getVariables()
    {
        return variables;
    }

    public void move(double distance) {
        double x=this.location.getX();
        double y=this.location.getY();
        double degree = direction();
        double radians = Math.toRadians(degree);
        double deltaX = Math.cos(radians)*distance;
        double deltaY = Math.sin(radians)*distance;
        Point destination=new Point();
        destination.setX(Math.round(x+deltaX));
        destination.setY(Math.round(y+deltaY));
        setLocation(destination);
    }

    public void turn(double degrees) {
        double currentDirection= direction();
        setDirection(currentDirection+degrees);
    }

    public double direction() {
        return direction;
    }

    public Point location() {
        return location;
    }

    public double distanceTo(Point point)
    {
        return this.location.distanceTo(point);
    }

    public double bearingTo(Point point)
    {
        return this.location.bearingTo(point);
    }

    public void initiateCommandProcessor(CommandVisitor commandVisitor)
    {
        CommandProcessor commandProcessor=new CommandProcessor(commands);
        commandProcessor.processCommands(commandVisitor,this);
    }
}