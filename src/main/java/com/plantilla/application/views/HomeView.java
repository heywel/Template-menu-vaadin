package com.plantilla.application.views;

import com.plantilla.application.views.frameDesign.ViewFrame;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteAlias;


@Route(value = "home", layout = MainView.class)
@PageTitle("Welcome")
@CssImport("./styles/views/view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HomeView extends ViewFrame {

    private TextField name;
    private Button sayHello;

    public HomeView() {
        addClassName("view-form");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
        setViewContent(name, sayHello);
    }

}
