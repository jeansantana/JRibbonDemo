package jRibbon.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.flamingo.common.JCommandButton;
import org.jvnet.flamingo.common.icon.ImageWrapperResizableIcon;
import org.jvnet.flamingo.common.icon.ResizableIcon;
import org.jvnet.flamingo.ribbon.JRibbonBand;
import org.jvnet.flamingo.ribbon.JRibbonFrame;
import org.jvnet.flamingo.ribbon.RibbonApplicationMenu;
import org.jvnet.flamingo.ribbon.RibbonElementPriority;
import org.jvnet.flamingo.ribbon.RibbonTask;
import org.jvnet.flamingo.ribbon.resize.CoreRibbonResizePolicies;
import org.jvnet.flamingo.ribbon.resize.IconRibbonBandResizePolicy;

public class MainPane extends JRibbonFrame {

	public static ResizableIcon getResizableIconFromResource(String resource) {
		return ImageWrapperResizableIcon.getIcon(MainPane.class
				.getClassLoader().getResource(resource), new Dimension(48, 48));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainPane pane = new MainPane();
				pane.setTitle("Controle de Estoque");
				// maximiza a tela
				pane.setSize(800, 600);
				pane.setExtendedState(JFrame.MAXIMIZED_BOTH);
				pane.setDefaultCloseOperation(EXIT_ON_CLOSE);
				// pane.pack();
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pane.setVisible(true);

				JRibbonBand band1 = new JRibbonBand("Gerenciar Estoque", null);
				JRibbonBand band2 = new JRibbonBand("Gerenciar Cliente", null);
				// add buttons
				JCommandButton btnCadastroProd = new JCommandButton(
						"Cadastrar Produto",
						getResizableIconFromResource("./resource/cadastrar1.png"));
				JCommandButton btn2 = new JCommandButton(
						"Cadastrar Produto",
						getResizableIconFromResource("./resource/cadastrar1.png"));
				JCommandButton btn3 = new JCommandButton(
						"Cadastrar Produto",
						getResizableIconFromResource("./resource/cadastrar1.png"));
				JCommandButton btn4 = new JCommandButton(
						"Cadastrar Produto",
						getResizableIconFromResource("./resource/cadastrar1.png"));

				band1.addCommandButton(btnCadastroProd, RibbonElementPriority.TOP);
				band1.addCommandButton(btn2, RibbonElementPriority.MEDIUM);
				band1.addCommandButton(btn3, RibbonElementPriority.MEDIUM);
				band1.addCommandButton(btn4, RibbonElementPriority.MEDIUM);

				// action do botao btn1
				btnCadastroProd.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// action here

					}
				});

				band1.setResizePolicies((List) Arrays.asList(
						new CoreRibbonResizePolicies.None(band1
								.getControlPanel()),
						new IconRibbonBandResizePolicy(band1.getControlPanel())));

				// band1.setResizePolicies((List) Arrays.asList(new
				// IconRibbonBandResizePolicy(band1.getControlPanel())));
				band2.setResizePolicies((List) Arrays
						.asList(new IconRibbonBandResizePolicy(band2
								.getControlPanel())));

				RibbonTask task1 = new RibbonTask("Ger. Estoque", band1);
				RibbonTask task2 = new RibbonTask("Ger. Clientes", band2);

				pane.getRibbon().addTask(task1);
				pane.getRibbon().addTask(task2);
				pane.getRibbon().setApplicationMenu(new RibbonApplicationMenu());
			}
		});
	}
}
