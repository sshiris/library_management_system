package com.library;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class LibraryManagementGUI {
    JFrame frame;
    JTable table;
    DefaultTableModel tableModel;
    private ArrayList<LibraryItem> libraryItems;

    public LibraryManagementGUI() {
        libraryItems = new ArrayList<>();

        frame = new JFrame("Library Management System");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel(new String[] { "ID", "Type", "Title/Issue", "Availability", "Due Date" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPanel = new JScrollPane(table);

        JButton addButton = new JButton("Add Item");
        JButton removeButton = new JButton("Remove ITem");
        JButton borrowButton = new JButton("Borrow ITem");

        addButton.addActionListener(e -> addItem());
        removeButton.addActionListener(e -> removeItem());
        borrowButton.addActionListener(e -> borrowItem());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(borrowButton);

        frame.add(scrollPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    private void addItem() {
        String[] options = { "Book", "Magazine" };
        int choice = JOptionPane.showOptionDialog(frame, "Select item type to add:", "Add item",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            String id = JOptionPane.showInputDialog(frame, "Enter Book ID: ");

            String title = JOptionPane.showInputDialog(frame, "Enter Book Title:");
            if (id != null && title != null) {
                libraryItems.add(new Book(title, Integer.parseInt(id)));
                updateTable();
            }
        } else if (choice == 1) {
            String id = JOptionPane.showInputDialog(frame, "Enter Magazine ID:");
            String issue = JOptionPane.showInputDialog(frame, "Enter Magazine issue:");
            if (id != null && issue != null) {
                libraryItems.add(new Magazine(issue, Integer.parseInt(id)));
                updateTable();
            }
        }
    }

    private void removeItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            libraryItems.remove(selectedRow);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(frame, "select an item to remove.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void borrowItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            LibraryItem item = libraryItems.get(selectedRow);
            if (item.isAvailable()) {
                item.borrowItem();
                updateTable();
            } else {
                JOptionPane.showMessageDialog(frame, "Item already borrowed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Selection an item to borrow", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (LibraryItem item : libraryItems) {
            String type = item instanceof Book ? "Book" : "Magazine";
            String detail = item instanceof Book ? ((Book) item).getTitle() : ((Magazine) item).getIssue();
            String availability = item.isAvailable() ? "Available" : "Borrowed";
            tableModel.addRow(new Object[] { item.getId(), type, detail, availability, item.dueToDate });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryManagementGUI::new);
    }
}
