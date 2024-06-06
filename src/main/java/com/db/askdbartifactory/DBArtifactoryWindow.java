package com.db.askdbartifactory;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JLabel artifactLabel = new JLabel("Artifact Id:");
        JLabel versionLabel = new JLabel("Version:");
        JTextField groupText = new JTextField();
        JTextField artifactText = new JTextField();
        JTextField versionText = new JTextField();
        JButton submit = new JButton("Submit");
        addComponent(mainPanel,groupLabel);
        addComponent(mainPanel,groupText);
        addComponent(mainPanel,artifactLabel);
        addComponent(mainPanel,artifactText);
        addComponent(mainPanel,versionLabel);
        addComponent(mainPanel,versionText);
        addComponent(mainPanel,submit);
        component.getParent().add(mainPanel);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Make arti call");
            }
        });
    }

    private void addComponent(JPanel panel, Component component) {
        //GridBagConstraints gbc = new GridBagConstraints(x,y,width,height,1.0D,1.0D,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL,buttonInsets,0,0);
        panel.add(component);
    }
}
