package meu;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

import metodos.ListaCircular;

import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;



public class Tela extends JFrame {
	ListaCircular listac=new ListaCircular();
	private JTable table;
	private JTextField txt_num;
    ButtonGroup bgroup = new ButtonGroup();
    private JTextField txt_filtro;
    private JTextField txt_remove;
    
public Tela() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);
		setBounds(10, 10, 855, 434);
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 817, 60);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("O-Numeral");
		lblNewLabel.setFont(new Font("Teko SemiBold", Font.PLAIN, 20));
		lblNewLabel.setBounds(351, 20, 200, 30);
		panel.add(lblNewLabel);
		

		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 80, 817, 353);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Filtros");
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(299, 10, 54, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Digite o Numero");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(57, 21, 113, 13);
		panel_1.add(lblNewLabel_1_1);
		
		txt_num = new JTextField();
		txt_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_num.setBackground(Color.WHITE);
				
			}
		});
		txt_num.setEnabled(false);
		txt_num.setBounds(40, 44, 146, 24);
		panel_1.add(txt_num);
		txt_num.setColumns(10);
		
		JComboBox busca = new JComboBox();
		busca.setEnabled(false);
		busca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		busca.setModel(new DefaultComboBoxModel(new String[] {"Buscar", "Digito", "Posi\u00E7\u00E3o"}));
		busca.setBounds(246, 27, 146, 24);
		panel_1.add(busca);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(593, 29, 201, 58);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_registar = new JButton("Registar");
		JTextArea txt_discArea = new JTextArea();
		txt_discArea.setEnabled(false);
		txt_discArea.setEditable(false);
		txt_discArea.setBounds(0, 0, 5, 22);

		JComboBox ch_remover = new JComboBox();
		ch_remover.setEnabled(false);
		ch_remover.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ch_remover.setModel(new DefaultComboBoxModel(new String[] {"Remover", "Digito"}));
		ch_remover.setBounds(420, 27, 134, 24);
		panel_1.add(ch_remover);
		
		txt_remove = new JTextField();
		txt_remove.setEnabled(false);
		txt_remove.setBounds(420, 61, 134, 26);
		panel_1.add(txt_remove);
		txt_remove.setColumns(10);
	
		JButton btn_remover = new JButton("Remove");
		
		JCheckBox ch_registar = new JCheckBox("Registar");
		bgroup.add(ch_registar);
		ch_registar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ch_registar.isSelected()) {
					txt_num.setEnabled(true);
					btn_registar.setEnabled(true);
					busca.setEnabled(false);
					txt_filtro.setEnabled(false);
					txt_filtro.setText("");
					busca.setSelectedIndex(0);
					btn_remover.setEnabled(false);
					txt_remove.setEnabled(false);
					ch_remover.setEnabled(false);
					txt_remove.setText("");
					
				}else {
					txt_num.setEnabled(false);
				}
				
			}
		});

		ch_registar.setBounds(0, 6, 93, 21);
		panel_2.add(ch_registar);
		
		JCheckBox ch_busca = new JCheckBox("Busca");
		bgroup.add(ch_busca);
		ch_busca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ch_busca.isSelected()) {
					busca.setEnabled(true);
					txt_num.setEnabled(false);
					txt_filtro.setEnabled(true);
					btn_registar.setEnabled(false);
					txt_remove.setEnabled(false);
					ch_remover.setEnabled(false);
					txt_num.setText("");
					btn_remover.setEnabled(false);
					txt_remove.setText("");
				}else {
					busca.setEnabled(false);
					txt_filtro.setEnabled(false);
				}
			}
		});
		
		ch_busca.setBounds(95, 6, 93, 21);
		panel_2.add(ch_busca);
		
		JCheckBox ch_remove = new JCheckBox("Remove");
		bgroup.add(ch_remove);
		ch_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ch_remove.isSelected()  ) {
					btn_remover.setEnabled(true);
					txt_remove.setEnabled(true);
					ch_remover.setEnabled(true);
					txt_num.setEnabled(false);
					busca.setEnabled(false);
					btn_registar.setEnabled(false);
					txt_num.setText("");
					txt_filtro.setText("");
					txt_filtro.setEnabled(false);
					busca.setSelectedIndex(0);
					
				}else {
					txt_remove.setEnabled(false);
					ch_remover.setEnabled(false);
					btn_remover.setEnabled(false);
					txt_remove.setText("");
				}
			}
		});
		ch_remove.setBounds(95, 31, 93, 21);
		panel_2.add(ch_remove);
	
		JScrollPane scroll = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 123, 817, 130);
		
		JCheckBox ch_apagar = new JCheckBox("Apagar");
		ch_apagar.setBounds(531, 276, 97, 23);
		panel_1.add(ch_apagar);
		
		
		JButton varImprimir = new JButton("Imprimir");
		varImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null,listac.primeiro);
