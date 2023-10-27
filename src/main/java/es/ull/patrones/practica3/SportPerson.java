package es.ull.patrones.practica3;

import es.ull.patrones.practica3.Elements.Ball;
import es.ull.patrones.practica3.Elements.Footwear;
import es.ull.patrones.practica3.Elements.TShirt;
import es.ull.patrones.practica3.Factories.SportFactory;

public class SportPerson {
    private Ball ball = null;
    private TShirt tshirt = null;
    private Footwear footwear = null;

    public SportPerson (SportFactory scf){
        this.ball = scf.createBall();
        this.tshirt = scf.createTShirt();
        this.footwear = scf.createFootwear();
    }

    public void showInfo(){
        ball.throwBall();
        tshirt.wearTShirt();
        footwear.putOn();
    }

}
