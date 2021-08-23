package meu;

public class Modelo {

		public Modelo() {
			try {
				for (javax.swing.UIManager.LookAndFeelInfo info:javax.swing.UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	

}
