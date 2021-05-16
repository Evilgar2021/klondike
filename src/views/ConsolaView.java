 package views;
 
 import controllers.ActionController;
 import controllers.MenuController;
 import controllers.MovimientoDeBarajaADescarte;
 import controllers.MovimientoDeDescarteAEscalera;
 import controllers.MovimientoDeEscaleraAEscalera;
 import controllers.MovimientoDeEscaleraAFundacion;
 import controllers.MovimientoDeFundacionAEscalera;
 import controllers.MovimientoDescarteABaraja;
 
 public class ConsolaView implements View
 {
   private JuegoView juegoView;
   
   public ConsolaView()
   {
     juegoView = new JuegoView();
   }
   
   public void interact(ActionController controller)
   {
     assert (controller != null);
     controller.accept(this);
   }
   
   public int interactWithMenu(MenuController menuController)
   {
     assert (menuController != null);
     return menuController.accept(this);
   }
   
   public int visitMenu(MenuController menuController)
   {
     return juegoView.interactWithMenu(menuController);
   }
   
   public void visitMovimientoDeBarajaADescarte(MovimientoDeBarajaADescarte movimientoDeBarajaADescarteController)
   {
     juegoView.interact(movimientoDeBarajaADescarteController);
   }
   
   public void visitMovimientoDescarteABaraja(MovimientoDescarteABaraja movimientoDescarteABarajaController)
   {
     juegoView.interact(movimientoDescarteABarajaController);
   }
   
   public void visitMovimientoDeDescarteAFundacion(controllers.MovimientoDeDescarteAFundacion movimientoDeDescarteAFundacionController)
   {
     juegoView.interact(movimientoDeDescarteAFundacionController);
   }
   
   public void visitMovimientoDeDescarteAEscalera(MovimientoDeDescarteAEscalera movimientoDeDescarteAEscaleraController)
   {
     juegoView.interact(movimientoDeDescarteAEscaleraController);
   }
   
   public void visitMovimientoDeEscaleraAFundacion(MovimientoDeEscaleraAFundacion MovimientoDeEscaleraAFundacionController)
   {
     juegoView.interact(MovimientoDeEscaleraAFundacionController);
   }
   
   public void visitMovimientoDeEscaleraAEscalera(MovimientoDeEscaleraAEscalera movimientoDeEscaleraAEscaleraController)
   {
     juegoView.interact(movimientoDeEscaleraAEscaleraController);
   }
   
   public void visitMovimientoDeFundacionAEscalera(MovimientoDeFundacionAEscalera MovimientoDeFundacionAEscaleraController)
   {
     juegoView.interact(MovimientoDeFundacionAEscaleraController);
   }
   
   public void showTheEndOfGameMessage()
   {
     new MessageView("Si has llegado aqui, felicatame pq no me lo creo").printMessage();
   }
 }