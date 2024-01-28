class Fiets {
    private Frame frame = null;
    private String naam = "een fiets ding";

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        System.out.println("hi from Fiets toString!");
        return "Fiets{ frame=" + frame + ", naam='" + naam + "'}";
    }
}

class Frame {
    private Fiets fiets = null;
    private String naam = "een frame ding";

    public void setFiets(Fiets fiets) {
        this.fiets = fiets;
    }

    @Override
    public String toString() {
        System.out.println("hi from Frame toString!");
        return "Frame{fiets=" + fiets + ", naam='" + naam + "'}";
    }
}

public class BidiRec {
    public static void main(String[] args) {
        Fiets fiets = new Fiets();
        Frame frame = new Frame();
        fiets.setFrame(frame);
        frame.setFiets(fiets);
        System.out.println(fiets);  // why does it fail here??
    }
}