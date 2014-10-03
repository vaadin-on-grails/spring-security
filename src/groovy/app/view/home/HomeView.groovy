package app.view.home

import app.view.login.LoginView
import app.view.item.ItemsView
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.ui.Button
import com.vaadin.ui.VerticalLayout

import static com.vaadin.ui.UI.getCurrent

class HomeView extends VerticalLayout implements View {

    static final String VIEW_NAME = "home"

    @Override
    void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        Button btnShowAllItems = new Button("Show All Items")
        btnShowAllItems.addClickListener(new Button.ClickListener() {
            @Override
            void buttonClick(Button.ClickEvent clickEvent) {
                current.navigator.navigateTo(ItemsView.VIEW_NAME)
            }
        })
        addComponent(btnShowAllItems)

        Button btnLogin = new Button("Login")
        btnLogin.addClickListener(new Button.ClickListener() {
            @Override
            void buttonClick(Button.ClickEvent clickEvent) {
                current.navigator.navigateTo(LoginView.VIEW_NAME)
            }
        })
        addComponent(btnLogin)
    }
}
