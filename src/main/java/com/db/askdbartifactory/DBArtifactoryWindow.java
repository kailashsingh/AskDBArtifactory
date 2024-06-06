package com.db.askdbartifactory;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class DBArtifactoryWindow implements ToolWindowFactory {

    private static final Insets   buttonInsets    = new Insets(10, 10, 0, 10);
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        Component component = toolWindow.getComponent();
        /*JTextArea textArea = new JTextArea();
        JTextField textField = new JFormattedTextField();

        component.getParent().add(textArea);*/
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(new Dimension(1200,600));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        JLabel groupLabel = new JLabel("Group Id:");
        //groupLabel.setLocation(0,0);

        //groupLabel.setHorizontalAlignment(JLabel.LEFT);
        JLabel artifactLabel = new JLabel("Artifact Id:");
        //artifactLabel.setLocation(0,50);
        //artifactLabel.setHorizontalAlignment(JLabel.LEFT);
        JTextField groupText = new JTextField();
        //groupText.setSize(100,100);
        //groupText.setLocation(50,0);
        //groupText.setSize(100,10);
        //groupText.setHorizontalAlignment(JLabel.LEFT);
        JTextField artifactText = new JTextField();
       // artifactText.setLocation(50,50);
        //artifactText.setHorizontalAlignment(JLabel.LEFT);
        JButton submit = new JButton("Submit");
        //submit.setLocation(200,200);
        addComponent(mainPanel,groupLabel);
        addComponent(mainPanel,groupText);
        addComponent(mainPanel,artifactLabel);
        addComponent(mainPanel,artifactText);
        addComponent(mainPanel,submit);
        component.getParent().add(mainPanel);
    }

    private void addComponent(JPanel panel, Component component) {
        //GridBagConstraints gbc = new GridBagConstraints(x,y,width,height,1.0D,1.0D,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL,buttonInsets,0,0);
        panel.add(component);
    }
}
