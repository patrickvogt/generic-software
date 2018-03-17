package tm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TM
{
    private class To
    {
        private String state;
        private String write;
        private String shift;
        
        public To(String state, String write, String shift)
        {
            this.state = state;
            this.write = write;
            this.shift = shift;
        }
        
        public String state()
        {
            return this.state;
        }
        
        public String write()
        {
            return this.write;
        }
        
        public String shift()
        {
            return this.shift;
        }
    }
    
    private Map<String, List<To>> transition = new TreeMap<String, List<To>>();
    private String currentState;
    private int head = 0;
    private List<String> tape = new ArrayList<String>();
    private List<String> finalStates = new ArrayList<String>();
    
    public TM()
    {
        this.currentState = "s1";
        String tape_instance = "00001";
        for(int i=0; i<tape_instance.length(); i++)
        {
            tape.add(tape_instance.charAt(i)+"");
        }
        this.finalStates.add("s2");
        
        List<To> list1 = new ArrayList<To>();
        list1.add(new To("s2", "1", "nop"));
        
        List<To> list2 = new ArrayList<To>();
        list2.add(new To("s1", "\u25a1", "right"));
        
        this.transition.put(TM.prepareTransition("s1", "1"), list1);
        this.transition.put(TM.prepareTransition("s1", "0"), list2);
    }
    
    public void doStep()
    {
        //get the next configuration
        String state = this.currentState;
        String read = this.tape.get(this.head);
        
        String currConf = TM.prepareTransition(state, read);
        
        To nextConf = this.transition.get(currConf).get(0);
        
        this.currentState = nextConf.state();
        this.tape.set(this.head, nextConf.write());
        if(nextConf.shift().equals("left"))
        {
            this.head = this.head-1;
        }
        else if(nextConf.shift().equals("right"))
        {
            this.head = this.head+1;
        }
    }
    
    public String toString()
    {
        String result = "currentState: "+this.currentState+", tape_instance: ";
        for(int i=0; i<this.tape.size(); i++)
        {
            result = result + "|" + (i==this.head ? ">" : " ") + this.tape.get(i)+" ";
        }
        
        return result + "|";
    }
    
    public boolean isAccepting()
    {
        return this.finalStates.contains(this.currentState);
    }
    
    private static String prepareTransition(String state, String read)
    {
        return "state: "+state+", read:"+read;
    }
    
    public static void main(String[] _)
    {
        TM tm = new TM();
        
        System.out.println(tm.toString());
        
        do
        {
            tm.doStep();
            System.out.println(tm.toString());
        }
        while(!tm.isAccepting());
        
    }
}
