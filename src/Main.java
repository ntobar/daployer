import Controller.Controller;
import Controller.IController;
import Visual.HomeView;

public class Main {

  //Cards.ICard card = new Cards.Card();



  public static void main(String[] args) {
    HomeView homeView = new HomeView();
    IController controller = new Controller(homeView);





  }

}
