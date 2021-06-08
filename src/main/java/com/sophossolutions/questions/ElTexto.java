package com.sophossolutions.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static com.sophossolutions.userinterfaces.CarPage.*;
public class ElTexto {


	public static Question<String> deConfirmacion() {
		return actor -> Text.of(CONFIRMACION_LBL).viewedBy(actor).asString();
	}


}