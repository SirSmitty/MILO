package Decorator;

import PersonManagement.UserManager;



public abstract class CustomPanel implements Panel_IF {

    protected UserManager uManager;
    protected BasePanel decoratee;

    public CustomPanel(UserManager UM, BasePanel deco) {
        this.uManager = UM;
        this.decoratee = deco;
        
    }

}
