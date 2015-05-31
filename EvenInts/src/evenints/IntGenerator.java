/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenints;

/**
 *
 * @author sanket
 */
public abstract class IntGenerator {
    private volatile boolean canceled;
    public abstract int next();
    
    public void cancel() { canceled = true; }
    public boolean isCanceled() { return canceled; }
    
}
