
import java.util.Vector;

public class PCReport {
    public String displayReport(PC[] objs) {
        String line="";
        for(int i=0;i<99;i++){
            line+="-";
        }
        String title = "PCPROG REPORT";
        int num = 1;
        String res ="";
        StringBuilder report = new StringBuilder();

        report.append(line).append("\n").append(String.format("%50s\n", title)).append(line).append("\n");
        for (PC pc : objs) {
            Vector<String> vector = pc.getComps().getElements();
            res = String.format("%3d %20s %6d %15s ", num, pc.getModel(), pc.getYear(), pc.getManufacturer());
            StringBuilder components = new StringBuilder("[");
            for (int i = 0; i < vector.size(); i++) {
                if((components.length()+vector.elementAt(i).length())>51){
                    components.append("...");
                    break;
                }
                components.append(vector.elementAt(i));
                if((components.length()<52)&&(vector.size()>1)&&(i<vector.size()-1)) components.append(", ");
            }
            components.append("]");
            res +=components;
            report.append(res).append("\n");
            num++;
        }
        report.append(line);
        return report.toString();
    }

}
