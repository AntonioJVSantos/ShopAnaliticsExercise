import java.util.ArrayList;
public class Cliente {
    private String nome;
    private String id;
    private ArrayList<Carrinho> carrinhos;

    public Cliente(String nome,String id){
        this.nome=nome;
        this.id=id;
        this.carrinhos=new ArrayList<>();
    }

    public double getTotalCarrinhos(){
        double total=0;
        for(Carrinho carrinho:carrinhos){
            total+=carrinho.getTotalCarrinho();
        }
        return total ;
    }
    public void addCarrinho(Carrinho carrinho){
        this.carrinhos.add(carrinho);
    }
    public int getNumeroCarrinhos(){
        return carrinhos.size();
    }
    public double getMediaCarrinhos(){
        return getTotalCarrinhos()/carrinhos.size();
    }
    public void printCarrinhobyId(String idCarrinho){
        for(Carrinho carrinho:carrinhos){
            if(carrinho.getId().equals(idCarrinho)){
                carrinho.printToConsole();
                System.out.println("Custumer: "+this.nome+" has to pay : "+carrinho.getTotalCarrinho()+" For Cart ID: "+idCarrinho);
            }
        }
    }
    public void printCarrinhos(){
        System.out.println("  Listagem de carrinhos do cliente: "+this.nome);
        for(Carrinho carrinho:carrinhos){
            carrinho.printToConsole();
            System.out.println("Custumer: "+this.nome+" has to pay : "+carrinho.getTotalCarrinho()+" For Cart ID: "+carrinho.getId());
            
        }
    }
    public double getNumeroProdutos(){
        double total=0;
        for(Carrinho carrinho:carrinhos){
            total=carrinho.getNumeroProdutos()+total;
        }
        return total;
    }

    


}
