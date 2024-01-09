import java.io.IOException;
import java.util.HashMap;

public class instructions {
    HashMap<String, Integer> record = new HashMap<>();

    public void printreg()
    {
        System.out.println(record);
    }

    public void executeInstruction(String line) throws IOException
    {
        String parts[] = line.split(" |\\,");

        if(parts[0].equals("MV"))
        {
            moveReg(parts);
        }
        else if(parts[0].equals("ADD"))
        {
            addReg(parts);
        }
        else if(parts[0].equals("SHOW"))
        {
            showReg(parts);
        }
        
    }
    
    private void addReg(String [] line)
    {
        
        String reg = line[1];
        int value;
        if(Character.isDigit(line[2].charAt(0)))
        {
            value = Integer.parseInt(line[2]);
        }
        else
            value = record.get(line[2]);

        record.put(reg, record.get(reg) + value);
    }

    private void showReg(String [] line)
    {
        System.out.println(record.get(line[1]));
    }

    private void moveReg(String [] line)
    {   
        if(record.containsKey(line[1]))
            System.out.println("Register already exits");
        else
            record.put(line[1], Integer.parseInt(line[2].substring(1)));
    }

}
