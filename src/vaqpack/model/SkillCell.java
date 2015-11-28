package vaqpack.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;

 public class SkillCell extends ListCell<Skill> 
 {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        Button button = new Button();
        SVGPath bin = new SVGPath();
        Skill lastItem;

        public SkillCell() {
        	super();
        	bin.setContent("M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z");
        	bin.setFill(Paint.valueOf("#BDBDBD"));
        	button.setGraphic(bin);
            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() 
            		{
                @Override
                public void handle(ActionEvent event) 
                {
                System.out.println(lastItem+ " : " + event);
                System.out.println(getListView().getItems().remove(lastItem));
                }
            });
        }

        @Override
        protected void updateItem(Skill item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = item;
                label.setText(item!=null ? item.getSkill(): "<null>");
                setGraphic(hbox);
            }
        }
    }