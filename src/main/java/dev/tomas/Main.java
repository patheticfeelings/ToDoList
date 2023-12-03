package dev.tomas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    private JFrame frame;
    private JTextField field;
    private DefaultListModel<String> model;
    private JList<String> list;

    public Main() {
        frame = new JFrame("Lista de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Set your preferred size
        frame.setLayout(new BorderLayout());

        model = new DefaultListModel<>();
        list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

        field = new JTextField(20);
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(this::addTask);

        JButton removeButton = new JButton("Remover");
        removeButton.addActionListener(this::removeTask);

        inputPanel.add(field);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addTask(ActionEvent e) {
        String task = field.getText().trim();
        if (!task.isEmpty()) {
            model.addElement(task);
            field.setText("");
        }
    }

    private void removeTask(ActionEvent e) {
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            model.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