//				
				if(listac.primeiro!=null) {
					listac.toString();
				
//				Registar
				if(txt_num.isEnabled() || busca.isEnabled() ) {
					if(ch_registar.isSelected()) {
						for(int i=0;i<listac.toString().length();i++) {
							if(Character.isDigit(listac.toString().charAt(i))!=true) {
						
							}else {
								txt_discArea.setText(listac.toString());
								break;
							}
						}
						
								
						}
						
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Lista Vazia, Registe os digitos primeiro!");
				}
			//Busca
					if(ch_busca.isSelected()) {
						
					//Digito
						
						txt_filtro.setEnabled(true);
						if(busca.getSelectedIndex()==0 || txt_filtro.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha os Campos!");
						}else if(busca.getSelectedIndex()==1) {
							for(int i=0;i<txt_filtro.getText().length();i++) {
								if(Character.isDigit(txt_filtro.getText().charAt(i))!=true) {
									JOptionPane.showMessageDialog(null, "So são permitidos digitos!");
									txt_num.setText("");
									break;
								}
							}
							int num=Integer.parseInt(txt_filtro.getText());
							
							if(listac.busca(num)==null || listac.primeiro==null) {
								 JOptionPane.showMessageDialog(null, "Busca Falhou,Valor não existe!");
							    	
							}else {
								JOptionPane.showMessageDialog(null, "Valor encontrado!");
								txt_discArea.setText(listac.busca(num).obterAnterior()+"=>"+listac.busca(num)+"=>"+listac.busca(num).obterProximo());
							}
							}else if(busca.getSelectedIndex()==2 || !txt_filtro.getText().isBlank()) {
							
								for(int i=0;i<txt_filtro.getText().length();i++) {
									if(Character.isDigit(txt_filtro.getText().charAt(i))!=true) {
										JOptionPane.showMessageDialog(null, "So são permitidos digitos!");
										txt_num.setText("");
										break;
									}
								}
								int num=Integer.parseInt(txt_filtro.getText());
								
								if(listac.indiceActual(num)==null) {
									 JOptionPane.showMessageDialog(null, "Busca Falhou,Nenhum valor no indice indicado!");
								    	
								}else {
									JOptionPane.showMessageDialog(null, "Valor no indice encontrado! ");
									txt_discArea.setText(listac.busca((Integer) listac.indiceActual(num).obterValor()).obterAnterior()+"=>"+listac.busca((Integer) listac.indiceActual(num).obterValor())+"=>"+listac.busca((Integer) listac.indiceActual(num).obterValor()).obterProximo());
									
								}
								
							}
					}
//						Indice

					//Remover
					if(ch_remove.isSelected()) {
					
							if(listac.primeiro!=null) {
								txt_discArea.setText(listac.toString());
							}else {
								
							}
							
						
							
					}

					
				
//				Busca Digito
			}
			
		});
		
	
		
		varImprimir.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		varImprimir.setBounds(328, 276, 85, 21);
		panel_1.add(varImprimir);
		scroll.setViewportView(txt_discArea);
		panel_1.add(scroll);
		
		
		btn_registar.setEnabled(false);
		btn_registar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
//				Verifica se é digito
//				Declaracao de controladores
				String palavra=txt_num.getText();
				String nums = "";
//				Verifica se campo foi compreenchido
				if(palavra.isBlank()) {
					txt_num.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Preencha o Campo!");
					
				}else {
				
				int num = 0;
				for(int i=0;i<palavra.length();i++) {
					if(Character.isDigit(palavra.charAt(i))!=true) {
						JOptionPane.showMessageDialog(null, "So são permitidos digitos!");
						txt_num.setText("");
						break;
					}else {
						nums=nums+palavra.charAt(i);
//						Conversão da Palavra numero para Numero
						 num=Integer.parseInt(nums.trim());
						
					}
				}
				listac.adiciona(num);
				txt_num.setText("");
				txt_discArea.setText(listac.toString());
			}
			}
		});
		btn_registar.setBounds(63, 78, 85, 21);
		panel_1.add(btn_registar);
		
		txt_filtro = new JTextField();
		txt_filtro.setEnabled(false);
		txt_filtro.setBounds(242, 61, 150, 26);
		panel_1.add(txt_filtro);
		txt_filtro.setColumns(10);
		
		JButton btn_limpar = new JButton("Limpar");
		btn_limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_discArea.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Campo já está Limpo!");
				}else {
					txt_discArea.setText("");
				}
				if(ch_apagar.isSelected()) {
					if(listac.primeiro!=null) {
						listac.removeTudo();							
						txt_discArea.setText("");
						JOptionPane.showMessageDialog(null, "Lista Esvaziada!");
					}
				}
				
			}
		});
		btn_limpar.setBounds(440, 277, 85, 21);
		panel_1.add(btn_limpar);
		
		
		btn_remover.setEnabled(false);
		btn_remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txt_remove.getText().isBlank() || ch_remover.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					
				}else {
//					int p=listac.remove(Integer.parseInt(txt_remove.getText()));
			if(listac.primeiro!=null) {
				
				
				if(listac.primeiro.obterProximo().obterProximo()==listac.primeiro.obterAnterior()) {
					listac.remove(Integer.parseInt(txt_remove.getText()));
					listac.primeiro=null;					
					listac.numNo=0;
					txt_remove.setText("");
					txt_discArea.setText("");
				}else {
					listac.remove(Integer.parseInt(txt_remove.getText()));
					txt_remove.setText("");
					txt_discArea.setText(listac.toString());
				}
				
					
					
			}else {
				JOptionPane.showMessageDialog(null, "Lista Vasia, Registe os digitos primeiro!");
				txt_discArea.setText("");
			}
			}
			}
		});
		btn_remover.setBounds(440, 92, 85, 21);
		panel_1.add(btn_remover);
		
		
	
		
		setVisible(true);
	}
}
