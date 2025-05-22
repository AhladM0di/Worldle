package project;
import javax.swing.SwingUtilities;
public class ProjectRunner
{
    public static void main(String[] args)
    {
        
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.show();
        });
    }
}
