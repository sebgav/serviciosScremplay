package com.sophossolutions.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.wong.pe/tecnologia")
public class HomePage extends PageObject {
    public static final Target TEXTBOX_ALERT = Target.the("cancel alert").locatedBy("//button[@id='onesignal-slidedown-cancel-button']");
    public static final Target FIELD_AUDIO = Target.the("select audio").locatedBy("//h4//a[@title='Audio']");
    public static final Target FIELD_AUDIFONOS = Target.the("select audifonos").locatedBy("//a[@title='Audífonos']");
    public static final Target BUTTON_VIEW_CAR = Target.the("select ver carrito").locatedBy("//div[@class='minicart minicart--floating minicart--has-items minicart--single-category']//span[contains(text(),'Ver carrito')]");



}
