
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class register {

    public static instructions execute = new instructions();

    public static final String filePath = "D:\\Java\\CompanyAssignments\\registerData.txt";

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

            execute.record = readFile();

            System.out.println("Enter MV to make new register");
            System.out.println("Enter ADD to add two values");
            System.out.println("Enter SHOW to show the register value");
            System.out.println("Enter exit to exit the program");
            
                while(s.hasNextLine())
                {
                    String line = s.nextLine();
                    if (line.equalsIgnoreCase("exit")) {
                        break;
                    }
                    execute.executeInstruction(line);
                    updateFile(execute.record);
                };
            
        s.close();
    }

    public static HashMap<String, Integer> readFile() throws IOException
    {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\CompanyAssignments\\registerData.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                int value = Integer.parseInt(parts[1]);
                if(!map.containsKey(key))
                    map.put(key, value);
            }
        }
        reader.close();
        return map;
    }

    private static void updateFile(HashMap<String, Integer> record) throws IOException
    {
        try {
            FileWriter writer = new FileWriter("D:\\Java\\CompanyAssignments\\registerData.txt");
            for (String key : record.keySet()){
               writer.append(key + " " + record.get(key) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    
}
