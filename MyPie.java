import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

class MyPie extends JComponent {
  private Slice[] slices = new Slice[3];;

  MyPie(Person person) {
    Slice proteinSlice = new Slice(person.getProtein(), Color.BLUE);
    Slice carbsSlice = new Slice(person.getCarbs(), Color.RED);
    Slice fatsSlice = new Slice(person.getFats(), Color.GREEN);
    slices[0] = proteinSlice;
    slices[1] = carbsSlice;
    slices[2] = fatsSlice;
  }

  public Slice[] getSlices() {
    return slices;
  }

  void drawPie(Graphics2D g, Rectangle area) {
    double total = 0.0D;
    for (int i = 0; i < slices.length; i++) {
      total += slices[i].value;
    }

    double curValue = 0.0D;
    int startAngle = 0;
    for (int i = 0; i < slices.length; i++) {
      startAngle = (int) (curValue * 360 / total);
      int arcAngle = (int) (slices[i].value * 360 / total);

      g.setColor(slices[i].color);
      g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
      curValue += slices[i].value;
    }

  }
}