package fr.polytech.si3.ihm.controllers;

import fr.polytech.si3.ihm.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static fr.polytech.si3.ihm.model.Category.NEUROLOGIC;
import static fr.polytech.si3.ihm.model.Category.NO_CATEGORY;
import static fr.polytech.si3.ihm.model.Category.SCIENTIFIC;

/**
 * Created by user on 12/03/2017.
 */
public class SearchController  implements Controller{

    @FXML
    public CheckBox dvdCheckBox;
    @FXML
    public CheckBox stageCheckBox;
    @FXML
    public CheckBox cdCheckBox;
    @FXML
    public CheckBox bookCheckBox;
    @FXML
    public TextField minimumPrice;
    @FXML
    public TextField maximumPrice;
    @FXML
    public TextField textField;
    @FXML
    public CheckBox scientificCheckBox;
    @FXML
    public CheckBox neurologicCheckBox;
    @FXML
    public CheckBox othersCategoryCheckBox;

    private MainController mainController;
    private ProductsPageController productPageController;
    private List<CheckBox> typeCheckBoxes;
    private List<CheckBox> categoryCheckBoxes;
    private ProductDatabase database;

    @Override
    public void start(MainController mainController) {
        this.mainController = mainController;
    }

    public void start(MainController mainController, ProductsPageController productsPageViewController, Optional<Type> optType, Optional<Category> category) {
        this.mainController = mainController;
        this.productPageController = productsPageViewController;
        this.database = mainController.getProductDatabase();

        //adding checkboxes in a array
        this.typeCheckBoxes = new ArrayList<>();
        this.typeCheckBoxes.add(dvdCheckBox);
        this.typeCheckBoxes.add(cdCheckBox);
        this.typeCheckBoxes.add(bookCheckBox);
        this.typeCheckBoxes.add(stageCheckBox);

        this.categoryCheckBoxes = new ArrayList<>();
        this.categoryCheckBoxes.add(scientificCheckBox);
        this.categoryCheckBoxes.add(neurologicCheckBox);
        search(optType,category);
    }


    public void onSearchButtonClicked(MouseEvent mouseEvent) {
        search();
    }

    private void search() {
        //prices
        int min = Integer.parseInt(minimumPrice.getCharacters().toString());
        int max = Integer.parseInt(maximumPrice.getCharacters().toString());
        //name
        String searchName = textField.getCharacters().toString();
        Optional<String> name = Optional.empty();
        if(!searchName.equals("")){
            name = Optional.of(searchName);
        }
        //selecting List of products in database
        List<Product> data = new ArrayList<>();
        if(dvdCheckBox.isSelected())data.addAll(database.getDvds());
        if(cdCheckBox.isSelected())data.addAll(database.getCds());
        if(bookCheckBox.isSelected())data.addAll(database.getBooks());
        if(stageCheckBox.isSelected())data.addAll(database.getStages());

        if(!neurologicCheckBox.isSelected())data = database.removeItemsWithCategory(data,NEUROLOGIC);
        if(!scientificCheckBox.isSelected())data = database.removeItemsWithCategory(data,SCIENTIFIC);
        if(!othersCategoryCheckBox.isSelected())data = database.removeItemsWithCategory(data,NO_CATEGORY);

        data = database.getItemsBetween(data,min,max);
        if(name.isPresent()) data = database.getItemsByName(data,name.get());


        productPageController.display(data);
    }

    private void search(Optional<Type> optType, Optional<Category> category) {
        changeTypesCheckbox(optType);
        changeCategoryCheckbox(category);
        search();
    }

    private void changeCategoryCheckbox(Optional<Category> category) {
        if(category.isPresent()) {
            switch (category.get()) {
                case NEUROLOGIC:
                    neurologicCheckBox.setSelected(true);
                    break;
                case SCIENTIFIC:
                    scientificCheckBox.setSelected(true);
                    break;
                case NO_CATEGORY :
                    othersCategoryCheckBox.setSelected(true);
                    break;
            }
        }else{
            othersCategoryCheckBox.setSelected(true);
            categoryCheckBoxes.forEach(checkBox -> checkBox.setSelected(true));
        }
    }

    private void changeTypesCheckbox(Optional<Type> optType) {
        if(optType.isPresent()){
            switch (optType.get()){
                case DVD: dvdCheckBox.setSelected(true); break;
                case CD: cdCheckBox.setSelected(true); break;
                case BOOK: bookCheckBox.setSelected(true); break;
                case STAGE: stageCheckBox.setSelected(true); break;
                default: break;
            }
        }else{
            typeCheckBoxes.forEach(checkBox -> checkBox.setSelected(true));
        }
    }


}
