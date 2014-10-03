package app

import app.security.SecuredViewChangeListener
import app.security.ViewSecurity
import app.view.login.LoginView
import app.view.secured.UserDataView
import com.vaadin.annotations.PreserveOnRefresh
import com.vaadin.navigator.Navigator
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout

@PreserveOnRefresh
class MyUI extends UI {

    @Override
    protected void init(VaadinRequest r) {

        VerticalLayout layout = new VerticalLayout()
        layout.setMargin(true)

        Navigator navigator = new Navigator(this, this)

        SecuredViewChangeListener securedViewListener = new SecuredViewChangeListener()
        navigator.addViewChangeListener(securedViewListener)

        navigator.addView(LoginView.VIEW_NAME, LoginView)
        navigator.addView(UserDataView.VIEW_NAME, UserDataView)

        ViewSecurity.add(LoginView, null)
        ViewSecurity.add(UserDataView, ['USER'])

        navigator.navigateTo(LoginView.VIEW_NAME)

        setContent(layout)
    }
}
