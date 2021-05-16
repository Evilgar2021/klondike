 package klondike;
 
import controllers.ActionController;
import controllers.Logica;
import views.ConsolaView;
import views.View;

 
 public class Klondike
 {
   Logica logica;
   View view;
   
   public Klondike()
   {
     logica = new Logica();
     view = new ConsolaView();
   }
   
   public void play()
   {
     ActionController controller;
     do {
       int optionSelected = view.interactWithMenu(logica.getMenuController());
       controller = logica.getActionController(optionSelected);
       if (controller != null) {
         view.interact(controller);
       }
       if (logica.isTheEnd()) {
         view.showTheEndOfGameMessage();
         controller = null;
       }
     } while (controller != null);
   }
   
   public static void main(String[] args) {
     Klondike klondike = new Klondike();
     klondike.play();
   }
 }
