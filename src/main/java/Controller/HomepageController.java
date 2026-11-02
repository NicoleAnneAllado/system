package Controller;

import DAo.DAO;
import SystemUI.HomepageModel;
import SystemUI.HomepageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HomepageController {
    HomepageView hv;

    public HomepageController(HomepageView temp) {
        hv = temp;
        hv.allListeners(new AllActions());
        loadTable();   // show existing data when the window opens
    }

    class AllActions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String item_name = hv.in1.getText();
                int stock = Integer.parseInt(hv.stock1.getText());
                int capital = Integer.parseInt(hv.capital1.getText());
                int retail = Integer.parseInt(hv.retail1.getText());

                HomepageModel hm = new HomepageModel();
                hm.setItem_name(item_name);
                hm.setStock(stock);
                hm.setCapital(capital);
                hm.setRetail(retail);

                DAO.save(hm);
                loadTable();  
                clearFields();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(hv, "Stock, capital and retail must be numbers.");
            }
        }
    }

    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) hv.getTable().getModel();
        model.setRowCount(0);   // clear old rows

        List<HomepageModel> items = DAO.getAll();
        for (HomepageModel hm : items) {
            model.addRow(new Object[]{
                hm.getItem_name(),
                hm.getStock(),
                hm.getCapital(),
                hm.getRetail()
            });
        }
    }

    private void clearFields() {
        hv.in1.setText("");
        hv.stock1.setText("");
        hv.capital1.setText("");
        hv.retail1.setText("");
    }
}