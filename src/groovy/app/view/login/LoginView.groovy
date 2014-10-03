package app.view.login

import app.security.Auth
import app.view.home.HomeView
import app.view.item.ItemsView
import app.view.secured.UserDataView
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.ui.Button
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

import static com.vaadin.ui.UI.getCurrent

class LoginView extends VerticalLayout implements View {

    static final String VIEW_NAME = "login"

    @Override
    void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        TextField txnUsername = new TextField("Username")
        TextField txnPassword = new TextField("Password")
        Button btnLogin = new Button("Login")

        addComponent(txnUsername)
        addComponent(txnPassword)
        addComponent(btnLogin)

        btnLogin.addClickListener(new Button.ClickListener() {

            @Override
            void buttonClick(Button.ClickEvent clickEvent) {
                String username = txnUsername.value
                String password = txnPassword.value

                try {
                    Authentication auth = Auth.login(username, password)

                    List<GrantedAuthority> authorities = auth.authorities
                    // TODO: do whatever you need to do base on roles (ADMIN, USER, ...)
                    if ('ADMIN' in authorities*.authority) {
                        current.navigator.navigateTo(UserDataView.VIEW_NAME) // TODO: missing!!! in the book
                    } else {
                        current.navigator.navigateTo(ItemsView.VIEW_NAME) // TODO: missing!!! in the book
                    }

                } catch (BadCredentialsException e) {
                    // TODO: handle error flow
                    current.navigator.navigateTo(HomeView.VIEW_NAME) // TODO: missing!!! in the book
                }
            }
        })
    }
}