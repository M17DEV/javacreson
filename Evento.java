package Olimpiadas;
public class Evento {
    private static final double VALOR_DEFAULT_INGRESSO = 100.0;
    private static final int CAPACIDADE_DEFAULT = 3000;
    private static final int QTD_INGRESSOS_VENDA_DEFAULT = 2;

    private static int proximoCodigo = 1;

    private int codigo;
    private String titulo;
    private String local;
    private String data;
    private String hora;
    private int capacidade;
    private int lugaresVendidos;
    private double valorIngresso;
    private String status;

    // Constructors
    public Evento(String titulo, String local, String data, String hora, int capacidade, double valorIngresso) {
        this.codigo = proximoCodigo++;
        this.titulo = titulo;
        this.local = local;
        this.data = data;
        this.hora = hora;
        this.capacidade = capacidade;
        this.lugaresVendidos = 0;
        this.valorIngresso = valorIngresso;
        this.status = "Vendas não iniciadas";
    }

    public Evento(String titulo, String local, String data, String hora, int capacidade) {
        this(titulo, local, data, hora, capacidade, VALOR_DEFAULT_INGRESSO);
    }

    // Getters and setters
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getLugaresVendidos() {
        return lugaresVendidos;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public String getStatus() {
        return status;
    }

    // Methods
    public void venda(int quantidade) {
        if (status.equals("Vendas iniciadas") && lugaresVendidos + quantidade <= capacidade) {
            lugaresVendidos += quantidade;
            System.out.println(quantidade + " ingresso(s) vendido(s) com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a venda dos ingressos.");
        }
    }

    public void venda() {
        venda(QTD_INGRESSOS_VENDA_DEFAULT);
    }

    public int qtdLugarLivre() {
        return capacidade - lugaresVendidos;
    }

    public void iniciarVenda() {
        if (status.equals("Vendas não iniciadas")) {
            status = "Vendas iniciadas";
            System.out.println("Venda de ingressos iniciada para o evento.");
        } else {
            System.out.println("A venda de ingressos já foi iniciada anteriormente.");
        }
    }

    public void finalizarVenda() {
        if (status.equals("Vendas iniciadas")) {
            status = "Vendas encerradas";
            System.out.println("Venda de ingressos encerrada para o evento.");
        } else {
            System.out.println("A venda de ingressos já foi encerrada anteriormente.");
        }
    }

    public void cancelarEvento() {
        status = "Cancelado";
        System.out.println("Evento cancelado.");
    }

    public void marcarComoOcorrido() {
        status = "Ocorrido";
        System.out.println("Evento marcado como ocorrido.");
    }
}

