import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo {

    private static HashMap<String, Produto> produtos;
    private static ArrayList<Produto> maisVendidos;
    private static Catalogo catalogoUnico=null;
    
    private Catalogo(){
        this.produtos=new HashMap<>();
        this.maisVendidos= new ArrayList<>();
    }
    public static Catalogo getCatalogo(){
        if(catalogoUnico==null){
            catalogoUnico=new Catalogo();
        }
        return catalogoUnico;
    }
    public void addProduto(Produto produto){
        if(produtos.containsKey(produto.getId())){
            System.out.println("ID: "+produto.getId()+" duplicado impossivel Adicionar");
        }
        else{
            this.produtos.put(produto.getId(), produto);
        }
    }
    public void printCatalogo(){
        System.out.println("Listagem do Catalogo com os Produtos disponiveis");
        for(var entry:this.produtos.entrySet()){
            System.out.println("ID: "+entry.getKey()+" Produto: "+entry.getValue().getNome()+" Preço: "+entry.getValue().getPreco());
        }
    }
    public Produto getProdutoById(String id){
        if(produtos.containsKey(id)){
            return produtos.get(id);
        }
        else{
            return null;
            }
        }
    public int getSize(){
        return produtos.size();
    }
    public static void getMaisVendidos(int quantos){
        ArrayList<Produto> TopSellers= new ArrayList<>();
        ArrayList<Produto> temporaria=new ArrayList<>();
        int valorMax=0;
        Produto max=null;
        for(var entry:produtos.entrySet()){
            temporaria.add(entry.getValue());
        }
        if(quantos>=temporaria.size()){
            quantos=temporaria.size();
        }
        int i=0;
        while( i<quantos){
            for(Produto produto:temporaria){
                if(produto.getQuantidadeTotal()>valorMax){
                    valorMax=produto.getQuantidadeTotal();
                    max=produto;                   
                    }  
                }
            TopSellers.add(max);
            temporaria.remove(max);
            valorMax=0;
            max=null;
            i++;      

            }            
        System.out.println("our top "+quantos+" selling Products");    
        for(Produto p:TopSellers){
            System.out.println(p.getNome()+" "+p.getQuantidadeTotal()+" units, present in "+p.getCarrinhosTotal()+" Carrinhos");
        }
    }
}

    

