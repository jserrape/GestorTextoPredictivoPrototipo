/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

/**
 *
 * @author jcsp0003
 * @param <P>
 * @param <S>
 */
public class Pair<P, S> {

    private final P left;
    private final S right;

    /**
     *
     * @param left
     * @param right
     */
    public Pair(P left, S right) {
        this.left = left;
        this.right = right;
    }

    /**
     *
     * @return
     */
    public P getLeft() {
        return left;
    }

    /**
     *
     * @return
     */
    public S getRight() {
        return right;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return left.hashCode() ^ right.hashCode();
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft()) && this.right.equals(pairo.getRight());
    }

}
