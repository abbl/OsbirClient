package pl.bbl.osbir.engine.tools;

/**
 * it triggers a method after certain condition becomes true.
 * It checks this condition every second.
 */
public abstract class ConditionalTrigger {
    public void start(){
        new Thread(){
            @Override
            public synchronized void run() {
                while (!isConditionTrue()){
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                doSomething();
            }
        }.start();
    }
    protected abstract boolean isConditionTrue();
    protected abstract void doSomething();
}
