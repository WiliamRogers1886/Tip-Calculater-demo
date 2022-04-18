package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;
/**
 * Controller for the tip calculator
 *
 * @author William Rogers
 */
public class HelloController {
    @FXML
    private Label displayPeople;
    @FXML
    private Slider peopleSlider;
    @FXML
    private TextField baseBill;
    @FXML
    private Label showTip;
    @FXML
    private Label finalBill;
    private double tip = 15;
    private int people = 1;

    /** Update bill total when base bill amount is changed */
    @FXML
    protected void BaseBillUpdate(){
        UpdateFinalBill();
    }
    /** update tip and bill total when tip button is hit
     * Perhaps this could be merged into one function for all buttons, but im not sure how to know which button called
     * */
    @FXML
    protected void ButtonTip0() {
        tip = 0;
        UpdateTip();
        UpdateFinalBill();
    }
    /** update tip and bill total when tip button is hit */
    @FXML
    protected void ButtonTip15() {
        tip = 15;
        UpdateTip();
        UpdateFinalBill();
    }
    /** update tip and bill total when tip button is hit */
    @FXML
    protected void ButtonTip20() {
        tip = 20;
        UpdateTip();
        UpdateFinalBill();
    }
    /** update tip and bill total when tip button is hit */
    @FXML
    protected void ButtonTip25() {
        tip = 25;
        UpdateTip();
        UpdateFinalBill();
    }
    /** update  bill total and person count when slider is changed */
    @FXML
    protected void PeopleSliderDragged() {
        people = (int) peopleSlider.getValue();
        displayPeople.setText(String.valueOf(people));
        UpdateFinalBill();
    }
    /** fucntion that can be called to update the displayed tip
     * is a separate function to make new features more simple to implement while not breaking old ones
     * */
    private void UpdateTip(){
        showTip.setText((int) tip + "%");
    }
    /** Updates the final bill total */
    public void UpdateFinalBill(){
        if (baseBill.getText().equals(""))  {
            finalBill.setText("$" + 0);
            return;
        }
        //try-catch to avoid char inputs, should be done another way probably
        try {
            double bill = Double.parseDouble(baseBill.getText());
            bill = bill * (1+tip/100);
            bill =  bill/people;
            finalBill.setText("$"+ ((double) Math.round(bill * 100)) / 100);
        }
        catch(Exception e) {
            finalBill.setText("$" + 0);
        }

    }
}
