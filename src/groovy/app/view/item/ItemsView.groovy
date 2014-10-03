package app.view.item

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout

class ItemsView extends VerticalLayout implements View {

    static final String VIEW_NAME = "items"

    @Override
    void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        Label btnAddMoreItems = new Label("Item view")
        addComponent(btnAddMoreItems)

    }
}
