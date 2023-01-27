public class Factory {

    public static Carrinho criaCarrinho(String id){
        return new Carrinho(id);        
    }
    public static Cliente criaCliente(String nome,String id){
        return new Cliente(nome, id);
    }
    public static Produto criaProduto(String nome,String id,Double preco){
        return new Produto(preco, nome, id);
    }
    public static Catalogo criaCatalogo(){
        return Catalogo.getCatalogo();
    }

    
}
