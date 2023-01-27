import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        
        Catalogo catalogo=Factory.criaCatalogo();        
        ArrayList<Cliente> clientes=new ArrayList<>();

        catalogo.addProduto(Factory.criaProduto("Banana","1", 1.00));
        catalogo.addProduto(Factory.criaProduto("Pera","2", 2.00));
        catalogo.addProduto(Factory.criaProduto("Manga","3", 3.00));
        catalogo.addProduto(Factory.criaProduto("Laranja","4", 4.00));
        catalogo.addProduto(Factory.criaProduto("Morango","5", 5.00));
        catalogo.printCatalogo();

        Cliente antonio=Factory.criaCliente("Antonio", "1");
        Cliente joao=Factory.criaCliente("Joao", "2");
        Cliente ricardo=Factory.criaCliente("Ricardo", "3");
        clientes.add(antonio);
        clientes.add(joao);
        clientes.add(ricardo);
        antonio.addCarrinho(criaCarrinhoAleatorio(3,"1"));
        antonio.addCarrinho(criaCarrinhoAleatorio(4,"2"));
        joao.addCarrinho(criaCarrinhoAleatorio(2, "3"));
        ricardo.addCarrinho(criaCarrinhoAleatorio(4, "4"));
        ricardo.addCarrinho(criaCarrinhoAleatorio(2, "5"));
        Checkout(clientes);
        Catalogo.getMaisVendidos(3); //passamos para o metodo o numero de entradas que queremos no nosso "top"
        
        }
public static void Checkout(ArrayList<Cliente> clientes){ // Lista os carrinhos por cada cliente, calcula a media total dos carrinhos e produtos
    for(Cliente cliente:clientes){
        cliente.printCarrinhos();
    }
    mediaTodosCarrinhos(clientes);
    mediaTodosOsProdutos(clientes);

}
public static Carrinho criaCarrinhoAleatorio(int numeroItems,String id){ // Gera um carrinho, recebe o numero de items que deve criar com quantidades aleatorias
    Carrinho carrinhotemp =Factory.criaCarrinho(id);
    Catalogo catalogo=Factory.criaCatalogo();
    for(int i=0;i<numeroItems;i++){
        int randomItem= ThreadLocalRandom.current().nextInt(1, catalogo.getSize()+1);
        int randomQuantidade= ThreadLocalRandom.current().nextInt(1, 21);
        carrinhotemp.addProduto(catalogo.getProdutoById(Integer.toString(randomItem)), randomQuantidade,id);
        }    
    return carrinhotemp;
    }
public static void mediaTodosCarrinhos(ArrayList<Cliente> clientes){ //Metodo Auxiliar para caulcuar a media de todos os carrinhos
    double media=0;
    double total=0;
    double numberCarts=0;
    for(Cliente cliente:clientes){
        numberCarts=numberCarts+cliente.getNumeroCarrinhos();
        total=total+cliente.getTotalCarrinhos();
    }
    media=total/numberCarts;
    System.out.println(" Temos "+numberCarts+" Carrinhos Valor total dos carrinhos "+total+" a media por carrinho é: "+media);
    }
public static void mediaTodosOsProdutos(ArrayList<Cliente> clientes){ //Metodo Auxiliar para caulcuar a media de todos os produtos
    double media=0;
    double total=0;
    double numberProducts=0;
    for(Cliente cliente:clientes){
        numberProducts=numberProducts+cliente.getNumeroProdutos();
        total=total+cliente.getTotalCarrinhos();
    }
    media=total/numberProducts;
    System.out.println(" Temos "+numberProducts+" Produtos Valor total dos Produtos "+total+" a media por produto é: "+media); 

   }

}
