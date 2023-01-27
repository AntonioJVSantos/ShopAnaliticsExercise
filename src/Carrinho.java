import java.util.HashMap;

public class Carrinho {
    private String id;
    private HashMap<Produto,Integer> produtos;
    public Carrinho(String id) {
        this.id = id;
        this.produtos= new HashMap<>();
    }

    public void addProduto(Produto produto,int quantidade, String id){
        int q=quantidade;        
        produto.incrementaQuantidadeCarrinhos();
        produto.incrementaQuantidadeTotal(quantidade);
        if(this.produtos.containsKey(produto)){            
            q=this.produtos.get(produto)+q;
            produto.decrementaQuantidadeCarrinhos();
        }
        this.produtos.put(produto, q);
        }    
    public double getTotalCarrinho(){
        double total=0;
        for(var entry:produtos.entrySet()){
            total=total+(entry.getKey().getPreco()*entry.getValue());
        }
        return total;
    }
    public void printToConsole(){
        if(produtos.isEmpty()){
            System.out.println("Carrinho com ID "+this.id+" Está Vazio");
        }
        for(var entry:produtos.entrySet()){
            System.out.println(entry.getValue()+" x "+entry.getKey().getNome()+" = "+entry.getKey().getPreco()*entry.getValue());
        }
    }
    public int getNumeroProdutos(){
        int numeroProdutos=0;
        for(var entry:produtos.entrySet()){
            numeroProdutos=entry.getValue()+numeroProdutos;
        }
        return numeroProdutos;
    }
    public Produto getTopSeller(){
        int top=0;
        Produto topProd=null;
        for(var entry:produtos.entrySet()){
            if(entry.getValue()>top){
                top=entry.getValue();
                topProd=entry.getKey();
            }
        }
        return topProd;
    }
    public String getId(){
        return this.id;
    }
    
}
