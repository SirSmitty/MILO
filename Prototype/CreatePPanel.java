package Prototype;

public class CreatePPanel extends PPanel {

    @Override
    public CreatePPanel clone() throws CloneNotSupportedException {
        CreatePPanel copyme = (CreatePPanel) super.clone();
        return copyme;
    }

}