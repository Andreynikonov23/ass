package ru.sapteh.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.daoimpl.ProductImpl;
import ru.sapteh.model.Product;

public class TableController {

    ObservableList<Product> productsFromDB = FXCollections.observableArrayList();

    @FXML
    private TableView<Product> table_view;

    @FXML
    private TableColumn<Product, Integer> column_id;

    @FXML
    private TableColumn<Product, String> column_name;

    @FXML
    private TableColumn<Product, String> column_cost;

    @FXML
    private TableColumn<Product, String> column_category;

    @FXML
    private TableColumn<Product, String> column_adress;

    @FXML
    public void initialize(){
        initData();

        table_view.setItems(productsFromDB);

        column_id.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getId()));
        column_name.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getName()));
        column_cost.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getCost()));
        column_adress.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getWarehouse().getAdress()));
        column_category.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getCategoryProduct().getName()));
    }

    private void initData() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        ProductImpl productImpl = new ProductImpl(factory);
        productsFromDB.addAll(productImpl.findByAll());
    }
}