package threads;

import logic.Configuration;
import logic.GameBoard;

public class MainThread implements Runnable {
    static GameBoard gameBoard;
    private Thread mainThread;
    private static BornThread bornThread;
    private static DiedThread diedThread;
    private Frame frame;

    public MainThread() {
        frame = new Frame(this);
        Configuration.w = Integer.parseInt(frame.widthTextField.getText());
        Configuration.h = Integer.parseInt(frame.heightTextField.getText());
        gameBoard = new GameBoard();
        mainThread = new Thread(this, "Optional");
        mainThread.start();
    }

    @Override
    public void run() {
        bornThread = new BornThread();
        diedThread = new DiedThread();
    }

    public Frame getFrame() {
        return frame;
    }


    public Thread getMainThread() {
        return mainThread;
    }

    public BornThread getBornThread() {
        return bornThread;
    }

    public DiedThread getDiedThread() {
        return diedThread;
    }

    public void setBornThread(BornThread bornThread) {
        this.bornThread = bornThread;
    }

    public void setDiedThread(DiedThread diedThread) {
        this.diedThread = diedThread;
    }


}

