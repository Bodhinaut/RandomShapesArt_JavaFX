import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import java.util.Random;

/**
 * Kyle M. Shive

 * 
 * Holds 4 types of drawable shapes, squares, rectangles, circles, and triangles
 * Key Events
 * registed to S-square; R-rectangle, T-triangle, C-circle
 * 
 * Mouse Events, user clicks one of 4 random shapes are drawn
 * 
 * Shapes are randomly generated color, location, and size
 * 
 */
public class RandomPane extends BorderPane {
   Pane canvas = new Pane();  // instatiate canvas 
   Circle circle;
   Rectangle sqr;
   Polygon tri;
   Rectangle rect;
   Random rnd1;    
 
    public RandomPane() {
        rnd1 = new Random(); // create random variable for all the instances used later
        buildUI();
        customizeUI();
        registerEvents();
    }// end ctr
    
    public void buildUI() {
        // below builds shapes according to required parameters
        circle = new Circle   (rnd1.nextInt(590), rnd1.nextInt(590), rnd1.nextInt(150) + 5 );
        
        rect   = new Rectangle(rnd1.nextInt(590), rnd1.nextInt(590),
                               rnd1.nextInt(300) + 10, rnd1.nextInt(300) + 10);
                                
        tri    = new Polygon  (rnd1.nextInt(590), rnd1.nextInt(590), rnd1.nextInt(590),
                               rnd1.nextInt(590), rnd1.nextInt(590), rnd1.nextInt(590));
        // variable 'x' below  is created to assure consistent square width/height                   
        int x = rnd1.nextInt(300) + 10; 
        sqr    = new Rectangle(rnd1.nextInt(590), rnd1.nextInt(590), x, x);
                            
        setCenter(canvas);
    }// end build UI method 
    
    private Color randomRgb() {
       return Color.rgb(rnd1.nextInt(255), rnd1.nextInt(255), rnd1.nextInt(255) );
    }// end random color gen, made to be called to customize shape color and make a new color each call
    
    public void customizeUI() {
        // below customizes individual shape color
        tri.setFill   (randomRgb() );
        rect.setFill  (randomRgb() );
        circle.setFill(randomRgb() );
        sqr.setFill   (randomRgb() );
    }// end customizeUI method
    
    public void registerEvents() {
       // key events
       // for key events, buildUI is called, then it is customized, then the proper shape is added to canvas
        setOnKeyReleased( e -> {
            switch ( e.getCode() ) {
                case C: buildUI(); customizeUI();  canvas.getChildren().addAll(circle);  break;
                case S: buildUI(); customizeUI();  canvas.getChildren().addAll(sqr);     break;
                case R: buildUI(); customizeUI();  canvas.getChildren().addAll(rect);    break;
                case T: buildUI(); customizeUI();  canvas.getChildren().addAll(tri);     break;
            }
        });
        
       // Mouse events; random shape generate by mouse click on canvas
       setOnMouseClicked( e -> {
           switch(rnd1.nextInt(4) + 1) {
               case 1: buildUI(); customizeUI();  canvas.getChildren().addAll(circle);  break;
               case 2: buildUI(); customizeUI();  canvas.getChildren().addAll(sqr);     break;
               case 3: buildUI(); customizeUI();  canvas.getChildren().addAll(rect);    break;
               case 4: buildUI(); customizeUI();  canvas.getChildren().addAll(tri);     break;
            }
        });
           
    }// end register events 
   
}// end randomPane class