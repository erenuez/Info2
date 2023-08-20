package Anfaenger.ab2;

public class Paar<T> implements iObject<T>{
    private T objectA;
    private T objectB;

    public Paar(T objectA, T objectB){
        this.objectA = objectA;
        this.objectB = objectB;
    }

    @Override
    public T getObjectA(){
        return this.objectA;
    }

    @Override
    public T getObjectB(){
        return this.objectB;
    }

    @Override
    public void setObjectA(T objectA){
        this.objectA = objectA;
    }

    @Override
    public void setObjectB(T objectB){
        this.objectB = objectB;
    }
}
