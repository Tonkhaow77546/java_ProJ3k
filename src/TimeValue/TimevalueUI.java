
package TimeValue;
import TimeValue.FutureValueHead.FutureValueUI;
import TimeValue.PresentValueHead.PresentValueUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimevalueUI implements ActionListener{
    JFrame frame;
    JPanel rootPanel, topPanel, subPanel, subPanelTop;
    JButton btnChangMode;
    JLabel topLabel, modeLabel;
    FutureValueUI FN1;
    PresentValueUI FN2;
    public TimevalueUI(){
        FN1 = new FutureValueUI();
        FN2 = new PresentValueUI();
        generateUI();
    }

    public void generateUI(){
        frame = new JFrame();
        frame.setSize(1920,1080);
 
        rootPanel = new JPanel(new BorderLayout());
        
        btnChangMode = new JButton(new ImageIcon("src/Img/PV.png"));
        btnChangMode.setPreferredSize(new Dimension(150, 100));
        btnChangMode.addActionListener(this);
        topPanel = new JPanel(new GridLayout(2,1));
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topLabel = new JLabel("Time Value of Money (TVM)");
        topLabel.setFont(new Font("Courier", Font.BOLD,32));
        subPanel.add(topLabel);
        topPanel .add(subPanel);
        
        subPanelTop = new JPanel();
        modeLabel = new JLabel("Adjust the mode  :");
        modeLabel.setFont(new Font("Courier", Font.BOLD,16));
        subPanelTop.add(modeLabel);
        subPanelTop.add(btnChangMode);
        topPanel.add(subPanelTop);
        
        rootPanel.add(topPanel,BorderLayout.NORTH);
        rootPanel.add(FN2.getFrame(), BorderLayout.CENTER);
        frame.add(rootPanel, BorderLayout.CENTER);
        
        
        frame.setVisible(true);
    }
    
    public JPanel getFrame(){
        return rootPanel;
    }
    
    public static void main(String[] args) {
        new TimevalueUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnChangMode)){
            if(FN2.getFrame().isShowing()){
                btnChangMode.setIcon(new ImageIcon("src/Img/FV.png"));
                rootPanel.remove(FN2.getFrame());
                rootPanel.add(FN1.getFrame(), BorderLayout.CENTER);
            }
            else if(FN1.getFrame().isShowing()){
                btnChangMode.setIcon(new ImageIcon("src/Img/PV.png"));
                rootPanel.remove(FN1.getFrame());
                rootPanel.add(FN2.getFrame(), BorderLayout.CENTER);
            }
            rootPanel.revalidate();
            rootPanel.repaint();
        }
    }
}
