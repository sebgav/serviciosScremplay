package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarPage {

    public static final Target CONFIRMACION_LBL = Target.the("Texto de confirmación").located(By.xpath("//button[contains(text(),'Vaciar carrito')]"));

}
