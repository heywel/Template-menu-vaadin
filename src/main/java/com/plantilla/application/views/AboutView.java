package com.plantilla.application.views;

import com.plantilla.application.views.extraComponents.menu.components.FlexBoxLayoutMod;
import com.plantilla.application.views.extraComponents.menu.size.Horizontal;
import com.plantilla.application.views.extraComponents.menu.size.Top;
import com.plantilla.application.views.extraComponents.menu.util.css.BoxSizing;
import com.plantilla.application.views.frameDesign.ViewFrame;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class AboutView extends ViewFrame {

    public AboutView() {
        addClassName("about-view");
        createContent();
    }

    private Component createContent(){
        FlexBoxLayoutMod content = new FlexBoxLayoutMod();
        content.setBoxSizing(BoxSizing.BORDER_BOX);
        content.setHeightFull();
        content.setPadding(Horizontal.RESPONSIVE_X, Top.RESPONSIVE_X);
        return content;
    }

}
