package ru.andrinn.gwt1.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HelloWorld implements EntryPoint {
   public void onModuleLoad() {

      // Make a new list box, adding a few items to it.
      ListBox listBox1 = new ListBox();
      listBox1.addItem("First");
      listBox1.addItem("Second");
      listBox1.addItem("Third");
      listBox1.addItem("Fourth");
      listBox1.addItem("Fifth");

      // Make a new list box, adding a few items to it.
      ListBox listBox2 = new ListBox();
      listBox2.addItem("First");
      listBox2.addItem("Second");
      listBox2.addItem("Third");
      listBox2.addItem("Fourth");
      listBox2.addItem("Fifth");

      // Make enough room for all five items 
      listBox1.setVisibleItemCount(5);
	  
      //setting itemcount value to 1 turns listbox into a drop-down list.
      listBox2.setVisibleItemCount(1);

      // Add listboxes to the root panel.
      VerticalPanel panel = new VerticalPanel();
      panel.setSpacing(10);
      panel.add(listBox1);
      panel.add(listBox2);

      RootPanel.get("gwtContainer").add(panel);
   }	
}
