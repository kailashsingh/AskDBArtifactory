package com.db.askdbartifactory;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import net.miginfocom.swing.MigLayout;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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

        JPanel inputPanel = new JPanel();
        JPanel outputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setSize(new Dimension(1200,200));
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        outputPanel.setSize(new Dimension(1200,200));
        outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,100));
        JLabel groupLabel = new JLabel("Group Id:");
        JLabel artifactLabel = new JLabel("Artifact id:");
        JLabel versionLabel = new JLabel("Version:");
        JTextField groupText = new JTextField(20);
        JTextField artifactText = new JTextField(20);
        JTextField versionText = new JTextField(20);
        JButton submit = new JButton("Submit");
        inputPanel.add(groupLabel);
        inputPanel.add(groupText,"wrap");
        //mainPanel.add(new JLabel(),"span, grow");
        inputPanel.add(artifactLabel);
        inputPanel.add(artifactText,"wrap");
       // mainPanel.add(new JLabel(),"span, grow");
        inputPanel.add(versionLabel);
        inputPanel.add(versionText,"wrap");
       // mainPanel.add(new JLabel(),"span, grow");
        inputPanel.add(submit);
        component.getParent().add(inputPanel);
        component.getParent().add(outputPanel);
        JLabel outputText = new JLabel();
        outputPanel.add(outputText);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(
                "http://artifactory.intranet.db.com");
        getRequest.addHeader("accept", "application/json");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputText.setText("");
                if(validateInput(groupText,artifactText,outputText))
                    outputText.setText(groupText.getText()+" "+artifactText.getText());
                    //restCall
                else
                    outputText.setText("Please provide group id or artifact id");
            }
        });

    }

    private boolean validateInput(JTextField groupText,JTextField artifactText,JLabel outputText) {
        if(groupText.getText().isEmpty() && artifactText.getText().isEmpty())
            return false;
        return true;
    }
    private void addComponent(JPanel panel, Component component) {
        //GridBagConstraints gbc = new GridBagConstraints(x,y,width,height,1.0D,1.0D,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL,buttonInsets,0,0);
        //panel.add(component,"wrap");
    }
}
