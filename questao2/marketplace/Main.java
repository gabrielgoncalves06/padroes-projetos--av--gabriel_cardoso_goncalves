public class Main {
    public static void main(String[] args) {
        System.out.println("Pedido Brasil:");
        new Checkout(new FabricaBrasil()).finalizar(100.0);
        System.out.println("\nPedido Alemanha:");
        new Checkout(new FabricaAlemanha()).finalizar(100.0);
    }
}
