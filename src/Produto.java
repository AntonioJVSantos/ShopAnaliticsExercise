public class Produto {  
    private double preco;
    private String nome;
    private String id;
    private int totalProduto;
    private int totalCarts;
    public Produto(double preco, String nome, String id) {
        this.preco = preco;
        this.nome = nome;
        this.id = id;
        this.totalCarts=0;
        this.totalProduto=0;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public double getPreco() {
        return preco;
    }
    public String getNome() {
        return this.nome;
    }
    public String getId() {
        return this.id;
    }
    public  void incrementaQuantidadeTotal(int quantidade){
        totalProduto=totalProduto+quantidade;        
    }
    public  void incrementaQuantidadeCarrinhos(){
        totalCarts=totalCarts+1;
    }
    public  void decrementaQuantidadeCarrinhos(){
        totalCarts=totalCarts-1;
    }
    public int getQuantidadeTotal(){
        return this.totalProduto;
    }
    public int getCarrinhosTotal(){
        return this.totalCarts;
    }
    
}
