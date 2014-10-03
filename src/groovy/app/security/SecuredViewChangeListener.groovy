package app.security

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener

class SecuredViewChangeListener implements ViewChangeListener {

    @Override
    boolean beforeViewChange(ViewChangeListener.ViewChangeEvent event) {
        View view = event.newView
        boolean isViewAccessible = ViewSecurity.isViewAccessible(view)
        return isViewAccessible
    }

    @Override
    void afterViewChange(ViewChangeListener.ViewChangeEvent event) {
    }
}