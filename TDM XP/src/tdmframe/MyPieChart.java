/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdmframe;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
 
public class MyPieChart{
   
   private static JScrollPane holder;
   private static String title;
   MyPieChart( JScrollPane aPane, String aName ){
       holder = aPane;
       title = aName;
       String dummy[] = { "run", "fun" };
       main( dummy );
   }
   private static void initAndShowGUI() {
        final JFXPanel fxPanel = new JFXPanel();
        holder.getViewport().add(fxPanel);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            initFX(fxPanel);
            }
       });
    }
    
     private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
    private static Scene createScene() {
        Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root);
        root.getChildren().add(createChart());        
        return (scene);
    }
    protected static PieChart createChart() {
        final PieChart pc = new PieChart(FXCollections.observableArrayList(
            new PieChart.Data("Sun", 20),
            new PieChart.Data("IBM", 12),
            new PieChart.Data("HP", 25),
            new PieChart.Data("Dell", 22),
            new PieChart.Data("Apple", 30)
        ));
        // setup chart
        pc.setId("BasicPie");
        pc.setTitle(title);
        return pc;
    }
   /**
     * The main() method is ignored in correctly deployed JavaFX 
     * application. main() serves only as fallback in case the 
     * application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support. NetBeans ignores main().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            initAndShowGUI();
            }
        });
    }
}
