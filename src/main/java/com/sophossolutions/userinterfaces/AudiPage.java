package com.sophossolutions.userinterfaces;

import com.sophossolutions.tasks.Add;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class AudiPage {

      public static final Target BUTTON_AGREGAR = Target.the("agregar articulo").locatedBy("//div[@data-name="+Add.getAudi()+"]//span[@class='product-add-to-cart__text']");
      public static final Target ITEMHUAWEI = Target.the("item tres").located(By.xpath("//a[@title='Huawei FreeBuds 3i Negro']"));

}
