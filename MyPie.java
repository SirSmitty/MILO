import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

class MyPie extends JComponent {
  private Slice[] slices = new Slice[3];
  private Person person;

  public MyPie(Person p) {
    person = p;
    CalorieCalculator calc = CalorieCalculator.getCalc();
    calculate(calc);
    changeSlices(calc);
  }

  public Slice[] getSlices() {
    return slices;
  }

  public void changePerson(Person p, CalorieCalculator calc) {
    person = p;
    changeSlices(calc);
  }

  public void calculate(CalorieCalculator calc) {
    calc.setPersonforCalc(person);
    calc.calculateMacros();
  }

  public void changeSlices(CalorieCalculator calc) {
    calculate(calc);
    Slice proteinSlice = new Slice(calc.getProtein(), new Color(211, 96, 90));
    Slice carbsSlice = new Slice(calc.getCarbs(), new Color(65, 68, 68));
    Slice fatsSlice = new Slice(calc.getFats(), new Color(140, 136, 97));
    slices[0] = proteinSlice;
    slices[1] = carbsSlice;
    slices[2] = fatsSlice;
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